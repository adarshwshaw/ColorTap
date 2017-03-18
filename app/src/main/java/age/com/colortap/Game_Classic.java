package age.com.colortap;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Adarsh Shaw on 21-Feb-17.
 */

public class Game_Classic {

    private Ball mBall;
    private ColorSpace mColorSpace[];

    public Game_Classic(){
        mBall=new Ball();
        mColorSpace=new ColorSpace[2];
        for(int i=0;i<2;i++)
        {
            mColorSpace[0]=new ColorSpace(0,0,128,Surface.HEIGHT,0xffff0000);
            mColorSpace[1]=new ColorSpace(Surface.WIDTH-128,0,Surface.WIDTH,Surface.HEIGHT,0xff0000ff);
        }
    }

    public void render(Canvas c){
        c.drawColor(0xffffffff);
        mColorSpace[0].render(c);
        mColorSpace[1].render(c);
        mBall.render(c);
    }

    public void update(){
        mBall.update();
    }

    public void Ontouch(MotionEvent e)
    {
        //TODO:Support multi touch
        int len=e.getPointerCount();
        for(int i=0;i<len;i++) {
            if (mColorSpace[0].getCollisionRect().contains((int) e.getX(i), (int) e.getY(i)))
                mColorSpace[0].onTouch(e);
            if (mColorSpace[1].getCollisionRect().contains((int) e.getX(i), (int) e.getY(i)))
                mColorSpace[1].onTouch(e);
        }
    }
}
