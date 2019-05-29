package cn.igsdn.service.impl;

import cn.igsdn.dao.DocumentFormatMapper;
import cn.igsdn.dao.DocumentMapper;
import cn.igsdn.domain.Document;
import cn.igsdn.service.DocumentPreview;
import cn.igsdn.utils.ConfigUtils;
import cn.igsdn.utils.DocumentConverterUtils;
import cn.igsdn.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service("documentPreview")
public class DocumentPreviewImpl implements DocumentPreview {
    @Autowired
    DocumentMapper documentMapper;
    @Autowired
    DocumentFormatMapper documentFormatMapper;
    private static String documentPath = "document\\";

    public List<String> documentOnlinePreview(String documentId, String documentType, String documentUrl, String pageNum, String pageSize) {
        Integer documentKey = null;
        Integer documentTypeKey = null;
        if (StringUtils.isNotBlank(documentId)) {
            documentKey = Integer.parseInt(documentId);
        }
        if (StringUtils.isNotBlank(documentType)) {
            documentTypeKey = Integer.parseInt(documentType);
        }
        if (documentKey == null || documentTypeKey == null) {
            Document document = documentMapper.selectByPrimaryKey(documentKey);
            documentTypeKey = document.getFormat();
            documentUrl = document.getSrc();
        }
        String typeName = documentFormatMapper.selectByPrimaryKey(documentTypeKey).getName();
        StringBuilder documentUrlStringBuilder = new StringBuilder(ConfigUtils.getValue("resource"));
        documentUrlStringBuilder.append(documentPath);
        documentUrlStringBuilder.append(documentUrl);
        int pageNumInteger = Integer.parseInt(pageNum);
        int pageSizeInteger = Integer.parseInt(pageSize);
        if (StringUtils.isOffice(typeName))
            return officeDocumentOnlinePreview(documentKey, documentUrlStringBuilder.toString(), pageNumInteger, pageSizeInteger);
        else if (typeName.equals("pdf"))
            return pdfDocumentOnlinePreview(documentKey, documentUrlStringBuilder.toString(), pageNumInteger, pageSizeInteger);
        else if (typeName.equals("markdown"))
            return markdownDocumentOnlinePreview(documentUrlStringBuilder.toString());
        return null;
    }

    public List<String> officeDocumentOnlinePreview(int documentId, String documentUrl, int pageNum, int pageSize) {
        StringBuilder newPdfUrl = new StringBuilder();
        newPdfUrl.append(ConfigUtils.getValue("resource"));
        newPdfUrl.append("online\\pdf\\users\\");
        newPdfUrl.append(documentId);
        newPdfUrl.append(".pdf");
        Boolean res = DocumentConverterUtils.officeToPdf(documentUrl, newPdfUrl.toString());
        if (res != null && res) {
            return pdfDocumentOnlinePreview(documentId, newPdfUrl.toString(), pageNum, pageSize);
        }
        return null;
    }

    public List<String> pdfDocumentOnlinePreview(int documentId, String documentUrl, int pageNum, int pageSize) {
        List<String> list = new ArrayList<>();
        list.add("images");
        StringBuilder sResource = new StringBuilder(ConfigUtils.getValue("resource"));
        StringBuilder imagePath = new StringBuilder().append(sResource);
        imagePath.append("online\\img\\");
        imagePath.append(documentId);
        List<BufferedImage> bufferedImages = DocumentConverterUtils.pdfToImages(documentUrl, imagePath.toString(), pageNum, pageSize);

        for (BufferedImage bufferedImage : bufferedImages) {
            list.add(DocumentConverterUtils.bufferedImageToBase64(bufferedImage));
        }
        return list;
    }

    @Override
    public String getMarkdownContent(Integer documentId) {
        return markdownDocumentOnlinePreview(getDocumentUrlByPrimaryKey(documentId)).get(1);
    }

    @Override
    public Boolean updateMarkdownContent(Integer documentId, String content) {
        String url = getDocumentUrlByPrimaryKey(documentId);
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(url);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes("utf-8"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getDocumentUrlByPrimaryKey(Integer documentId) {
        Document document = documentMapper.selectByPrimaryKey(documentId);
        String src = document.getSrc();
        StringBuilder sResource = new StringBuilder(ConfigUtils.getValue("resource"));
        sResource.append(documentPath);
        sResource.append(src);
        return sResource.toString();
    }

    @Override
    public List<String> markdownDocumentOnlinePreview(String documentUrl) {
        List<String> list = new ArrayList<>();
        list.add("markdown");
        StringBuilder sBuilder = new StringBuilder();
        BufferedReader br = null;
        try {
            FileInputStream in = new FileInputStream(documentUrl);
            br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String s;
            while ((s = br.readLine()) != null) {
                sBuilder.append(s + "\n");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.add(sBuilder.toString());
        return list;
    }

}
