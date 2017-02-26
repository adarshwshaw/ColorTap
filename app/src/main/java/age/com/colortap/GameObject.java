package age.com.colortap;

import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Adarsh Shaw on 26-Feb-17.
 */

public abstract class GameObject {
    protected int x,y;
    protected int mWidth,mHeight;

    public GameObject(int x,int y,int width,int height)
    {
        this.x=x;
        this.y=y;
        mWidth=width;
        mHeight=height;
    }

    public abstract void update();

    public Rect getCollisionRect()
    {
        return new Rect(x,y,x+mWidth,y+mHeight);
    }
}
