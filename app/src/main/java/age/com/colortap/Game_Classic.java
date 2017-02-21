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

    public Game_Classic(){
        pad1=new Rect(0,0,128,Surface.HEIGHT);
        paint1=new Paint();
        paint1.setColor(0xffff0000);
        pad2=new Rect(Surface.WIDTH-128,0,Surface.WIDTH,Surface.HEIGHT);
        paint2=new Paint();
        paint2.setColor(0xff0000ff);
    }

    public void render(Canvas c){
        c.drawRect(pad1,paint1);
        c.drawRect(pad2,paint2);
    }
}
