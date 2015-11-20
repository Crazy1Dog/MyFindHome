package firstdemo.xll.com.myfindhome.beans;

import java.io.Serializable;

/**
 * Created by steven on 2015/11/19.
 * {
 "type": "3",
 "picurl": "http://p.qpic.cn/estate/0/15aa7f96479f4505da6462759436909e.jpg/0",
 "title": "玉珑台：海淀西三环自由购",
 "houseid": "170293"
 },
 */
public class HeadNavEntity implements Serializable {
    private String picurl;
    private String title;
    private String houseid;

    public HeadNavEntity(String picurl, String title, String houseid) {
        this.picurl = picurl;
        this.title = title;
        this.houseid = houseid;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    @Override
    public String toString() {
        return "HeadNavEntity{" +
                "picurl='" + picurl + '\'' +
                ", title='" + title + '\'' +
                ", houseid='" + houseid + '\'' +
                '}';
    }
}
