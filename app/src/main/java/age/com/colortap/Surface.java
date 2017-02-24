package age.com.colortap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Adarsh Shaw on 20-Feb-17.
 */

public class Surface extends SurfaceView implements Runnable{
    public static int WIDTH=1280;
    public static int HEIGHT=720;

    private SurfaceHolder mSurfaceHolder;
    private Thread mLoop;
    private boolean isrunning;
    //temp
    Game_Classic mGame_classic;
    public Surface(Context context) {
        super(context);
        mSurfaceHolder=getHolder();
        mLoop=new Thread(this); //redering thread
        isrunning=true;
        mGame_classic=new Game_Classic();
        mLoop.start();
    }

    public void run() {
        long lastTime=System.nanoTime();
        double ns=1000000000.0/60.0;
        double delta=0.0;
        while(isrunning){
            if(!mSurfaceHolder.getSurface().isValid())
                continue;
            long currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/ns;
            lastTime=currentTime;
            if(delta>=1.0){
                update();
                delta--;
            }
            render();
        }
    }

    private void update(){}

    private void render(){
        final float scaleX=getWidth()/(WIDTH*1.0f);
        final float scaleY=getHeight()/(HEIGHT*1.0f);

        Canvas canvas=mSurfaceHolder.lockCanvas();
        final int savedState=canvas.save();
        canvas.scale(scaleX,scaleY);
        ////////////////////////////
        mGame_classic.render(canvas);
        ////////////////////////////
        canvas.restoreToCount(savedState);
        mSurfaceHolder.unlockCanvasAndPost(canvas);
    }
}
