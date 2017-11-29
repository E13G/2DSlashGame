package com.jpinto.a2dslash.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.jpinto.a2dslash.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static boolean soundON = false;

    @BindView(R.id.root_parent)
    ConstraintLayout root_parent;

    @BindView(R.id.cl_game_menu)
    ConstraintLayout cl_menu;

    @BindView(R.id.tv_game_status)
    TextView game_status;

    @BindView(R.id.new_continue_game)
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

        tv_start_new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClick();
            }
        });
    }

    public void playClick() {

        new StartNewGameTask().execute("nada");
    }

    private void addTextiew(){

        game_status.setVisibility(View.VISIBLE);
        game_status.setText(R.string.countdown_start);

    }

    private void changeTextiew(){

        game_status.setVisibility(View.GONE);
    }

    private void startGameLvl(int lvl){

        Intent startGame = new Intent(this,GameActivity.class);
        startGame.putExtra("GAME_LVL",lvl);
        startActivity(startGame);
    }

    private class StartNewGameTask extends AsyncTask<String, Integer, Long> {

        protected Long doInBackground(String... urls) {

            long totalSize = 0;

//            addTextiew();
            startGameLvl(1);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return totalSize;
        }
        protected void onPostExecute(Long result) {

//            changeTextiew();
        }
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
                playClick();
                return true;
            case R.id.stop_icon:
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
}


