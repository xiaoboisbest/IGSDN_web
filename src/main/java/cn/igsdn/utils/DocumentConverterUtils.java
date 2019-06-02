package cn.igsdn.utils;

import com.youbenzi.mdtool.tool.MDTool;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.jodconverter.JodConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class DocumentConverterUtils {
    public static String openOffice_HOME = ConfigUtils.getValue("office.home");
    public static String resource = ConfigUtils.getValue("resource");
    public static BufferedImage watermarkBufferedImage;

    static {
        watermarkBufferedImage = getBufferedImage("utils\\watermark.png");
    }

    public static BufferedImage getBufferedImage(String src) {
        try {
            StringBuilder stringBuilder = new StringBuilder(resource);
            stringBuilder.append("\\icon\\");
            stringBuilder.append(src);
            System.out.println(stringBuilder.toString());
            BufferedImage image = ImageIO.read(new File(stringBuilder.toString()));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将office格式的文件转化成pdf
     *
     * @param input
     * @param output
     * @return
     */
    public static Boolean officeToPdf(String input, String output) {
        File outputFile = new File(output);
        // 检查Pdf是否存在：若存在，则读取它；否则，写入。
        if (outputFile.exists()) {
            System.out.println("log: '" + output + "' has already exists!");
            return true;
        } else {
            System.out.println("log: officeToPdf: '" + input + "' ==> '" + output + "'");
            File inputFile = new File(input);
            OfficeManager officeManager = null;
            try {
                officeManager = LocalOfficeManager.builder().install()
                        .portNumbers(8100)
                        .officeHome(openOffice_HOME)
                        .build();
                officeManager.start();
                JodConverter.convert(inputFile).to(outputFile).execute();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    officeManager.stop();
                } catch (OfficeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将pdf转化成BufferedImage集合
     * pageNum = 1, pageSize = 3, return 0,1,2
     * pageNum = 2, pageSize = 3, return 3,4,5
     *
     * @param input
     * @param output
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static List<BufferedImage> pdfToImages(String input, String output, int pageNum, int pageSize) {
        List<BufferedImage> list = new ArrayList<BufferedImage>();

        File imagesFile = new File(output);
        // 检查图片文件夹是否存在：若存在，则读取它；否则，写入。
        try {
            if (imagesFile.exists()) {
                int len = imagesFile.listFiles().length;
                System.out.println("log: '" + output + "' imagesFile has already exists, and image's number is " + len + " !");
            } else {
                System.out.println("log: pdfToImages: '" + input + "' ==> '" + output + "'");
                imagesFile.mkdirs();
                File file = new File(input);
                PDDocument doc = PDDocument.load(file);
                PDFRenderer renderer = new PDFRenderer(doc);
                int pageCount = doc.getNumberOfPages();
                for (int i = 0; i < pageCount; i++) {
                    BufferedImage image = renderer.renderImageWithDPI(i, 200);
                    image = addWaterMark(image, watermarkBufferedImage);
                    ImageIO.write(image, "JPEG", new File(output + "\\" + i + ".jpg"));
                    list.add(image);
                }
                doc.close();
            }
            int startNum = (pageNum - 1) * pageSize;
            for (int i = 0; i < pageSize; i++) {
                int now = startNum + i;
                File imageFile = new File(output + "\\" + now + ".jpg");
                if (!imageFile.exists()) {
                    break;
                }
                list.add(ImageIO.read(new File(output + "\\" + now + ".jpg")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * markdown格式转Html
     *
     * @param input
     * @param output
     * @return
     */
    public static String markdownToHtml(String input, String output) {
        String res = null;
        File outputFile = new File(output);
        // 检查Pdf是否存在：若存在，则读取它；否则，写入。
        try {
            if (outputFile.exists()) {
                System.out.println("log: '" + output + "' has already exists!");
                StringBuilder sBuilder = new StringBuilder();
                BufferedReader br = new BufferedReader(new FileReader(outputFile));
                String s;
                while ((s = br.readLine()) != null) {
                    sBuilder.append(s);
                }
                br.close();
                res = sBuilder.toString();
            } else {
                System.out.println("log: markdownToHtml: '" + input + "' ==> '" + output + "'");
                res = MDTool.markdown2Html(new File(input));
                outputFile.createNewFile();
                PrintWriter printWriter = new PrintWriter(new FileWriter(outputFile, true), true);
                printWriter.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 读取markdown
     *
     * @param input
     * @return
     */
    public static String markdownToString(String input) {
        System.out.println("log: markdownToString: '" + input + "' ==> String");
        String res = null;
        try {
            res = MDTool.markdown2Html(new File(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 将BufferedImage转化为base64的数据，用于传递到前端显示
     *
     * @param bufferedImage
     * @return
     */
    public static String bufferedImageToBase64(BufferedImage bufferedImage) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "PNG", bos);
            byte[] imageBytes = bos.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    /**
     * 图片加水印
     *
     * @param srcBufferedImage
     * @param logoBufferedImage
     * @return
     */
    public static BufferedImage addWaterMark(BufferedImage srcBufferedImage, BufferedImage logoBufferedImage) {
        OutputStream os = null;
        try {
            Graphics2D graphics = srcBufferedImage.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            graphics.drawImage(srcBufferedImage.getScaledInstance(srcBufferedImage.getWidth(null),
                    srcBufferedImage.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

            //水印位置
            graphics.drawImage(logoBufferedImage, srcBufferedImage.getWidth() / 3, srcBufferedImage.getHeight() / 2, null);
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            graphics.dispose();

            return srcBufferedImage;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 将base64转为文件，保存到指定路径
     *
     * @param base64
     * @param userId
     * @param isPublic
     * @param type
     * @param fileName
     * @return
     */
    public static String Base64ToFile(String base64, Integer userId, Boolean isPublic, String type, String fileName, String suffix) {
        StringBuilder filePath = new StringBuilder(resource);
        filePath.append(type);
        filePath.append("\\");
        StringBuilder res = new StringBuilder();
        res.append(isPublic ? "public" : "private");
        res.append("\\users\\");
        res.append(userId);
        res.append("\\");

        filePath.append(res);
        File file = new File(filePath.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        filePath.append(fileName);
        res.append(fileName);
        String[] temp = base64.split(";");
        if (!StringUtils.isNotBlank(suffix)) {
            suffix = "." + temp[0].split("/")[1];
        }
        filePath.append(suffix);
        res.append(suffix);
        try {
            base64 = temp[1].split(",")[1];
            System.out.println(base64);
            deleteFile(filePath.toString());
            System.out.println(filePath.toString());

            Files.write(Paths.get(filePath.toString()), Base64.getMimeDecoder().decode(base64), StandardOpenOption.CREATE);

//            Files.write(Paths.get(filePath.toString()), Base64.getDecoder().decode(base64), StandardOpenOption.CREATE);
            System.out.println("文件创建成功！");
            return res.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteImgFolder(Integer documentId) {
        StringBuilder stringBuilder = new StringBuilder(resource);
        stringBuilder.append("online\\img\\");
        stringBuilder.append(documentId);
        File dirFile = new File(stringBuilder.toString());
        // 判断目录是否存在
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return;
        }
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件
            if (files[i].isFile()) {
                deleteFile(files[i].getAbsolutePath());
            }
        }

        dirFile.delete(); //删除当前目录
    }

    public static void deleteFile(String src) {
        File file = new File(src);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }

    public static void deleteFile(String type, String src) {
        StringBuilder stringBuilder = new StringBuilder(resource);
        stringBuilder.append(type);
        stringBuilder.append("\\");
        stringBuilder.append(src);
        File file = new File(stringBuilder.toString());
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }

    public static String getDocumentUrl(String src) {
        StringBuilder stringBuilder = new StringBuilder(resource);
        stringBuilder.append("document\\");
        stringBuilder.append(src);
        return stringBuilder.toString();
    }
}
