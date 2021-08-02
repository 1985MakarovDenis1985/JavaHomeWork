package validator;

import java.util.regex.Pattern;

public class Validator {

    public static boolean checkCreditCardNum(String str) {
        String pattern = "\\d{8,16}";
        return str.matches(pattern);
    }

    public static boolean checkDateFormatEU(String str) {
        String pattern = "(3[0-1]|[0-2]\\d)\\.(0[1-9]|1[0-2])\\.(19\\d\\d|20[0-2]\\d)";
        return str.matches(pattern);
    }

    public static boolean checkDateFormatUS(String str) {
        String pattern = "(19\\d\\d|20[0-2]\\d)\\-(0[1-9]|1[0-2])\\-(3[0-1]|[0-2]\\d)";
        return str.matches(pattern);
    }

    public static boolean checkPhoneNumber(String str) {
        String pattern = "\\+\\d{2}\\(\\d{2}\\)\\d{4}\\-\\d{4}";
        return str.matches(pattern);
    }

    public static boolean checkLessEquals255(String str) {
        String chunkPattern = "(0|\\d|\\d\\d|1\\d{2}|2([0-4]\\d|[5][0-5]))";
        String pattern = chunkPattern+"\\."+chunkPattern+"\\."+chunkPattern+"\\."+chunkPattern;
        return str.matches(pattern);
    }

}
