/**
 * @Title: TempUtils.java
 * @Package com.aipai.android.tools
 * @Description: (用一句话描述该文件做什么)
 * @author spy
 * @date 2015-3-17 下午2:06:12
 * @version V1.0
 */
package mymap.my_aipai.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author spy
 * @version V1.0
 * @ClassName: TempUtils
 * @Description: (这里用一句话描述这个类的作用)
 * @date 2015-3-17 下午2:06:12
 */

public class StringFormatUtils {

    /**
     * 启动默认浏览器 成功返回true
     *
     * @Title: startDefaulBrowser
     * @author spy
     */
    public static boolean startDefaulBrowser(Context context) {
        String default_browser = "android.intent.category.DEFAULT";
        String browsable = "android.intent.category.BROWSABLE";
        String view = "android.intent.action.VIEW";
        Intent intent = new Intent(view);
        intent.addCategory(default_browser);
        intent.addCategory(browsable);
        Uri uri = Uri.parse("http://");
        intent.setDataAndType(uri, null);
        List<ResolveInfo> resolveInfoList = context.getPackageManager()
                .queryIntentActivities(intent, PackageManager.GET_INTENT_FILTERS);
        if (resolveInfoList.size() > 0) {
            ActivityInfo activityInfo = resolveInfoList.get(0).activityInfo;
            String packageName = activityInfo.packageName;
            String className = activityInfo.name;
            Intent it = new Intent(Intent.ACTION_VIEW);
            it.setClassName(packageName, className);
            context.startActivity(it);
            return true;
        }
        return false;
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                if (packageName.equals(pinfo.get(i).packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isLandscape(Context context) {
        Configuration mConfiguration = context.getResources().getConfiguration();
        int ori = mConfiguration.orientation;
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            return true;
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            return false;
        }
        return false;
    }

    //	移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
//	联通：130、131、132、152、155、156、185、186
//	电信：133、153、180、189、181、（1349卫通）
//	中国移动号段：134、135、136、137、138、139、150、151、152、157、158、159、182、183、184、187、188、178(4G)、147(上网卡)
//	中国电信号段：133、153、180、181、189 、177(4G)
//	中国联通号段：130、131、132、155、156、185、186、176(4G)、145(上网卡)
//	卫星通信号段：1349
//	虚拟运营商号段：170
    public static boolean isPhoneNumber(String phoneNo) {
        if (TextUtils.isEmpty(phoneNo)) {
            return false;
        }
        Pattern p = Pattern.compile("^((14[5,7])|(17[0,3,6,7])|(13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phoneNo);
        return m.matches();
    }

    public static boolean isEmail(String emailString) {
        if (TextUtils.isEmpty(emailString)) {
            return false;
        }
        return emailString.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    }

    public static void goBrowser(Context context, String url) {
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }


    public static String formatVideoClickString(String clickString) {
        try {
            double click = Double.valueOf(clickString);
            if (click > 100000d) {
                click /= 10000d;
                DecimalFormat df = new DecimalFormat("0.0");
                String str = df.format(click);

                char last = str.charAt(str.length() - 1);
                if ("0".equals(last + "")) {
                    String subStr = str.substring(0, str.indexOf("."));
                    return subStr + "万";
                } else {
                    return str + "万";
                }
            } else {
                return clickString;
            }
        } catch (Exception e) {
            return clickString;
        }

    }


    public static void showDiloag(Dialog dialog, boolean b) {
        if (dialog != null) {
            if (b) {
                dialog.show();
            } else {
                dialog.dismiss();
            }
        }
    }

    /**
     * @return String
     * @throws
     * @Title: getEmailAuthCodeImageUrl
     * @Description: 获取邮箱验证码
     * @param:@return
     * @author spy
     */
    public static String getEmailAuthCodeImageUrl() {
        return "http://m.aipai.com/app/www/common/captcha.php?rid=" + Math.random();
    }


    public static boolean isMatchNumAndChar(String s) {
        if (!TextUtils.isEmpty(s)) {
            String patternString = "^(?![^a-zA-Z]+$)(?!\\D+$)(.+$)";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }
        return false;
    }


}
