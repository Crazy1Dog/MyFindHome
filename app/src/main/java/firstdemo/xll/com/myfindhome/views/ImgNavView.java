package firstdemo.xll.com.myfindhome.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import firstdemo.xll.com.myfindhome.R;

/**
 * Created by steven on 2015/11/19.
 */
public class ImgNavView extends LinearLayout {
    private int count;
    private int checkedimg;
    private int uncheckedimg;
    private LinearLayout.LayoutParams layoutParams;
    public ImgNavView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paresAttrs(attrs);
        initView();
    }

    private void initView() {
        this.removeAllViews();
        if (count > 0){
            layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = 2;
            layoutParams.rightMargin = 2;
            for(int i = 0;i < count; i++){
                ImageView iv = new ImageView(getContext());
                if(i == 0){
                    iv.setImageResource(checkedimg);
                    iv.setTag("checked");
                }else{
                    iv.setImageResource(uncheckedimg);
                }
                iv.setLayoutParams(layoutParams);
                this.addView(iv);
            }

        }
    }
    public void setCount(int count){
        this.count = count;
        initView();
    }

    private void paresAttrs(AttributeSet attrs) {
        TypedArray typedArray = getResources().obtainAttributes(attrs,R.styleable.navImgattr);
        count = typedArray.getInteger(R.styleable.navImgattr_count,0);
        checkedimg = typedArray.getResourceId(R.styleable.navImgattr_checkedimg, 0);
        uncheckedimg = typedArray.getResourceId(R.styleable.navImgattr_uncheckedimg,0);

    }
    public void checkIndex(int index){
        ImageView iv = (ImageView) this.findViewWithTag("checked");
        iv.setImageResource(uncheckedimg);
        iv.setTag(null);
        iv = (ImageView) this.getChildAt(index);
        iv.setImageResource(checkedimg);
        iv.setTag("checked");
    }


}
