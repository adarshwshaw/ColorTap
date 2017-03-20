package age.com.colortap;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Adarsh Shaw on 18-Mar-17.
 */

public class Sheild extends GameObject {

    private boolean isActive;
    private Paint mPaint;
    public Sheild(int x, int y, int width, int height) {
        super(x, y, width, height,States.SHIELD);
        isActive=false;
        mPaint=new Paint();
        mPaint.setColor(0xdd00aadd);
    }

    @Override
    public void update() {
        //TODO: Shield timing
    }

    @Override
    public void render(Canvas c) {
        if(isActive)
            c.drawRect(getCollisionRect(),mPaint);
    }

    public void setActive(boolean b)
    {
        isActive=b;
    }
    public boolean isActive(){return isActive;}
}
