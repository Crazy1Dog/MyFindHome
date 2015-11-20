package firstdemo.xll.com.myfindhome.beans;

import java.io.Serializable;

/**
 * Created by steven on 2015/11/17.
 */
public class CityEntity implements Serializable{
    private int type = 1;
    private int cityid;
    private String cityname;

    public CityEntity() {
    }

    public CityEntity(String cityname,int type) {
        this.type = type;
        this.cityname = cityname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "type=" + type +
                ", cityid=" + cityid +
                ", cityname='" + cityname + '\'' +
                '}';
    }
}
