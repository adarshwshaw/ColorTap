package age.com.colortap;

import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Adarsh Shaw on 27-Feb-17.
 */

public class ColorSpace extends GameObject {

    Rect drawrect;
    Paint mPaint;
    public ColorSpace(int x, int y, int width, int height,int color) {
        super(x, y, width, height);
        drawrect=new Rect(x,y,width,height);
        mPaint=new Paint();
        mPaint.setColor(color);
    }

    public void update() {

    }
}
