package firstdemo.xll.com.myfindhome.beans;

/**
 * Created by steven on 2015/11/17.
 */
public interface Constants {
    interface URL{
        /**
         * 城市选择页的URL
         */
        String CITY_SELECT_URL = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&act=kftcitylistnew&channel=71&devid=866500021200250&appname=QQHouse&mod=appkft";
        /**
         * 首页资讯列表的URL
         */
        String HOME_NEWS_URL = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&devid=866500021200250&appname=QQHouse&mod=appkft&reqnum=%d&pageflag=%d&act=newslist&channel=71&buttonmore=%d&cityid=%d";
        /**
         * 首页头部导航的URL
         */
        String HOME_HEAD_URL = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&devid=866500021200250&appname=QQHouse&mod=appkft&act=homepage&channel=71&cityid=%d";
    }
    interface BUNDLE_KEY{
        String CITY_OBJ_NAME = "city_obj";
        String CITY_NAME_KEY = "cityname";
        String CITY_ID_KEY = "cityid";
        String CITY_NAV_DATA = "nav_data";

    }

}
