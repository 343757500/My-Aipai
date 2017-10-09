package mymap.my_aipai.callback;

import android.graphics.Bitmap;

/**
 * Created by devin on 16/9/1.
 */
public interface IGetCacheBitmapCallback {
    void onSuccess(Bitmap bitmap);

    void onFail(String reason);
}
