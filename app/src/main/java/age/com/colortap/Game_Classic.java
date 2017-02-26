package age.com.colortap;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * Created by Adarsh Shaw on 21-Feb-17.
 */

public class Game_Classic {

    private Rect pad1,pad2;
    private Paint paint1,paint2;
    private Ball mBall;

    public Game_Classic(){
        pad1=new Rect(0,0,128,Surface.HEIGHT);
        paint1=new Paint();
        paint1.setColor(0xffff0000);
        pad2=new Rect(Surface.WIDTH-128,0,Surface.WIDTH,Surface.HEIGHT);
        paint2=new Paint();
        paint2.setColor(0xff0000ff);
        mBall=new Ball();
    }

    public void render(Canvas c){
        c.drawColor(0xffffffff);
        c.drawRect(pad1,paint1);
        c.drawRect(pad2,paint2);
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
