package firstdemo.xll.com.myfindhome.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.List;

import firstdemo.xll.com.myfindhome.R;
import firstdemo.xll.com.myfindhome.activities.CityActivity;
import firstdemo.xll.com.myfindhome.adapters.NewsAdapter;
import firstdemo.xll.com.myfindhome.beans.CityEntity;
import firstdemo.xll.com.myfindhome.beans.Constants;
import firstdemo.xll.com.myfindhome.beans.NewEntity;
import firstdemo.xll.com.myfindhome.utils.JsonUtil;
import firstdemo.xll.com.myfindhome.utils.SharepUtil;
import firstdemo.xll.com.myfindhome.utils.VolleyUtil;
import firstdemo.xll.com.myfindhome.views.HeadNavView;

/**
 * Created by steven on 2015/11/17.
 */
public class HomeFragment extends Fragment implements VolleyUtil.OnRequest {
    public static final int  RESULT_CODE = 0x001;
    public static final int  REQUEST_CODE = 0x002;
    private static final String TAG = "print";
    private HeadNavView headNavView;
    private View headView2;
    private NewsAdapter newsAdapter;
    @ViewInject(R.id.to_chooseCity)
    private Button toChooseCity;
    private ListView lv_home;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, null);
        ViewUtils.inject(this, view);
        initView(view);
        loadData();

        return view;
    }

    /**
     * 下载数据
     */
    private void loadData() {
        String cityname = SharepUtil.getString(Constants.BUNDLE_KEY.CITY_NAME_KEY);
        int cityid = SharepUtil.getInt(Constants.BUNDLE_KEY.CITY_ID_KEY);
        if(cityname != null && cityid != -1){
            updataButton(cityname,cityid);
        }else{
            updataButton("北京",1);
        }

    }

    /**
     * 初始化页面
     * @param view
     */
    private void initView(View view) {
        lv_home = (ListView) view.findViewById(R.id.lv_home);
        headNavView = new HeadNavView(getActivity(),getFragmentManager());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        headView2 = inflater.inflate(R.layout.headview2,null);
        lv_home.addHeaderView(headNavView);
        lv_home.addHeaderView(headView2);
        newsAdapter = new NewsAdapter(getActivity());
        lv_home.setAdapter(newsAdapter);

    }

    @OnClick({R.id.to_chooseCity})
    public void oclick(View view){
        Intent intent = new Intent(getActivity(), CityActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_CODE){
            CityEntity city = (CityEntity) data.getSerializableExtra(Constants.BUNDLE_KEY.CITY_OBJ_NAME);
            SharepUtil.putString(Constants.BUNDLE_KEY.CITY_NAME_KEY,city.getCityname());
            SharepUtil.putInt(Constants.BUNDLE_KEY.CITY_ID_KEY,city.getCityid());
            updataButton(city.getCityname(), city.getCityid());
        }
    }

    /**
     * updataButton.
     */
    private void updataButton(String cityname,int cityid) {
        toChooseCity.setText(cityname);
        updateData(cityid);
    }

    private void updateData(int cityid) {
        if(cityid != -1){
            String  url = String.format(Constants.URL.HOME_NEWS_URL,10,0,0,cityid);
            VolleyUtil.requestString(url, this);
            headNavView.setCityid(cityid);

        }

    }

    /**
     * 下载首页数据成功
     * @param url
     * @param response
     */
    @Override
    public void response(String url, String response) {
        Log.e(TAG,response);
        List<NewEntity> datas = JsonUtil.getNewsByJSON(response);
        newsAdapter.setDatas(datas);
    }

    /**
     * 下载首页数据失败
     * @param url
     * @param error
     */
    @Override
    public void errorResponse(String url, VolleyError error) {

    }
}
