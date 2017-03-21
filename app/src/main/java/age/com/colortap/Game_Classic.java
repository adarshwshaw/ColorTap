package age.com.colortap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import java.util.ArrayList;

/**
 * Created by Adarsh Shaw on 21-Feb-17.
 */

public class Game_Classic {

    private ColorSpace mColorSpace[];
    private Bitmap mBackground;
    private ArrayList<Ball> mballs;
    private int counter;

    public Game_Classic(Context c){
        mBackground= BitmapFactory.decodeResource(c.getResources(),R.drawable.background);
        mballs=new ArrayList<Ball>();
        Ball mBall=new Ball();
        mballs.add(mBall);
        mColorSpace=new ColorSpace[2];
        for(int i=0;i<2;i++)
        {
            mColorSpace[0]=new ColorSpace(0,0,128,Surface.HEIGHT,0xffff0000);
            mColorSpace[1]=new ColorSpace(Surface.WIDTH-128,0,Surface.WIDTH,Surface.HEIGHT,0xff0000ff);
        }
        counter=0;
    }

    public void render(Canvas c){
        c.drawBitmap(mBackground,null,new RectF(0,0,Surface.WIDTH,Surface.HEIGHT),null);
        mColorSpace[0].render(c);
        mColorSpace[1].render(c);
        for (Ball b:mballs){
            b.render(c);
        }
    }

    public void update(){
        counter++;
        for (int i = 0; i < mballs.size(); i++) {
            for (int j = i + 1; j < mballs.size(); j++) {
                mballs.get(i).collisionupdate(mballs.get(j));
            }
        }
        for (int j=0;j<mballs.size();j++) {
            for (int i = 0; i < 2; i++) {
                if (mColorSpace[i].msheild.isActive())
                    mballs.get(j).collisionupdate(mColorSpace[i].msheild);
                else {
                    boolean m = mballs.get(j).collisionupdate(mColorSpace[i]);
                    if (m) {
                        mballs.remove(j);
                        break;
                    }
                }
            }
        }
        for (Ball b : mballs) {
            b.update();
        }
        if(counter>120 && mballs.size()<16){
           counter=0;
            try {
                mballs.add(new Ball());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void Ontouch(MotionEvent e)
    {
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
