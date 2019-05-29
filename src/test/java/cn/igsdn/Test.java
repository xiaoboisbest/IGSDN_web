package cn.igsdn;

import cn.igsdn.utils.DocumentConverterUtils;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider;

import java.awt.image.BufferedImage;
import java.net.URL;

public class Test {
    public static void main(String[] args) {
        BufferedImage bufferedImage = DocumentConverterUtils.getBufferedImage("E:\\IGSDN_resource\\default\\icon_pdf.png");
        String s = DocumentConverterUtils.bufferedImageToBase64(bufferedImage);
        System.out.println(s);
    }
}
