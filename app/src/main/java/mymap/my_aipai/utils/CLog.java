package mymap.my_aipai.utils;

import android.content.Context;
import android.util.Log;


public class CLog {
    public static boolean DEBUG = true;

    public static void init(Context context) {
        try {
            Class clazz = Class.forName(context.getPackageName() + ".BuildConfig");
            DEBUG = clazz.getField("DEBUG").getBoolean(null);
        } catch (Exception e) {
            DEBUG = false;
        }
//        DEBUG = true;
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            if (tag != null && msg != null)
                Log.i(tag, msg);
        }

    }


    public static void d(String tag, String msg) {
        if (DEBUG) {
            if (tag != null && msg != null)
                Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            if (tag != null && msg != null)
                Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (DEBUG) {
            if (tag != null && msg != null)
                Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            if (tag != null && msg != null)
                Log.w(tag, msg);
        }
    }

    public static void trace() {
        if (DEBUG) {
            Throwable stack = new Throwable().fillInStackTrace();
            StackTraceElement[] trace = stack.getStackTrace();
            String className = trace[1].getClassName();//
            String[] splits = className.split("\\.");
            String head = trace[1].getMethodName() + " : Line" + trace[1].getLineNumber() + " , Time" + System.currentTimeMillis();
            Log.i(splits[splits.length - 1], head);
        }
    }

    public static void trace(String msg) {
        if (DEBUG) {
            Throwable stack = new Throwable().fillInStackTrace();
            StackTraceElement[] trace = stack.getStackTrace();
            String className = trace[1].getClassName();//
            String[] splits = className.split("\\.");
            String head = trace[1].getMethodName() + " : Line" + trace[1].getLineNumber() + " , Time" + System.currentTimeMillis();
            Log.i(splits[splits.length - 1], head + "---------->" + msg);
        }
    }

    public static void trace(int msg) {
        if (DEBUG) {
            Throwable stack = new Throwable().fillInStackTrace();
            StackTraceElement[] trace = stack.getStackTrace();
            String className = trace[1].getClassName();//
            String[] splits = className.split("\\.");
            String head = trace[1].getMethodName() + " : Line" + trace[1].getLineNumber() + " , Time" + System.currentTimeMillis();
            Log.i(splits[splits.length - 1], head + "---------->" + msg);
        }
    }

    public static void trace(boolean result) {
        if (DEBUG) {
            Throwable stack = new Throwable().fillInStackTrace();
            StackTraceElement[] trace = stack.getStackTrace();
            String className = trace[1].getClassName();//
            String[] splits = className.split("\\.");
            String head = trace[1].getMethodName() + " : Line" + trace[1].getLineNumber() + " , Time" + System.currentTimeMillis();
            Log.i(splits[splits.length - 1], head + "---------->" + result);
        }
    }
}
