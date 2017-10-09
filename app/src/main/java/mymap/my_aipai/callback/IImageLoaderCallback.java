package mymap.my_aipai.callback;

import android.graphics.Bitmap;
import android.view.View;

/**
 * 请求图片数据之后的回调
 * Created by DEVIN BLUNT on 2016/4/19.
 */
public interface IImageLoaderCallback {
    void onStart(String imageUri, View view);

    void onComplete(String imageUri, View view, Bitmap loadedImage);
    
    void onFail(String imageUri, View view, String msg);

    void onProgressUpdate(String imageUri, View view, int current, int total);
}
