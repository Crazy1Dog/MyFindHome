package firstdemo.xll.com.myfindhome.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import firstdemo.xll.com.myfindhome.R;

/**
 * Created by steven on 2015/11/17.
 */
public class MessageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_fragment,null);
        return view;
    }
}
