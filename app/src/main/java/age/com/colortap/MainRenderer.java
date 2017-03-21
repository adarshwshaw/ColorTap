package age.com.colortap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainRenderer extends Activity implements View.OnTouchListener{

    Surface mSurface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mSurface=new Surface(this);
        mSurface.setOnTouchListener(this);
        setContentView(mSurface);
    }

    public boolean onTouch(View v, MotionEvent event) {
        mSurface.Ontouch(event);
        Log.d("dfos","dsfjod");
        System.out.println("fsijdf");
        return true;
    }
}
