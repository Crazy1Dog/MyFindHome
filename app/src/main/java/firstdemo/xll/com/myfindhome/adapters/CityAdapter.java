package firstdemo.xll.com.myfindhome.adapters;

import android.content.Context;
import android.widget.TextView;

import java.util.List;

import firstdemo.xll.com.myfindhome.R;
import firstdemo.xll.com.myfindhome.beans.CityEntity;

/**
 * Created by steven on 2015/11/17.
 */
public class CityAdapter extends AbsAdapter<CityEntity> {
    public CityAdapter(Context context) {

        super(context, R.layout.item_label,R.layout.item_city);
    }

    @Override
    public void bindDatas(ViewHolder viewHolder, CityEntity data) {
        if(data.getType() == 0){
            TextView tv = (TextView) viewHolder.getView(R.id.tv_label);
            tv.setText(data.getCityname());
        }else{
            TextView tv = (TextView) viewHolder.getView(R.id.tv_cityName);
            tv.setText(data.getCityname());
        }
    }

    @Override
    public boolean isEnabled(int position) {
        if(getItemViewType(position) == 0){
            return false;
        }
        return true;
    }
    public int eqindex(String label){
        int index = -1;
        List<CityEntity> datas = getDatas();
        for(int i = 0; i < datas.size(); i++){
            if(datas.get(i).getCityname().equals(label)){
                index = i;
                break;
            }
        }
        return index;
    }
}
