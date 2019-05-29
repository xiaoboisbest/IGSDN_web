package cn.igsdn.test;

import cn.igsdn.utils.DocumentConverterUtils;

import java.awt.image.BufferedImage;

public class Test {
    public static void main(String[] args) {
        BufferedImage bufferedImage = DocumentConverterUtils.getBufferedImage("default\\icon_pdf.jpg");
        String s = DocumentConverterUtils.bufferedImageToBase64(bufferedImage);
        System.out.println(s);
    }
}
