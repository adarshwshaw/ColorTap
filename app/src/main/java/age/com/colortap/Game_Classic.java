package age.com.colortap;

import android.graphics.Canvas;
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
        c.drawRect(mColorSpace[0].drawrect,mColorSpace[0].mPaint);
        c.drawRect(mColorSpace[1].drawrect,mColorSpace[1].mPaint);
        c.drawCircle(mBall.x+Ball.radius,mBall.y+Ball.radius,Ball.radius,mBall.mPaint);
    }

    public void update(){
        /*Paint p;
        p=paint1;
        paint1=paint2;
        paint2=p;*/
        mBall.update();
    }

    public void Ontouch(MotionEvent e)
    {

    }
}
