package firstdemo.xll.com.myfindhome.beans;

import android.app.Application;

import firstdemo.xll.com.myfindhome.utils.SharepUtil;
import firstdemo.xll.com.myfindhome.utils.VolleyUtil;

/**
 * Created by steven on 2015/11/17.
 */
public class MyAppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VolleyUtil.initVolley(this);
        SharepUtil.init(this);
    }
}
