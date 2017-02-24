package age.com.colortap;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Adarsh Shaw on 21-Feb-17.
 */

public class Game_Classic {

    private Rect pad1,pad2;
    private Paint paint1,paint2;
    private Ball mBall,mBall1;

    public Game_Classic(){
        pad1=new Rect(0,0,128,Surface.HEIGHT);
        paint1=new Paint();
        paint1.setColor(0xffff0000);
        pad2=new Rect(Surface.WIDTH-128,0,Surface.WIDTH,Surface.HEIGHT);
        paint2=new Paint();
        paint2.setColor(0xff0000ff);
        mBall=new Ball();
        mBall1=new Ball();
        mBall1.mPaint.setColor(0xff00ff00);
    }

    public void render(Canvas c){
        c.drawColor(0xffffffff);
        c.drawRect(pad1,paint1);
        c.drawRect(pad2,paint2);
        c.drawCircle(mBall.x+mBall.radius,mBall.y+mBall.radius,mBall.radius,mBall.mPaint);
        c.drawCircle(mBall1.x+mBall1.radius,mBall1.y+mBall1.radius,mBall1.radius,mBall1.mPaint);
    }

    public void update(){
        /*Paint p;
        p=paint1;
        paint1=paint2;
        paint2=p;*/
        mBall.collisionupdate(mBall1);
        mBall.ballupdate();
        mBall1.ballupdate();
    }
}
