package mymap.my_aipai.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * 
 * @author peekaboo
 * 
 */
public class SharedPreferencesUtil {

	private static SharedPreferences getDefauleSharedPreferences(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context);
	}

	private static SharedPreferences getSharedPreferences(Context context,
                                                          String fileName) {
		return context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
	}

	public static void putData(Context context, String key, Object value) {
		Editor editor = getDefauleSharedPreferences(context).edit();
		if (value instanceof Integer) {
			editor.putInt(key, (Integer) value);
		} else if (value instanceof Boolean) {
			editor.putBoolean(key, (Boolean) value);
		} else if (value instanceof String) {
			editor.putString(key, (String) value);
		} else if (value instanceof Float) {
			editor.putFloat(key, (Float) value);
		} else if (value instanceof Long) {
			editor.putLong(key, (Long) value);
		}
		editor.apply();
	}
	
	public static void putData(Context context, String fileName, String key, Object value) {
		Editor editor = getSharedPreferences(context, fileName).edit();
		if (value instanceof Integer) {
			editor.putInt(key, (Integer) value);
		} else if (value instanceof Boolean) {
			editor.putBoolean(key, (Boolean) value);
		} else if (value instanceof String) {
			editor.putString(key, (String) value);
		} else if (value instanceof Float) {
			editor.putFloat(key, (Float) value);
		} else if (value instanceof Long) {
			editor.putLong(key, (Long) value);
		}
		editor.apply();
	}
	
	public static Object getData(Context context, String key, Object defauValue) {
		SharedPreferences sharedPreferences = getDefauleSharedPreferences(context);
		if (defauValue instanceof Integer) {
			return sharedPreferences.getInt(key, (Integer) defauValue);
		} else if (defauValue instanceof Boolean) {
			return sharedPreferences.getBoolean(key, (Boolean) defauValue);
		} else if (defauValue instanceof String) {
			return sharedPreferences.getString(key, (String) defauValue);
		} else if (defauValue instanceof Float) {
			return sharedPreferences.getFloat(key, (Float) defauValue);
		} else if (defauValue instanceof Long) {
			return sharedPreferences.getLong(key, (Long) defauValue);
		}
		return null;
	}
	
	public static Object getData(Context context, String fileName, String key, Object defauValue) {
		SharedPreferences sharedPreferences = getSharedPreferences(context, fileName);
		if (defauValue instanceof Integer) {
			return sharedPreferences.getInt(key, (Integer) defauValue);
		} else if (defauValue instanceof Boolean) {
			return sharedPreferences.getBoolean(key, (Boolean) defauValue);
		} else if (defauValue instanceof String) {
			return sharedPreferences.getString(key, (String) defauValue);
		} else if (defauValue instanceof Float) {
			return sharedPreferences.getFloat(key, (Float) defauValue);
		} else if (defauValue instanceof Long) {
			return sharedPreferences.getLong(key, (Long) defauValue);
		}
		return null;
	}

	public static void clearData(Context context, String key) {
		Editor editor = getDefauleSharedPreferences(context).edit();
		editor.remove(key);
	}
}
