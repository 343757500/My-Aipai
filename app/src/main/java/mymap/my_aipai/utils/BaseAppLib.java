package mymap.my_aipai.utils;

import android.app.Application;

/**
 * Created by moo on 16/5/24.
 */
public class BaseAppLib {
    private static class Holder {
        static BaseAppLib _instance = new BaseAppLib();
    }

    public static BaseAppLib getInstance() {
        return Holder._instance;
    }

    private Application application;

    public void init(Application application) {
        this.application = application;
    }

    public Application getApplication() {
        return application;
    }
}
