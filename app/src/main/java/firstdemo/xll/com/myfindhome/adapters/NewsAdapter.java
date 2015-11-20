package firstdemo.xll.com.myfindhome.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import firstdemo.xll.com.myfindhome.R;
import firstdemo.xll.com.myfindhome.beans.NewEntity;
import firstdemo.xll.com.myfindhome.utils.VolleyUtil;

/**
 * Created by steven on 2015/11/18.
 */
public class NewsAdapter extends AbsAdapter<NewEntity> {
    public NewsAdapter(Context context, int... resid) {
        super(context, R.layout.item_news_pic, R.layout.item_news_pics);
    }

    @Override
    public void bindDatas(ViewHolder viewHolder, NewEntity data) {
        if(data.getType() == 0){
            ImageView iv = (ImageView) viewHolder.getView(R.id.iv_pic);
            VolleyUtil.requestImage(data.getThumbnail(), iv, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
            TextView tv = (TextView) viewHolder.getView(R.id.tv_title);
            tv.setText(data.getTitle());
            TextView tvcont = (TextView) viewHolder.getView(R.id.tv_content);
            tvcont.setText(data.getSummary());
        } else {
            ImageView iv = (ImageView) viewHolder.getView(R.id.iv_pic);
            VolleyUtil.requestImage(data.getGroupthumbnail(), iv, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
            TextView tv = (TextView) viewHolder.getView(R.id.tv_title);
            tv.setText(data.getTitle());
        }
    }

}
