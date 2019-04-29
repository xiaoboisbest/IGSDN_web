package cn.igsdn.utils;

import java.util.regex.Pattern;

public class StringUtils {
    public static final String TEL_STRING = "tel";
    public static final String EMAIL_STRING = "email";
    public static final String MATCH_TEL_STRING = "^1[3456789]\\d{9}$";
    public static final String MATCH_EMAIL_STRING = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

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
}
