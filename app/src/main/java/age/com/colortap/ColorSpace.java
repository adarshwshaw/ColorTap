package age.com.colortap;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * Created by Adarsh Shaw on 27-Feb-17.
 */

public class ColorSpace extends GameObject {

    Rect drawrect;
    Paint mPaint;
    //Rect shield;
    public Sheild msheild;
    public ColorSpace(int x, int y, int width, int height,int color) {
        super(x, y, width, height,States.COLORSPACE);
        drawrect=new Rect(x,y,width,height);
        mPaint=new Paint();
        mPaint.setColor(color);
        if(width == Surface.WIDTH)
            msheild=new Sheild(x-10,0,10,height);
        else
            msheild=new Sheild(width,0,10,height);
    }

    public void update() {

    }

    @Override
    public void render(Canvas c) {
        c.drawRect(this.drawrect,this.mPaint);
        msheild.render(c);
    }

    public void onTouch(MotionEvent e,int action){
        if(action==MotionEvent.ACTION_POINTER_DOWN || action==MotionEvent.ACTION_DOWN)
            msheild.setActive(true);
        else if(action==MotionEvent.ACTION_POINTER_UP || action==MotionEvent.ACTION_UP)
            msheild.setActive(false);
    }
}
