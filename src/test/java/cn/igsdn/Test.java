package cn.igsdn;

<<<<<<< HEAD
import cn.igsdn.utils.DocumentConverterUtils;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider;

import java.awt.image.BufferedImage;
import java.net.URL;

public class Test {
    public static void main(String[] args) {
        BufferedImage bufferedImage = DocumentConverterUtils.getBufferedImage("E:\\IGSDN_resource\\default\\icon_pdf.png");
        String s = DocumentConverterUtils.bufferedImageToBase64(bufferedImage);
        System.out.println(s);
=======
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        add(1, list);
        System.out.println(list.size());
    }

    public static void add(Integer i, List<Integer> list){
        list.add(i);
>>>>>>> pr/5
    }
}
