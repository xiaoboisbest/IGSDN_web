package cn.igsdn.utils;

import java.util.ResourceBundle;

public class ConfigUtils {
    public static String getValue(String key) {
        ResourceBundle resource = ResourceBundle.getBundle("cn/igsdn/config/config");
        return resource.getString(key);
    }
}
