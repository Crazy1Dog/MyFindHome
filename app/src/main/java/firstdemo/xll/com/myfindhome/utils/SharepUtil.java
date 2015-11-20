package firstdemo.xll.com.myfindhome.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by steven on 2015/11/18.
 */
public class SharepUtil {
    private  static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    public static void init(Context context){
        sharedPreferences = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public static void putString(String key,String value){
        if (key != null && value != null){
            editor.putString(key,value);
            editor.commit();
        }
    }
    public static String  getString(String key){
        return sharedPreferences.getString(key,null);
    }
    public static void putInt(String key,int value){
        if(key != null){
            editor.putInt(key,value);
            editor.commit();
        }
    }
    public static int getInt(String key){
        return sharedPreferences.getInt(key,-1);
    }
}
