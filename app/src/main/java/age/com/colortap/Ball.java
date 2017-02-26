package age.com.colortap;

import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Adarsh Shaw on 24-Feb-17.
 */

public class Ball extends GameObject {
    private float speedX, speedY;
    public static int radius = 30;

    public Paint mPaint;

    public Ball() {
        super((Surface.WIDTH / 2 - radius), (Surface.HEIGHT / 2 - radius), radius, radius);
        Random r = new Random();
        speedX = r.nextFloat() * 15f;
        speedY = r.nextFloat() * 15f;
        mPaint = new Paint();
        mPaint.setColor(0xffffff00);
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
        speedX = (speedX > 20) ? 20 : speedX;
        speedY = (speedY > 20) ? 20 : speedY;
    }

    public void collisionupdate(Ball ball) {
        if (!(this.getCollisionRect().intersect(ball.getCollisionRect())))
            return;
        Rect r = ball.getCollisionRect();
        if (getCollisionRect().left <= r.right && getCollisionRect().top < r.bottom && getCollisionRect().bottom > r.top)
            speedX *= -1;
        else if (getCollisionRect().right >= r.left && getCollisionRect().top < r.bottom && getCollisionRect().bottom > r.top)
            speedX *= -1;
        else if (getCollisionRect().top <= r.bottom && getCollisionRect().left < r.right && getCollisionRect().right > r.left)
            speedY *= -1;
        else if (getCollisionRect().bottom >= r.top && getCollisionRect().left < r.right && getCollisionRect().right > r.left)
            speedY *= -1;
    }
}
