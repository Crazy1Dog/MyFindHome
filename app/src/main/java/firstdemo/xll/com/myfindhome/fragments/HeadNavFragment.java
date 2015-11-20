package firstdemo.xll.com.myfindhome.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import firstdemo.xll.com.myfindhome.R;
import firstdemo.xll.com.myfindhome.beans.Constants;
import firstdemo.xll.com.myfindhome.beans.HeadNavEntity;
import firstdemo.xll.com.myfindhome.utils.VolleyUtil;

/**
 * Created by steven on 2015/11/19.
 */
public class HeadNavFragment extends Fragment {
    private ImageView iv_head;
    private TextView tv_head;
    public static HeadNavFragment getInstance(HeadNavEntity headNavEntity){
        HeadNavFragment headFragment = new HeadNavFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.BUNDLE_KEY.CITY_NAV_DATA, headNavEntity);
        headFragment.setArguments(bundle);
        return headFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_headnav,null);
        initView(view);
        loadData();
        return view;
    }

    /**
     * 加载数据
     */
    private void loadData() {
        Bundle bundle = getArguments();
        HeadNavEntity headNavEntity = (HeadNavEntity) bundle.getSerializable(Constants.BUNDLE_KEY.CITY_NAV_DATA);
        VolleyUtil.requestImage(headNavEntity.getPicurl(),iv_head,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        tv_head.setText(headNavEntity.getTitle());

    }

    /**
     * 初始化控件
     */
    private void initView(View view) {
        iv_head = (ImageView) view.findViewById(R.id.iv_head);
        tv_head = (TextView) view.findViewById(R.id.tv_head);
    }
}
