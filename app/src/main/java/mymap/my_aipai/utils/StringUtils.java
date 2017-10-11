package mymap.my_aipai.utils;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Utils
 *
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2011-7-22
 */
public class StringUtils {

    private StringUtils() {
        throw new AssertionError();
    }

    /**
     * is null or its length is 0 or it is made by space
     * <p>
     * <pre>
     * isBlank(null) = true;
     * isBlank(&quot;&quot;) = true;
     * isBlank(&quot;  &quot;) = true;
     * isBlank(&quot;a&quot;) = false;
     * isBlank(&quot;a &quot;) = false;
     * isBlank(&quot; a&quot;) = false;
     * isBlank(&quot;a b&quot;) = false;
     * </pre>
     *
     * @param str
     * @return if string is null or its size is 0 or it is made by space, return
     * true, else return false.
     */
    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * is null or its length is 0
     * <p>
     * <pre>
     * isEmpty(null) = true;
     * isEmpty(&quot;&quot;) = true;
     * isEmpty(&quot;  &quot;) = false;
     * </pre>
     *
     * @param str
     * @return if string is null or its size is 0, return true, else return
     * false.
     */
    public static boolean isEmpty(CharSequence str) {
        return (str == null || str.length() == 0);
    }

    /**
     * compare two string
     *
     * @param actual
     * @param expected
     * @return
     * @see ObjectUtils#isEquals(Object, Object)
     */
    public static boolean isEquals(String actual, String expected) {
        return ObjectUtils.isEquals(actual, expected);
    }

    /**
     * null Object to empty string
     * <p>
     * <pre>
     * nullStrToEmpty(null) = &quot;&quot;;
     * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
     * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
     * </pre>
     *
     * @param str
     * @return
     */
    public static String nullStrToEmpty(Object str) {
        return (str == null ? "" : (str instanceof String ? (String) str : str.toString()));
    }

    /**
     * capitalize first letter
     * <p>
     * <pre>
     * capitalizeFirstLetter(null)     =   null;
     * capitalizeFirstLetter("")       =   "";
     * capitalizeFirstLetter("2ab")    =   "2ab"
     * capitalizeFirstLetter("a")      =   "A"
     * capitalizeFirstLetter("ab")     =   "Ab"
     * capitalizeFirstLetter("Abc")    =   "Abc"
     * </pre>
     *
     * @param str
     * @return
     */
    public static String capitalizeFirstLetter(String str) {
        if (isEmpty(str)) {
            return str;
        }

        char c = str.charAt(0);
        return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str : new StringBuilder(str.length())
                .append(Character.toUpperCase(c)).append(str.substring(1)).toString();
    }

    /**
     * 转化String为int，做了非空判断等
     *
     * @param s
     * @return
     */
    public static int parseToInt(String s, int defaultValue) {
//        if (!TextUtils.isEmpty(s) && TextUtils.isDigitsOnly(s)) { // 不支持负数
//            return Integer.parseInt(s);
//        }
        if (!TextUtils.isEmpty(s)) {
            int num;
            try {
                num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                num = defaultValue;
            }
            return num;
        }
        return defaultValue;
    }

    public static int parseToInt(String s, int radix, int defaultValue) {
        if (!TextUtils.isEmpty(s) && TextUtils.isDigitsOnly(s)) {
            return Integer.parseInt(s, radix);
        }
        return defaultValue;
    }


    public static float parseToFloat(String s, float defaultValue) {
        float f = defaultValue;
        try {
            f = Float.parseFloat(s);
        } catch (Exception e) {
            CLog.trace("数据转换失败,使用默认数值");
        }
        return f;
    }


