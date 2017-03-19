package age.com.colortap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;

/**
 * Created by Adarsh Shaw on 21-Feb-17.
 */

public class Game_Classic {

    private Ball mBall;
    private ColorSpace mColorSpace[];
    private Bitmap mBackground;

    public Game_Classic(Context c){
        mBackground= BitmapFactory.decodeResource(c.getResources(),R.drawable.background);
        mBall=new Ball();
        mColorSpace=new ColorSpace[2];
        for(int i=0;i<2;i++)
        {
            mColorSpace[0]=new ColorSpace(0,0,128,Surface.HEIGHT,0xffff0000);
            mColorSpace[1]=new ColorSpace(Surface.WIDTH-128,0,Surface.WIDTH,Surface.HEIGHT,0xff0000ff);
        }
    }

    public void render(Canvas c){
        c.drawBitmap(mBackground,null,new RectF(0,0,Surface.WIDTH,Surface.HEIGHT),null);
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
            int x=(int) e.getX(i);
            int y=(int) e.getY(i);
            int id=e.getPointerId(i);
            int action=e.getActionMasked();
            if (mColorSpace[0].getCollisionRect().contains(x, y))
                mColorSpace[0].onTouch(e,action);
            if (mColorSpace[1].getCollisionRect().contains(x, y))
                mColorSpace[1].onTouch(e,action);
        }
    }
}
