package cn.igsdn.service.impl;


import cn.igsdn.dao.DocumentFormatMapper;
import cn.igsdn.dao.DocumentMapper;
import cn.igsdn.dao.UserMapper;
import cn.igsdn.domain.Document;
import cn.igsdn.domain.DocumentExample;
import cn.igsdn.domain.DocumentFormat;
import cn.igsdn.domain.User;
import cn.igsdn.dto.DocumentDTO;
import cn.igsdn.dto.SimpleDocumentDTO;
import cn.igsdn.service.DocumentService;
import cn.igsdn.utils.DocumentConverterUtils;
import cn.igsdn.utils.PageHelper;
import cn.igsdn.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
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
        if (query != null) { // 若查询条件不为空，根据空格截取查询条件，分别生成DocumentExample.Criteria
            queryList = Arrays.asList(query.split("\\s+"));
            queryList = new ArrayList<>(queryList); // 数
            for (String queryString : queryList) {
                StringBuilder queryBuilder = new StringBuilder("%");
                queryBuilder.append(queryString);
                queryBuilder.append("%");
                addDocumentExampleCriteria(example, queryBuilder.toString(), "name", type, userId, categoryId);
                addDocumentExampleCriteria(example, queryBuilder.toString(), "intro", type, userId, categoryId);
            }
        } else {
            addDocumentExampleCriteria(example, null, null, type, userId, categoryId);
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
            simpleDocumentDTO.setSize(document.getSize());
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
        documentDTO.setSize(document.getSize());
        documentDTO.setUploadTime(DateFormat.getDateInstance().format(document.getUploadTime()));
        documentDTO.setLastUpdateTime(DateFormat.getDateInstance().format(document.getLastUpdateTime()));
        documentDTO.setKey1(document.getKey1());
        documentDTO.setKey2(document.getKey2());
        documentDTO.setKey3(document.getKey3());
        documentDTO.setIntro(document.getIntro());
        DocumentFormat documentFormat = documentFormatMapper.selectByPrimaryKey(document.getFormat());
        documentDTO.setFormatId(document.getFormat());
        documentDTO.setFormatName(documentFormat.getName());
        documentDTO.setUploaderName(userMapper.selectByPrimaryKey(document.getUploader()).getUname());
        documentDTO.setDownloadNum(StringUtils.formatDownloadNum(document.getDownloadNum()));
        String icon = document.getIconSrc();
        if (StringUtils.isNotBlank(icon)) {
            BufferedImage bufferedImage = DocumentConverterUtils.getBufferedImage(icon);
            icon = DocumentConverterUtils.bufferedImageToBase64(bufferedImage);
        }
        documentDTO.setIcon(icon);
        return documentDTO;
    }
}
