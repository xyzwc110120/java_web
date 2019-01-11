package com.cyx.java_web.web_05_filter_listener.filter.sensitiveWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SensitiveWordsUtil {

    private static List<String> words = new ArrayList<>(Arrays.asList("老子", "妈的", "fuck"));

    public static String filter(String message) {
        for (String word : words) {
            // 若字符串中包含敏感字（不区分大小写），将敏感字替换为“*”符号
            if (message.toLowerCase().contains(word)) {
                StringBuilder substitute = new StringBuilder();
                for (int length = 0; length < word.length(); length++) {
                    substitute.append("*");
                }
                message =  message.replace(word, substitute);
            }
        }
        return message;
    }
}
