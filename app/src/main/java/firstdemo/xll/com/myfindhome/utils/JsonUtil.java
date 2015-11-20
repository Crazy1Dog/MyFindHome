package firstdemo.xll.com.myfindhome.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import firstdemo.xll.com.myfindhome.beans.CityEntity;
import firstdemo.xll.com.myfindhome.beans.HeadNavEntity;
import firstdemo.xll.com.myfindhome.beans.NewEntity;

/**
 * Created by steven on 2015/11/17.
 */
public class JsonUtil {
    public static String[] labels = {"A","B","C","D","E","F","G","H",
            "I","J","K","L","M","N","O","P","Q","R","S",
            "T","U","V","W","X","Y","Z"};

    public static List<CityEntity> getDatasByJSON(String json){
        List<CityEntity> datas = null;
        if(json != null){
            try {
                datas = new ArrayList<>();
                JSONObject jsonObject = new JSONObject(json);
                int retcode = jsonObject.getInt("retcode");
                if(retcode == 0){
                    jsonObject = jsonObject.getJSONObject("cities");
                    for(int i = 0; i < labels.length; i++){
                        //解析标签下的所有城市列表
                        JSONArray jsonArray = jsonObject.optJSONArray(labels[i]);
                        if(jsonArray != null){
                            //生成一个标签
                            CityEntity ce = new CityEntity(labels[i], 0);
                            datas.add(ce);
                            TypeToken<List<CityEntity>> tt = new TypeToken<List<CityEntity>>(){};
                            List<CityEntity> cityEntities = new Gson().fromJson(jsonArray.toString(), tt.getType());
                            datas.addAll(cityEntities);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return datas;
    }
    public static List<NewEntity> getNewsByJSON(String json){
        List<NewEntity> datas = null;
        if(json != null){
            try {
                datas = new ArrayList<>();
                JSONObject jsonObject = new JSONObject(json);
                int retcode = jsonObject.getInt("retcode");
                if(retcode == 0){
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    TypeToken<List<NewEntity>> tt = new TypeToken<List<NewEntity>>(){};
                    datas = new Gson().fromJson(jsonArray.toString(), tt.getType());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return datas;
    }
    /*public static List<HeadNavEntity> getHeadNavEntity(String json){
        List<HeadNavEntity>datas = null;
        if (json != null){
            datas = new ArrayList<>();
            try {
                JSONObject  jsonObject = new JSONObject(json);
                int retcode = jsonObject .getInt("retcode");
                if(retcode == 0){
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    datas = new Gson().fromJson(jsonArray.toString(),new TypeToken<HeadNavEntity>(){}.getType());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return datas;
    }*/
    public static List<HeadNavEntity> getHeadNavByJSON(String json){
        List<HeadNavEntity> datas = null;
        if(json != null){
            try {
                datas = new ArrayList<>();
                JSONObject jsonObject = new JSONObject(json);
                int retcode = jsonObject.getInt("retcode");
                if(retcode == 0){
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    TypeToken<List<HeadNavEntity>> tt = new TypeToken<List<HeadNavEntity>>(){};
                    datas = new Gson().fromJson(jsonArray.toString(), tt.getType());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return datas;
    }
}
