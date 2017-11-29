package com.jpinto.a2dslash.ui;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.jpinto.a2dslash.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {

    private static final String TAG = GameActivity.class.getSimpleName();

    private static boolean isPlaying =true;
    private static boolean isNewGame =false;
    private static boolean soundON = false;

    @BindView(R.id.gameCanvas)
    GameCanvas mGameCanvas;

    @BindView(R.id.cl_game_status)
    ConstraintLayout cl_game_status;

    @BindView(R.id.btn_game_status)
    Button btn_game_status;

    @BindView(R.id.tv_game_status)
    TextView tv_game_status;

    @BindView(R.id.tv_score)
    TextView tv_score;

    MenuItem play_pause_icon;
    MenuItem sound_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        mGameCanvas.setTextStatus(tv_game_status);
        mGameCanvas.setBtnStatus(btn_game_status);
        mGameCanvas.setTextScore(tv_score);
        mGameCanvas.setCl_menu(cl_game_status);

        mGameCanvas.setContext(this);
    }

    public void playClick() {

        //Set up a new game, we don't care about previous states
        mGameCanvas.startGame();
        mGameCanvas.setCl_menu(cl_game_status);

        play_pause_icon.setIcon(R.drawable.ic_pause_white_24dp);

        isNewGame = false;
        isPlaying = true;

        cl_game_status.setVisibility(View.GONE);
    }

    private void resumeGame() {
        mGameCanvas.resumeGame();
        play_pause_icon.setIcon(R.drawable.ic_pause_white_24dp);

        isPlaying = true;

        cl_game_status.setVisibility(View.GONE);
    }

    public void pauseClick() {

        mGameCanvas.pauseGame();
        play_pause_icon.setIcon(R.drawable.ic_play_arrow_white_24dp);

        isPlaying = false;

        cl_game_status.setVisibility(View.VISIBLE);
    }

    public void stopClick() {

        mGameCanvas.setGame_status(5);
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
        cl_game_status.setVisibility(View.VISIBLE);
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
                if(isPlaying && isNewGame){

                    playClick();
                    Log.d(TAG, "onOptionsItemSelected: playClick");
                }else if (isPlaying){

                    resumeGame();
                    Log.d(TAG, "onOptionsItemSelected: resumeClick");
                }else{

                    pauseClick();
                    Log.d(TAG, "onOptionsItemSelected: pauseClick");
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

    public static void setNewGame() {

        isPlaying = false;
        isNewGame = true;
    }

}
