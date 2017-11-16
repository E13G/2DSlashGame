package com.jpinto.a2dslash;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static boolean isPlaying =false;
    private static boolean isNewGame =true;
    private static boolean soundON = false;

    @BindView(R.id.gamearea)
    GameCanvas mGameCanvas;

    @BindView(R.id.cl_game_menu)
    ConstraintLayout cl_menu;

    @BindView(R.id.tv_game_state)
    TextView tv_start_new_game;

    MenuItem play_pause_icon;
    MenuItem sound_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mGameCanvas.setCl_menu(cl_menu);

        tv_start_new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClick();
            }
        });
    }

    public void playClick() {

        if(isNewGame){
            //Set up a new game, we don't care about previous states
            mGameCanvas.startGame();
            isNewGame = false;
        }else{
            mGameCanvas.resumeGame();
        }

        play_pause_icon
                .setIcon(R.drawable.ic_pause_white_24dp);
        isPlaying = true;
        cl_menu.setVisibility(View.GONE);
    }

    public void pauseClick(MenuItem item) {

        mGameCanvas.pauseGame();
        item.setIcon(R.drawable.ic_play_arrow_white_24dp);
        isPlaying = false;
        tv_start_new_game.setText("Resume Game");
        cl_menu.setVisibility(View.VISIBLE);
    }

    public void stopClick() {

        mGameCanvas.stopGame();

        // resets game status
        isNewGame = true;

        // change action bar play/pause icon
        if(!isPlaying){
            play_pause_icon.setIcon(R.drawable.ic_play_arrow_white_24dp);
        }else{
            play_pause_icon.setIcon(R.drawable.ic_pause_white_24dp);
        }

        //update and shows menu
        tv_start_new_game.setText("Start New Game");
        cl_menu.setVisibility(View.VISIBLE);
    }

    public void changeSound(MenuItem item) {
        //update and shows sound status
        if (soundON) {
            item.setIcon(R.drawable.ic_volume_off_white_24dp);
        } else {
            item.setIcon(R.drawable.ic_volume_up_white_24dp);
        }
        soundON = !soundON;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        // Get dynamic menu item
        play_pause_icon = menu.findItem(R.id.play_pause_icon);
        sound_icon = menu.findItem(R.id.sound_icon);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.play_pause_icon:
                // is play or pause icon
                if(!isPlaying){
                    playClick();
                }else {
                    pauseClick(item);
                }
                return true;
            case R.id.stop_icon:
                stopClick();
                return true;
            case R.id.sound_icon:
                changeSound(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public static void setIsNewGame(boolean isNewGame) {
        MainActivity.isNewGame = isNewGame;
    }
}
