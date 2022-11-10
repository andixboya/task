package com.andreyan.task.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isTextValid(String regexPattern, String payload) {
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        var safeText = payload == null ? "" : payload;
        Matcher matcher = pattern.matcher(safeText);
        return matcher.find();
    }
}
