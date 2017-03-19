package age.com.colortap;

import android.graphics.Canvas;

/**
 * Created by Adarsh Shaw on 21-Feb-17.
 */

public class Game {
    public static States mStates=States.Game;
    private States mGameMode;
    private Game_Classic gc;
    public Game(States gamemode){
        mGameMode=gamemode;
        //if(mGameMode==States.Classic)
            //gc=new Game_Classic();
    }

    public void update(){}

    public void render(Canvas canvas){
        //render
        ///////////////////
        gc.render(canvas);
        ///////////////////
    }
}
