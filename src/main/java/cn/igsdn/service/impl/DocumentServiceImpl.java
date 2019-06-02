package cn.igsdn.service.impl;


import cn.igsdn.dao.DocumentFormatMapper;
import cn.igsdn.dao.DocumentMapper;
import cn.igsdn.dao.UserMapper;
import cn.igsdn.domain.Document;
import cn.igsdn.domain.DocumentExample;
import cn.igsdn.domain.DocumentFormat;
import cn.igsdn.domain.User;
import cn.igsdn.dto.DocumentDTO;
import cn.igsdn.dto.DocumentDTO2;
import cn.igsdn.dto.SimpleDocumentDTO;
import cn.igsdn.service.CategoryService;
import cn.igsdn.service.DocumentService;
import cn.igsdn.utils.DocumentConverterUtils;
import cn.igsdn.utils.PageHelper;
import cn.igsdn.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.util.*;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    DocumentMapper documentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    DocumentFormatMapper documentFormatMapper;

    public PageHelper<SimpleDocumentDTO> getDocumentPage(String type, Map<String, String> map) {
        String query = map.get("query"); // 查询条件
        Integer userId = Integer.parseInt(map.get("userId")); // 用户id
        String categoryIdString = map.get("categoryId"); // 类型
        Integer categoryId = categoryIdString == null ? null : Integer.parseInt(categoryIdString);
        Integer currentPage = Integer.parseInt(map.get("currentPage")); // 当前页
        Integer pageSize = Integer.parseInt(map.get("pageSize")); // 每页大小

        PageHelper<SimpleDocumentDTO> pageHelper = new PageHelper<>();
        pageHelper.setCurrentPage(currentPage);
        pageHelper.setPageSize(pageSize);
        DocumentExample example = new DocumentExample();
        query = StringUtils.isNotBlank(query) ? query : null;
        List<String> queryList = null;
        List<Integer> categoryIdList;
        if (categoryId == null) {
            categoryIdList = new ArrayList<>();
            categoryIdList.add(null);
        } else
            categoryIdList = categoryService.listAllCategory(categoryId);
        for (Integer id : categoryIdList) {
            if (query != null) { // 若查询条件不为空，根据空格截取查询条件，分别生成DocumentExample.Criteria
                queryList = Arrays.asList(query.split("\\s+"));
                queryList = new ArrayList<>(queryList);
                for (String queryString : queryList) {
                    StringBuilder queryBuilder = new StringBuilder("%");
                    queryBuilder.append(queryString);
                    queryBuilder.append("%");
                    addDocumentExampleCriteria(example, queryBuilder.toString(), "name", type, userId, id);
                    addDocumentExampleCriteria(example, queryBuilder.toString(), "intro", type, userId, id);
                }
            } else {
                addDocumentExampleCriteria(example, null, null, type, userId, id);
            }
        }
        pageHelper.setTotal(documentMapper.countByExample(example));
        example.setOrderByClause("last_update_time DESC, download_num DESC, upload_time DESC, ID DESC");
        example.setStartRow((currentPage - 1) * pageSize);
        example.setPageSize(pageSize);
        List<Document> list = documentMapper.selectByExample(example);

        List<SimpleDocumentDTO> data = new ArrayList<>();
        for (Document document : list) {
            Integer uploaderId = document.getUploader();
            Integer formatId = document.getFormat();
            User user = userMapper.selectByPrimaryKey(uploaderId);
            SimpleDocumentDTO simpleDocumentDTO = new SimpleDocumentDTO();
            simpleDocumentDTO.setId(document.getId());
            simpleDocumentDTO.setDownloadNum(StringUtils.formatDownloadNum(document.getDownloadNum()));
            simpleDocumentDTO.setIntro(StringUtils.renderStringInHtml(true, document.getIntro(), queryList));
            simpleDocumentDTO.setName(StringUtils.renderStringInHtml(false, document.getName(), queryList));
            simpleDocumentDTO.setLastUpdateTime(DateFormat.getDateInstance().format(document.getLastUpdateTime()));
            simpleDocumentDTO.setUploadTime(DateFormat.getDateInstance().format(document.getUploadTime()));
            simpleDocumentDTO.setSize(StringUtils.formatDocumentSize(document.getSize()));
            simpleDocumentDTO.setUploaderName(user.getUname());
            simpleDocumentDTO.setIcon(formatId);
            simpleDocumentDTO.setPublic(document.getIsPublic());
            System.out.println(simpleDocumentDTO);
            data.add(simpleDocumentDTO);
        }
        pageHelper.setData(data);
        return pageHelper;
    }

    protected void addDocumentExampleCriteria(DocumentExample example, String queryString, String queryField, String type, Integer userId, Integer categoryId) {
        boolean isFirst = false;
        if (example.getOredCriteria().size() == 0) {
            isFirst = true;
        }
        DocumentExample.Criteria criteria = example.createCriteria();
        if (categoryId != null) {
            criteria.andCategoryEqualTo(categoryId);
        }
        if ("private".equals(type)) {
            criteria.andUploaderEqualTo(userId);
        } else if ("public".equals(type)) {
            criteria.andIsPublicEqualTo(true);
        }
        if (queryString != null) {
            if ("name".equals(queryField))
                criteria.andNameLike(queryString);
            else if ("intro".equals(queryField))
                criteria.andIntroLike(queryString);
        }
        if (!isFirst) {
            example.or(criteria);
        }
    }

    @Override
    public String getDocumentFormatIconBase4ByPrimaryKey(Integer formatId) {
        DocumentFormat documentFormat = documentFormatMapper.selectByPrimaryKey(formatId);
        BufferedImage bufferedImage = DocumentConverterUtils.getBufferedImage(documentFormat.getDefaultIconSrc());
        return DocumentConverterUtils.bufferedImageToBase64(bufferedImage);
    }

    @Override
    public DocumentDTO getDocumentDetailsByPrimaryKey(Integer documentId) {
        Document document = documentMapper.selectByPrimaryKey(documentId);
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setId(document.getId());
        documentDTO.setName(document.getName());
        documentDTO.setSize(StringUtils.formatDocumentSize(document.getSize()));
        documentDTO.setUploadTime(DateFormat.getDateInstance().format(document.getUploadTime()));
        documentDTO.setLastUpdateTime(DateFormat.getDateInstance().format(document.getLastUpdateTime()));
        documentDTO.setKey1(document.getKey1());
        documentDTO.setKey2(document.getKey2());
        documentDTO.setKey3(document.getKey3());
        documentDTO.setIntro(document.getIntro());
        DocumentFormat documentFormat = documentFormatMapper.selectByPrimaryKey(document.getFormat());
        documentDTO.setFormatId(document.getFormat());
        documentDTO.setFormatName(documentFormat.getName());
        documentDTO.setUploaderId(document.getUploader());
        documentDTO.setUploaderName(userMapper.selectByPrimaryKey(document.getUploader()).getUname());
        documentDTO.setDownloadNum(StringUtils.formatDownloadNum(document.getDownloadNum()));
        documentDTO.setUrl(DocumentConverterUtils.getDocumentUrl(document.getSrc()));
        System.out.println("??????"+documentDTO.getUrl());
        String icon = document.getIconSrc();
        if (StringUtils.isNotBlank(icon)) {
            BufferedImage bufferedImage = DocumentConverterUtils.getBufferedImage(icon);
            icon = DocumentConverterUtils.bufferedImageToBase64(bufferedImage);
        }
        documentDTO.setIcon(icon);
        return documentDTO;
    }

    @Override
    public DocumentDTO2 getDocumentDetailsBeforeUpdateByPrimaryKey(Integer documentId) {
        Document document = documentMapper.selectByPrimaryKey(documentId);
        DocumentDTO2 documentDTO2 = new DocumentDTO2();
        documentDTO2.setName(document.getName());
        documentDTO2.setKey1(document.getKey1());
        documentDTO2.setKey2(document.getKey2());
        documentDTO2.setKey3(document.getKey3());
        documentDTO2.setCategory(document.getCategory());
        documentDTO2.setPublic(document.getIsPublic());
        documentDTO2.setIntro(document.getIntro());
        String icon = document.getIconSrc();
        if (StringUtils.isNotBlank(icon)) {
            BufferedImage bufferedImage = DocumentConverterUtils.getBufferedImage(icon);
            icon = DocumentConverterUtils.bufferedImageToBase64(bufferedImage);
        }
        documentDTO2.setIconSrc(icon);
        return documentDTO2;
    }

    @Override
    public Boolean insertDocument(Document document) {
        String srcBase64 = document.getSrc();
        String suffix = documentFormatMapper.selectByPrimaryKey(document.getFormat()).getSuffix();
        String src = DocumentConverterUtils.Base64ToFile(srcBase64, document.getUploader(), document.getIsPublic(), "document", document.getName(), suffix);
        document.setSrc(src);
        document.setSize(document.getSize() / 1024);

        String iconSrcBase64 = document.getIconSrc();
        String iconSrc = null;
        if (StringUtils.isNotBlank(iconSrcBase64))
            iconSrc = DocumentConverterUtils.Base64ToFile(iconSrcBase64, document.getUploader(), document.getIsPublic(), "icon", document.getName(), null);
        document.setIconSrc(iconSrc);
        Date date = new Date();
        document.setUploadTime(date);
        document.setLastUpdateTime(date);
        documentMapper.insertSelective(document);
        return true;
    }

    @Override
    public Boolean deleteDocumentByPrimaryKey(Integer documentId) {
        Document document = documentMapper.selectByPrimaryKey(documentId);
        if (document != null) {
            String src = document.getSrc();
            DocumentConverterUtils.deleteFile("document", src);
            StringBuilder pdfSrcBuilder = new StringBuilder(DocumentConverterUtils.resource);
            pdfSrcBuilder.append("online\\pdf\\users\\");
            pdfSrcBuilder.append(documentId);
            pdfSrcBuilder.append(".pdf");
            System.out.println(pdfSrcBuilder.toString());
            DocumentConverterUtils.deleteFile(pdfSrcBuilder.toString());
            DocumentConverterUtils.deleteImgFolder(documentId);
            int res = documentMapper.deleteByPrimaryKey(documentId);
            if (res > 0)
                return true;
            return false;
        }
        return null;
    }

    @Override
    public Boolean updateDocumentByPrimaryKey(Document document) {
        String iconSrcBase64 = document.getIconSrc();
        String iconSrc = null;
        if (StringUtils.isNotBlank(iconSrcBase64))
            iconSrc = DocumentConverterUtils.Base64ToFile(iconSrcBase64, document.getUploader(), document.getIsPublic(), "icon", document.getName(), null);
        document.setIconSrc(iconSrc);
        Date date = new Date();
        document.setLastUpdateTime(date);
        System.out.println(document);
        DocumentExample example = new DocumentExample();
        DocumentExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(document.getId());
        int res = documentMapper.updateByExampleSelective(document, example);
        if (res > 0)
            return true;
        else
            return false;
    }
}
