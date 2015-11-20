package firstdemo.xll.com.myfindhome.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by steven on 2015/11/18.
 */
public class SideView  extends View {
    private static final String TAG = "print";
    private String [] labels = {"当前","热门","A","B","C","D","E","F","G","H","I","J",
                                "K","L","M","N","O","P","Q",
                                 "R","S","T","U","V","W","X","Y","Z"};
    private int index = -1;
    private onClickItemListener itemListener;
    private Paint paint;
    private Paint colorPaint;
    private int labelHeight;
    public SideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        paint = new Paint();
        paint.setTextSize(20);
        paint.setColor(Color.parseColor("#88888888"));
        paint.setAntiAlias(true);

        colorPaint = new Paint();
        colorPaint.setTextSize(25);
        colorPaint.setColor(Color.parseColor("#00ffff"));
        colorPaint.setAntiAlias(true);

    }

    /**
     * 绘制文本
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int vWidth = getWidth();
        int vHeight = getHeight();
        labelHeight = vHeight / labels.length;
        for(int i = 0 ; i < labels.length; i++){
            if (i == index){
                canvas.drawText(labels[i],vWidth/2-paint.measureText(labels[i])/2,labelHeight*(i+1),colorPaint);
            }else{
                canvas.drawText(labels[i],vWidth/2-paint.measureText(labels[i])/2,labelHeight*(i+1),paint);
            }

        }
    }

    /**
     * 测量控件的width和height
     * @param widthMeasureSpec 系统推荐的宽度和当前组件的宽度；
     * @param heightMeasureSpec 系统推荐的高度和当前组件的高度；
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureSpc(widthMeasureSpec, 0), measureSpc(heightMeasureSpec, 1));
    }
    private  int measureSpc(int spec, int type){
        int mode = MeasureSpec.getMode(spec);
        int size = MeasureSpec.getSize(spec);
        switch (mode){
            case MeasureSpec.EXACTLY://布局文件中宽高给的属性值是match_parent或者是一个具体的值得时候；
                return size;
            case MeasureSpec.AT_MOST://布局文件中宽高给的属性值是wrap_content的时候对应这种模式；
                if(type == 0){
                    return (int) (paint.measureText(labels[1])+getPaddingLeft()+getPaddingRight());
                }else if(type == 1){
                    return size;
                }
            case MeasureSpec.UNSPECIFIED:
                break;
        }
        return 0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                checkIndex(y);
                break;
            case MotionEvent.ACTION_MOVE:
                checkIndex(y);
                break;
            case MotionEvent.ACTION_UP:
                index = -1;
                break;
        }
        return true;

    }
    //判断当前调到的位置是第几个item
    private void checkIndex(int y){
        int ind = y/labelHeight;
        if (ind != index){
            index = ind;
            Log.e(TAG,index+"");
        }
        if(index < 0 ){
            index = 0;
        }
        if(index >= labels.length){
            index = labels.length-1;
        }
        if (itemListener != null){
            itemListener.oncheck(labels[index]);
        }
        invalidate();

    }
    public interface onClickItemListener{
        void oncheck(String str);
    }
    public void setOnclickItemListenner(onClickItemListener myItemListener){
        this.itemListener = myItemListener;
    }
}
