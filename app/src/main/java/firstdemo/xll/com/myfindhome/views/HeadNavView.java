package firstdemo.xll.com.myfindhome.views;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.android.volley.VolleyError;

import java.util.List;

import firstdemo.xll.com.myfindhome.R;
import firstdemo.xll.com.myfindhome.beans.Constants;
import firstdemo.xll.com.myfindhome.beans.HeadNavEntity;
import firstdemo.xll.com.myfindhome.fragments.HeadNavFragment;
import firstdemo.xll.com.myfindhome.utils.JsonUtil;
import firstdemo.xll.com.myfindhome.utils.VolleyUtil;

/**
 * Created by steven on 2015/11/19.
 */
public class HeadNavView extends FrameLayout implements VolleyUtil.OnRequest, ViewPager.OnPageChangeListener {
    private ViewPager vp_home;
    private FragmentManager fm;
    private ImgNavView ivg;
    public HeadNavView(Context context,FragmentManager fm) {
        super(context);
        this.fm = fm;
        initView();
    }

    /**
     * 初始化头布局中的控件
     */
    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.headnav,this,true);
        vp_home = (ViewPager) findViewById(R.id.vp_home);
        ivg = (ImgNavView) findViewById(R.id.ivg_head);
        vp_home.setOnPageChangeListener(this);

    }
    public void setCityid(int cityid){
        if(cityid > 0){
            String url = String.format(Constants.URL.HOME_HEAD_URL,cityid);
            VolleyUtil.requestString(url,this);
        }
    }

    /**
     * 下载头部数据成功
     * @param url
     * @param response
     */

    @Override
    public void response(String url, String response) {
        List<HeadNavEntity>datas = JsonUtil.getHeadNavByJSON(response);
        ivg.setCount(datas.size());
        ViewPagerAdapter adapter = new ViewPagerAdapter(fm,datas);
        vp_home.setAdapter(adapter);
    }

    /**
     * 下载头部数据失败
     * @param url
     * @param error
     */
    @Override
    public void errorResponse(String url, VolleyError error) {

    }

    /**
     * 给viewPager设置监听需要重写的方法
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ivg.checkIndex(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter{
        private List<HeadNavEntity>datas;
        public ViewPagerAdapter(android.support.v4.app.FragmentManager fm, List<HeadNavEntity> datas) {
            super(fm);
            this.datas = datas;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment headNavFragment = HeadNavFragment.getInstance(datas.get(position));
            return headNavFragment;
        }

        @Override
        public int getCount() {
            return datas.size();
        }


    }
}