    /**
     * encoded in utf-8
     * <p>
     * <pre>
     * utf8Encode(null)        =   null
     * utf8Encode("")          =   "";
     * utf8Encode("aa")        =   "aa";
     * utf8Encode("啊啊啊啊")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
     * </pre>
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException if an error occurs
     */
    public static String utf8Encode(String str) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }

    /**
     * encoded in utf-8, if exception, return defultReturn
     *
     * @param str
     * @param defultReturn
     * @return
     */
    public static String utf8Encode(String str, String defultReturn) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return defultReturn;
            }
        }
        return str;
    }

    /**
     * get innerHtml from href
     * <p>
     * <pre>
     * getHrefInnerHtml(null)                                  = ""
     * getHrefInnerHtml("")                                    = ""
     * getHrefInnerHtml("mp3")                                 = "mp3";
     * getHrefInnerHtml("&lt;a innerHtml&lt;/a&gt;")                    = "&lt;a innerHtml&lt;/a&gt;";
     * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     * getHrefInnerHtml("&lt;a&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     * getHrefInnerHtml("&lt;a href="baidu.com"&gt;innerHtml&lt;/a&gt;")               = "innerHtml";
     * getHrefInnerHtml("&lt;a href="baidu.com" title="baidu"&gt;innerHtml&lt;/a&gt;") = "innerHtml";
     * getHrefInnerHtml("   &lt;a&gt;innerHtml&lt;/a&gt;  ")                           = "innerHtml";
     * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                      = "innerHtml";
     * getHrefInnerHtml("jack&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                  = "innerHtml";
     * getHrefInnerHtml("&lt;a&gt;innerHtml1&lt;/a&gt;&lt;a&gt;innerHtml2&lt;/a&gt;")        = "innerHtml2";
     * </pre>
     *
     * @param href
     * @return <ul>
     * <li>if href is null, return ""</li>
     * <li>if not match regx, return source</li>
     * <li>return the last string that match regx</li>
     * </ul>
     */
    public static String getHrefInnerHtml(String href) {
        if (isEmpty(href)) {
            return "";
        }

        String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
        Pattern hrefPattern = Pattern.compile(hrefReg, Pattern.CASE_INSENSITIVE);
        Matcher hrefMatcher = hrefPattern.matcher(href);
        if (hrefMatcher.matches()) {
            return hrefMatcher.group(1);
        }
        return href;
    }

    /**
     * process special char in html
     * <p>
     * <pre>
     * htmlEscapeCharsToString(null) = null;
     * htmlEscapeCharsToString("") = "";
     * htmlEscapeCharsToString("mp3") = "mp3";
     * htmlEscapeCharsToString("mp3&lt;") = "mp3<";
     * htmlEscapeCharsToString("mp3&gt;") = "mp3\>";
     * htmlEscapeCharsToString("mp3&amp;mp4") = "mp3&mp4";
     * htmlEscapeCharsToString("mp3&quot;mp4") = "mp3\"mp4";
     * htmlEscapeCharsToString("mp3&lt;&gt;&amp;&quot;mp4") = "mp3\<\>&\"mp4";
     * </pre>
     *
     * @param source
     * @return
     */
    public static String htmlEscapeCharsToString(String source) {
        return StringUtils.isEmpty(source) ? source : source.replaceAll("&lt;", "<").replaceAll("&gt;", ">")
                .replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }

    /**
     * transform half width char to full width char
     * <p>
     * <pre>
     * fullWidthToHalfWidth(null) = null;
     * fullWidthToHalfWidth("") = "";
     * fullWidthToHalfWidth(new String(new char[] {12288})) = " ";
     * fullWidthToHalfWidth("！＂＃＄％＆) = "!\"#$%&";
     * </pre>
     *
     * @param s
     * @return
     */
    public static String fullWidthToHalfWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == 12288) {
                source[i] = ' ';
                // } else if (source[i] == 12290) {
                // source[i] = '.';
            } else if (source[i] >= 65281 && source[i] <= 65374) {
                source[i] = (char) (source[i] - 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * 判断字符串是否为纯数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * transform full width char to half width char
     * <p>
     * <pre>
     * halfWidthToFullWidth(null) = null;
     * halfWidthToFullWidth("") = "";
     * halfWidthToFullWidth(" ") = new String(new char[] {12288});
     * halfWidthToFullWidth("!\"#$%&) = "！＂＃＄％＆";
     * </pre>
     *
     * @param s
     * @return
     */
    public static String halfWidthToFullWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == ' ') {
                source[i] = (char) 12288;
                // } else if (source[i] == '.') {
                // source[i] = (char)12290;
            } else if (source[i] >= 33 && source[i] <= 126) {
                source[i] = (char) (source[i] + 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * @param c
     * @return 字符串长度，两个英文字符算1，一个中文字符算1
     */
    public static long calculateLength(CharSequence c) {
        double len = 0;
        if (c == null) {
            return 0;
        }
        for (int i = 0; i < c.length(); i++) {
            int tmp = c.charAt(i);
            if (tmp > 0 && tmp < 127) {
                len += 0.5;
            } else {
                len++;
            }
        }
        return Math.round(len);
    }

    /**
     * 算出纯字母的字符串长度
     *
     * @param c
     * @return 返回0，表示长度为空或者不是纯字母，否则返回纯字母的字符串的长度
     */
    public static int isOnlyLettersLength(CharSequence c) {
        if (TextUtils.isEmpty(c)) {
            return 0;
        }
        for (int i = 0; i < c.length(); i++) {
            int tmp = c.charAt(i);
            if (!(tmp > 0 && tmp < 127)) {
                return 0;
            }
        }
        return c.length();
    }

    /**
     * 判断字符串是否超出给定的长度限制（汉字算1长,英文字母算0.5长）。若超限定，则返回截断后的字符串
     *
     * @param c
     * @param length 长度限定，（汉字算1长,英文字母算0.5长）
     * @return
     */
    public static String checkAndIntercept(CharSequence c, double length) {
        if (c == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        double len = 0;
        int leng = c.length();
        for (int i = 0; i < leng; i++) {
            char ch = c.charAt(i);
            int tmp = ch;
            if (tmp > 0 && tmp < 127) {
                len += 0.5;
            } else {
                len++;
            }
            if (len <= length) {
                sb.append(ch);
            } else {
                return sb.toString();
            }
        }
        return c.toString();
    }

    /**
     * 判断字符串是否超出给定的长度限制（汉字算1长,英文字母算0.5长）。若超限定，则返回截断后的字符串
     *
     * @param c
     * @param length 长度限定，（汉字算1长,英文字母算0.5长）
     * @return
     */
    public static String checkAndInterceptWithTail(CharSequence c, double length) {
        if (c == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        double len = 0;
        int leng = c.length();
        for (int i = 0; i < leng; i++) {
            char ch = c.charAt(i);
            int tmp = ch;
            if (tmp > 0 && tmp < 127) {
                len += 0.5;
            } else {
                len++;
            }
            if (len <= length) {//当 长度小于等于length，则添加到尾部
                sb.append(ch);
            } else {//当 大于length，直接返回
                sb.append("...");
                return sb.toString();
            }
        }
        //直接返回原来的字符串
        return c.toString();
    }

    /**
     * @param count          所需格式化的数值
     * @param formatStandard 格式化起点值
     * @param dec            保留的小数位
     * @return
     * @Title getFormatCount
     * @Description 【四舍五入方式格式化数值，返回小数点+万或者其他的形式】
     * @Author lidongwen@aipai.com
     * @Date 2015年7月21日 下午3:57:51
     * @Return String 返回类型
     */
    public static String getFormatCount(int count, final double formatStandard, final int dec) {
        String unit = "";
        double mStand = 1d;
        if (formatStandard >= 1000000) {
            unit = "百万";
            mStand = 1000000;
        } else if (formatStandard >= 10000) {
            unit = "万";
            mStand = 10000;
        } else if (formatStandard >= 1000) {
            unit = "千";
            mStand = 1000;
        } else if (formatStandard >= 100) {
            unit = "百";
            mStand = 100;
        }
        String formaString = "#####0";
        String checkString = "";
        if (dec > 0) {
            for (int i = 0; i < dec; i++) {
                checkString += "0";
            }
            formaString += "." + checkString;
        }

        if (count > formatStandard) {
            final double tempCount = count;
            final double value = tempCount / mStand;

            DecimalFormat df = new DecimalFormat(formaString);
            final String valueString = df.format(value);

            if (dec != 0) {
                final int index = valueString.indexOf(".");
                String nail = valueString.substring(index + 1, valueString.length());
                if (nail.equals(checkString)) {// 尾数全0检测
                    return valueString.substring(0, index) + unit;
                } else {
                    return valueString + unit;
                }
            } else {
                return valueString + unit;
            }

        } else {
            return String.valueOf(count);
        }
    }

    /**
     * @param count          所需格式化的数值
     * @param formatStandard 格式化起点值
     * @param dec            保留的小数位
     * @return
     * @Title getFormatCount
     * @Description 【截断方式格式化数值，返回小数点+万或者其他的形式】
     * @Author lidongwen@aipai.com
     * @Date 2015年7月21日 下午3:57:51
     * @Return String 返回类型
     */
    public static String getFormatCountCut(int count, final double formatStandard, final int dec) {
        String unit = "";
        double mStand = 1d;
        if (formatStandard >= 1000000) {
            unit = "百万";
            mStand = 1000000;
        } else if (formatStandard >= 10000) {
            unit = "万";
            mStand = 10000;
        } else if (formatStandard >= 1000) {
            unit = "千";
            mStand = 1000;
        } else if (formatStandard >= 100) {
            unit = "百";
            mStand = 100;
        }

        String checkString = "";
        if (dec > 0) {
            for (int i = 0; i < dec; i++) {
                checkString += "0";
            }

        }

        if (count > formatStandard) {
            final double tempCount = count;
            final double value = tempCount / mStand;
            String valueString = value + "";
            final int index = valueString.indexOf(".");
            if (dec == 0) {
                valueString = valueString.substring(0, index);
                return valueString + unit;
            } else {
                valueString = valueString.substring(0, index + 1 + dec);//
                String nail = valueString.substring(index + 1, valueString.length());
                if (nail.equals(checkString)) {// 尾数全0检测
                    return valueString.substring(0, index) + unit;
                } else {
                    return valueString + unit;
                }
            }
        } else {
            return String.valueOf(count);
        }
    }

    public static String getFormatCountCut(float count, final double formatStandard, final int dec) {
        String unit = "";
        double mStand = 1d;
        if (formatStandard >= 1000000) {
            unit = "百万";
            mStand = 1000000;
        } else if (formatStandard >= 10000) {
            unit = "万";
            mStand = 10000;
        } else if (formatStandard >= 1000) {
            unit = "千";
            mStand = 1000;
        } else if (formatStandard >= 100) {
            unit = "百";
            mStand = 100;
        }

        String checkString = "";
        if (dec > 0) {
            for (int i = 0; i < dec; i++) {
                checkString += "0";
            }

        }

        if (count > formatStandard) {
            final double tempCount = count;
            final double value = tempCount / mStand;
            String valueString = value + "";
            final int index = valueString.indexOf(".");
            if (dec == 0) {
                valueString = valueString.substring(0, index);
                return valueString + unit;
            } else {
                valueString = valueString.substring(0, index + 1 + dec);//
                String nail = valueString.substring(index + 1, valueString.length());
                if (nail.equals(checkString)) {// 尾数全0检测
                    return valueString.substring(0, index) + unit;
                } else {
                    return valueString + unit;
                }
            }
        } else {
            return String.valueOf(count);
        }
    }








    /**
     * 字符数组转换成字符串，字符数组为空时，返回空字符串
     *
     * @param byteArray
     * @return
     */
    public static String byteArrayToString(byte[] byteArray) {
        String str;
        if (byteArray != null && byteArray.length > 0) {
            str = new String(byteArray);
        } else {
            str = new String("");
        }
        return str;
    }


    /**
     * 字符数组转换成字符串，字符数组为空时，返回空字符串
     *
     * @param byteArray
     * @return
     */
    public static String byteArrayToString(byte[] byteArray, String charsetName) {
        String str = null;
        if (byteArray != null && byteArray.length > 0) {
            try {
                str = new String(byteArray, charsetName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static double parseDouble(String doubleStr, double defValue) {
        try {
            return Double.parseDouble(doubleStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;
    }

    public static String getValidString(@Nullable String value, String defValue) {
        return isEmpty(value) ? (isEmpty(defValue) ? "" : defValue) : value;
    }
}
