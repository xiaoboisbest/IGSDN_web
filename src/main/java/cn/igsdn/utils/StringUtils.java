package cn.igsdn.utils;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String TEL_STRING = "tel";
    public static final String EMAIL_STRING = "email";
    public static final String MATCH_TEL_STRING = "^1[3456789]\\d{9}$";
    public static final String MATCH_EMAIL_STRING = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    public static final String OFFICE[] = {"word", "doc", "docx", "ppt", "pptx", "xls", "xlsx"};
    public static Integer SIZE_B = 1024;
    public static Integer SIZE_KB = SIZE_B * 1024;
    public static Integer SIZE_MB = SIZE_KB * 1024;

    private StringUtils() {

    }

    // 检查字符串是什么类型
    public static String checkStringType(String s) {
        if (Pattern.matches(MATCH_TEL_STRING, s)) {
            return TEL_STRING;
        } else if (Pattern.matches(MATCH_EMAIL_STRING, s)) {
            return EMAIL_STRING;
        } else {
            return null;
        }
    }

    // 登录名格式是否正确
    public static boolean isloginName(String loginName) {
        String stringType = checkStringType(loginName);
        if (stringType.equals(TEL_STRING) || stringType.equals(EMAIL_STRING)) {
            return true;
        }
        return false;
    }

    // 验证字符串非空
    public static boolean isNotBlank(String s) {
        if (s == null || s.trim().equals("")) {
            return false;
        }
        return true;
    }

    // 验证是否为office
    public static boolean isOffice(String s) {
        for (String s1 : OFFICE) {
            if (s1.equals(s))
                return true;
        }
        return false;
    }

    /**
     * 将下载数（Long）格式化为字符串（String）
     *
     * @param downloadNum
     * @return
     */
    public static String formatDownloadNum(Long downloadNum) {
        if (downloadNum < 1000)
            return downloadNum.toString();
        else if (downloadNum < 10000) {
            return downloadNum.toString() + "K+";
        } else {
            downloadNum = downloadNum / 10000;
            return downloadNum.toString() + "W+";
        }
    }

    public static String formatDocumentSize(Number size) {
        StringBuilder stringBuilder = new StringBuilder();
        if (size instanceof Double) {
            Double sizeDouble = (Double) size;
            DecimalFormat df = new DecimalFormat("#.00");
            String num = null;
            if (sizeDouble < SIZE_B) {
                num = df.format(sizeDouble);
                stringBuilder.append(num);
                stringBuilder.append("KB");
            } else if (sizeDouble < SIZE_KB) {
                sizeDouble /= SIZE_B;
                num = df.format(sizeDouble);
                stringBuilder.append(num);
                stringBuilder.append("MB");
            } else if (sizeDouble < SIZE_MB) {
                sizeDouble /= SIZE_KB;
                num = df.format(sizeDouble);
                stringBuilder.append(num);
                stringBuilder.append("GB");
            }
        } else if (size instanceof Long) {
            Long sizeLong = (Long) size;
            if (sizeLong < SIZE_B) {
                stringBuilder.append(sizeLong);
                stringBuilder.append("KB");
            } else if (sizeLong < SIZE_KB) {
                sizeLong /= SIZE_B;
                stringBuilder.append(sizeLong);
                stringBuilder.append("MB");
            } else if (sizeLong < SIZE_MB) {
                sizeLong /= SIZE_KB;
                stringBuilder.append(sizeLong);
                stringBuilder.append("GB");
            }
        } else if (size instanceof Integer) {
            Integer sizeInteger = (Integer) size;
            if (sizeInteger < SIZE_B) {
                stringBuilder.append(sizeInteger);
                stringBuilder.append("KB");
            } else if (sizeInteger < SIZE_KB) {
                sizeInteger /= SIZE_B;
                stringBuilder.append(sizeInteger);
                stringBuilder.append("MB");
            } else if (sizeInteger < SIZE_MB) {
                sizeInteger /= SIZE_KB;
                stringBuilder.append(sizeInteger);
                stringBuilder.append("GB");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 返回string中指定子串所在的索引（忽略大小写）
     *
     * @param string
     * @param subString
     * @return
     */
    public static int ignoreIndexOf(String string, String subString) {
        return string.toLowerCase().indexOf(subString.toLowerCase());
    }

    /**
     * 删除字符串中的指定子串
     *
     * @param string
     * @param subString
     * @return
     */
    public static String deleteSubString(String string, String subString) {
        StringBuffer sb = new StringBuffer(string);

        while (true) {
            int index = ignoreIndexOf(sb.toString(), subString);
            if (index == -1) {
                break;
            }
            sb.delete(index, index + subString.length());
        }
        return sb.toString();
    }

    /**
     * 将子串集合根据在字符串中的位置进行排序
     *
     * @param string
     * @param subStringList
     * @return
     */
    public static void sortSubStringList(String string, List<String> subStringList) {
        Map<Integer, String> map = new HashMap<>();
        for (String subString : subStringList) {
            int index = ignoreIndexOf(string, subString);
            if (index != -1) {
                map.put(index, subString);
            }
        }
        subStringList.clear();
        map.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getKey()))
                .forEach(entry -> subStringList.add(entry.getValue()));
    }

    /**
     * 将长文本中出现的子串渲染，并将长文本转换成短文本的字符串（增加省略号，删除换行符）
     *
     * @param isDeleteBr
     * @param string
     * @param subStringList
     * @return
     */
    public static String renderStringInHtml(boolean isDeleteBr, String string, List<String> subStringList) {
        String res;
        StringBuilder sBuilder = new StringBuilder();
        String ellipsis = "...";
        if (subStringList == null || subStringList.size() == 0) {
            if (string.length() > 45) {
                sBuilder.append(string.substring(0, 45));
                sBuilder.append(ellipsis);
            } else {
                sBuilder.append(string);
            }
        } else {
            List<String> subStringListClone = new ArrayList<>(subStringList);
            sortSubStringList(string, subStringListClone); // 排序
            boolean isLong = string.length() > 45;
            String htmlPre = "<font style='color: #F56C6C'>";
            String htmlSuf = "</font>";
            String pre, suf;

            StringBuilder temp;
            int preIndex = 0;
            int tempLength = 0;
            for (String subString : subStringListClone) {
                // 获取当前子串位置，若存在
                int index = ignoreIndexOf(string, subString);
                // 子串拼接html颜色代码
                temp = new StringBuilder();
                temp.append(htmlPre);
                temp.append(string.substring(index, index + subString.length()));
                temp.append(htmlSuf);
                if (!isLong) {
                    pre = string.substring(preIndex, index);
                    sBuilder.append(pre);
                    sBuilder.append(temp);
                    tempLength += (index - preIndex + subString.length());
                } else {
                    if (index - preIndex > 20) {
                        if (preIndex != 0) {
                            pre = string.substring(preIndex, preIndex + 10);
                            sBuilder.append(pre);
                            tempLength += 10;
                        }
                        suf = string.substring(index - 10, index);
                        sBuilder.append(ellipsis);
                        sBuilder.append(suf);
                        sBuilder.append(temp);
                        tempLength += (10 + subString.length());
                    } else {
                        pre = string.substring(preIndex, index);
                        sBuilder.append(pre);
                        sBuilder.append(temp);
                        tempLength += (index - preIndex + subString.length());
                    }
                }
                preIndex = index + subString.length();
            }
            if (tempLength > 45) {
                sBuilder.append(ellipsis);
            } else {
                if (!isLong) {
                    tempLength = string.length();
                } else {
                    tempLength = (45 - tempLength) + preIndex;
                }
                System.out.println("preIndex:" + preIndex + "tempLength" + tempLength);
                sBuilder.append(string.substring(preIndex, tempLength));
                if (tempLength < string.length())
                    sBuilder.append(ellipsis);
                System.out.println(sBuilder.toString());
            }
        }
        // 删除换行符<br>
        res = sBuilder.toString();
        if (isDeleteBr)
            res = deleteSubString(res, "<br>");
        return res;
    }

}
