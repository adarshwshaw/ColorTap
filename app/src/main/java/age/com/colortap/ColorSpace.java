package age.com.colortap;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Adarsh Shaw on 27-Feb-17.
 */

public class ColorSpace extends GameObject {

    Rect drawrect;
    Paint mPaint,shieldcolor;
    Rect shield;
    public ColorSpace(int x, int y, int width, int height,int color) {
        super(x, y, width, height);
        drawrect=new Rect(x,y,width,height);
        mPaint=new Paint();
        mPaint.setColor(color);
        if(width == Surface.WIDTH)
            shield=new Rect(x-10,0,x,height);
        else
            shield=new Rect(width,0,width+10,height);
        shieldcolor=new Paint();
        shieldcolor.setColor(0xdd00aadd);
    }

    public void update() {

    }

    @Override
    public void render(Canvas c) {
        c.drawRect(this.drawrect,this.mPaint);
        c.drawRect(this.shield,this.shieldcolor);
    }
}
