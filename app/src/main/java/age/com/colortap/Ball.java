package age.com.colortap;

import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;

/**
 * Created by Adarsh Shaw on 24-Feb-17.
 */

public class Ball extends GameObject {
    private float speedX, speedY;
    public static int radius = 30;
    private int colors[]={0xffffff00,0xffff0000,0xff0000ff};
    public Paint mPaint;

    public Ball() {
        super((Surface.WIDTH / 2 - radius), (Surface.HEIGHT / 2 - radius), radius, radius);
        Random r = new Random();
        speedX = r.nextFloat() * 20f;
        speedY = r.nextFloat() * 20f;
//        if(speedX<=20) speedX=10;
        if(speedX<1) speedX=1;
        mPaint = new Paint();
        int color=colors[r.nextInt(3)];
        mPaint.setColor(color);
    }

    private void collisionupdate() {
        if (x < 0 || x > (Surface.WIDTH - radius * 2))
            speedX *= -1;
        if (y < 0 || y > (Surface.HEIGHT - radius * 2))
            speedY *= -1;
    }

    public void update() {
        collisionupdate();
        x += speedX;
        y += speedY;
        System.out.println(speedX+" "+speedY);
        speedX = (speedX > 20) ? 20 : speedX;
        speedY = (speedY > 20) ? 20 : speedY;
    }

    public void collisionupdate(Ball ball) {
        if (!(this.getCollisionRect().intersect(ball.getCollisionRect())))
            return;
        if(getTopRect().intersect(ball.getBottomRect()) || getBottomRect().intersect(ball.getTopRect()))
            speedY*= -1;
        else if(getLeftRect().intersect(ball.getRightRect()) || getRightRect().intersect(ball.getLeftRect()))
            speedX *= -1;
    }

    private Rect getTopRect()
    {
        return new Rect(x+2,y,x+mWidth-2,y+5);
    }
    private Rect getBottomRect()
    {
        return new Rect(x+2,y+mHeight-5,x+mWidth-2,y+mHeight);
    }
    private Rect getRightRect()
    {
        return new Rect(x+mWidth-5,y+2,x+mWidth,y+mHeight-2);
    }
    private Rect getLeftRect()
    {
        return new Rect(x,y+2,x+5,y+mHeight-2);
    }
}
