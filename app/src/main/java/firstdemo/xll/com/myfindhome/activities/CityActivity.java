package firstdemo.xll.com.myfindhome.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;

import java.util.List;

import firstdemo.xll.com.myfindhome.R;
import firstdemo.xll.com.myfindhome.adapters.CityAdapter;
import firstdemo.xll.com.myfindhome.beans.CityEntity;
import firstdemo.xll.com.myfindhome.beans.Constants;
import firstdemo.xll.com.myfindhome.fragments.HomeFragment;
import firstdemo.xll.com.myfindhome.utils.JsonUtil;
import firstdemo.xll.com.myfindhome.utils.VolleyUtil;
import firstdemo.xll.com.myfindhome.views.SideView;

/**
 * Created by steven on 2015/11/17.
 */
public class CityActivity extends Activity implements VolleyUtil.OnRequest,SideView.onClickItemListener, AdapterView.OnItemClickListener {
    private static final String  TAG = "print";
    private ListView lv_cities;
    private CityAdapter cityAdapter;
    private SideView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_city);
        initListView();
        initData();
    }

    /**
     * 请求数据
     */
    private void initData() {
        VolleyUtil.requestString(Constants.URL.CITY_SELECT_URL,this);
    }

    /**
     * 初始化listView
     */
    private void initListView() {
        sv = (SideView) findViewById(R.id.sv_cities);
        sv.setOnclickItemListenner(this);
        lv_cities = (ListView) findViewById(R.id.lv_cities);
        cityAdapter = new CityAdapter(this);
        lv_cities.setAdapter(cityAdapter);
        lv_cities.setOnItemClickListener(this);
    }

    /**
     * 下载数据成功
     * @param url
     * @param response
     */
    @Override
    public void response(String url, String response) {
        Log.e(TAG,response);
        List<CityEntity>data = JsonUtil.getDatasByJSON(response);
       cityAdapter.setDatas(data);
    }

    /**
     * 下载数据失败
     * @param url
     * @param error
     */
    @Override
    public void errorResponse(String url, VolleyError error) {

    }

    @Override
    public void oncheck(String str) {
        int index = cityAdapter.eqindex(str);
        if(index != -1){
            lv_cities.smoothScrollToPositionFromTop(index,0);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        CityEntity city = (CityEntity) cityAdapter.getItem(position);
        Intent intent = getIntent();
        intent.putExtra(Constants.BUNDLE_KEY.CITY_OBJ_NAME,city);
        setResult(HomeFragment.RESULT_CODE,intent);
        finish();

    }
}
