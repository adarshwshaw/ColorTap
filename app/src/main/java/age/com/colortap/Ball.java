package age.com.colortap;

import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Adarsh Shaw on 24-Feb-17.
 */

public class Ball {
    public float x,y;
    private float speedX,speedY;
    public float radius=30.0f;
    private final int MASS=1;

    public Paint mPaint;

    public Ball()
    {
        x=Surface.WIDTH/2 - radius;
        y=Surface.HEIGHT/2 - radius;
        Random r=new Random();
        speedX=r.nextFloat()*15f;
        speedY=r.nextFloat()*15f;
        mPaint=new Paint();
        mPaint.setColor(0xffffff00);
    }

    private void collisionupdate()
    {
        if(x < 0 || x > (Surface.WIDTH-radius*2))
           speedX  *= -1;
        if(y<0 || y>(Surface.HEIGHT-radius*2))
            speedY *= -1;
    }

    public void ballupdate()
    {
        collisionupdate();
        x+=speedX;
        y+=speedY;
        speedX=(speedX>20)?20:speedX;
        speedY=(speedY>20)?20:speedY;
    }

    public void collisionupdate(Ball ball){
        if(!(this.collisionRect().intersect(ball.collisionRect())))
            return;
        Rect r=ball.collisionRect();
        if(collisionRect().left<=r.right&&collisionRect().top<r.bottom&&collisionRect().bottom>r.top)
            speedX*=-1;
        else if(collisionRect().right>=r.left&&collisionRect().top<r.bottom&&collisionRect().bottom>r.top)
            speedX*=-1;
        else if(collisionRect().top<=r.bottom&&collisionRect().left<r.right&&collisionRect().right>r.left)
            speedY*=-1;
        else if(collisionRect().bottom>=r.top&&collisionRect().left<r.right&&collisionRect().right>r.left)
            speedY*=-1;
    }

    protected Rect collisionRect(){
        return new Rect((int)x,(int)y,(int)(x+2*radius),(int)(y+2*radius));
    }
}
