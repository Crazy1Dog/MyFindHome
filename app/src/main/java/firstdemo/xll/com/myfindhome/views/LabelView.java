package firstdemo.xll.com.myfindhome.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by steven on 2015/11/18.
 */
public class LabelView extends View{
    private Paint paint;
    private Paint textPaint;
    public LabelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
