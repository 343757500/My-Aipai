package mymap.my_aipai;

/**
 * Created by Administrator on 2017/2/5 0005.
 * 访问服务端地址的常量
 */

public class ServerAPI {
  public  static  final  String BASE_URL="http://m.aipai.com/aipaiApi/";
    //public  static  final  String BASE_URL="http://192.168.154.41:8080/GooglePlayServer/";
    public  static  final  String IMAGE_BASE_URL=BASE_URL+"image?name=";

  public  static  final  String APK_BASE_URL=BASE_URL+"download?name=";

  public  static  final  String GET_VIDEO_INFO="http://m.aipai.com/mobile/apps/apps_module-auxplayer_func-indexDataNew_os-1_assetId-%1$s.html";

  public static final String PLAYER_DETAIL_OTHER_DATA = "http://m.aipai.com/mobile/apps/apps.php?module=auxplayer&func=appendData&os=1&new_recommend=1";

  /**
   * 视频播放详情页实时数据
   */
  public static final String PLAYER_DETAIL_DIRECT_DATA = "http://m.aipai.com/mobile/apps/apps.php?module=auxplayer&func=assetCount";


}
