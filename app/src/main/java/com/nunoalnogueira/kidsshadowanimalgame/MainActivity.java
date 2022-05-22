package com.nunoalnogueira.kidsshadowanimalgame;

import android.content.DialogInterface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {

    Integer[] images = {
            R.drawable.o01,
            R.drawable.o02,
            R.drawable.o03,
            R.drawable.o04,
            R.drawable.o05,
            R.drawable.o06,
            R.drawable.o07,
            R.drawable.o08,
            R.drawable.o09,
            R.drawable.o10,
            R.drawable.o11,
            R.drawable.o12,
            R.drawable.o13,
            R.drawable.o14,
            R.drawable.o15,
            R.drawable.o16,
            R.drawable.o17,
            R.drawable.o18,
            R.drawable.o19,
            R.drawable.o20,
            R.drawable.o21,
            R.drawable.o22,
            R.drawable.o23,
            R.drawable.o24,
            R.drawable.o25,
            R.drawable.o26,
            R.drawable.o27,
            R.drawable.o28,
            R.drawable.o29,
            R.drawable.o30,
            R.drawable.o31,
            R.drawable.o32,
            R.drawable.o33,
            R.drawable.o34,
            R.drawable.o35,
            R.drawable.o36,
            R.drawable.o37,
            R.drawable.o38,
            R.drawable.o39,
            R.drawable.o40,
            R.drawable.o41,
            R.drawable.o42,
            R.drawable.o43,
            R.drawable.o44,
            R.drawable.o45,
            R.drawable.o46,
            R.drawable.o47,
            R.drawable.o48,
            R.drawable.o49,
            R.drawable.o50,
    };
    Integer[] images_shadow = {
            R.drawable.s01,
            R.drawable.s02,
            R.drawable.s03,
            R.drawable.s04,
            R.drawable.s05,
            R.drawable.s06,
            R.drawable.s07,
            R.drawable.s08,
            R.drawable.s09,
            R.drawable.s10,
            R.drawable.s11,
            R.drawable.s12,
            R.drawable.s13,
            R.drawable.s14,
            R.drawable.s15,
            R.drawable.s16,
            R.drawable.s17,
            R.drawable.s18,
            R.drawable.s19,
            R.drawable.s20,
            R.drawable.s21,
            R.drawable.s22,
            R.drawable.s23,
            R.drawable.s24,
            R.drawable.s25,
            R.drawable.s26,
            R.drawable.s27,
            R.drawable.s28,
            R.drawable.s29,
            R.drawable.s30,
            R.drawable.s31,
            R.drawable.s32,
            R.drawable.s33,
            R.drawable.s34,
            R.drawable.s35,
            R.drawable.s36,
            R.drawable.s37,
            R.drawable.s38,
            R.drawable.s39,
            R.drawable.s40,
            R.drawable.s41,
            R.drawable.s42,
            R.drawable.s43,
            R.drawable.s44,
            R.drawable.s45,
            R.drawable.s46,
            R.drawable.s47,
            R.drawable.s48,
            R.drawable.s49,
            R.drawable.s50,
    };

    Button button_banner, button_interstitial, button_reward;

    ImageView image1, image2, image3, image4, imageMain, img_next;

    pl.droidsonroids.gif.GifImageView img_gif_unlock;

    MediaPlayer music_background;
    //MediaPlayer music_background, sound_yeah, sound_no, sound_next;


    int reward, turn, correctAnswer, score, num_fails, num_games = 0, num_images = 50;

    Integer[] images_numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    Integer[] images_numbers_bonus = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49};
    int sound_yeah, sound_no, sound_next;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private RewardedVideoAd mRewardedVideoAd;
    private SoundPool soundPool;

    //AudioAttributes attributes;
    //AudioAttributes.Builder attributesBuilder;

    //AudioManager audioManager;
    //float curVolume, maxVolume, volume;


//##################################################################################################
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // public void initializeMobileAds() {

        // TEST: ca-app-pub-3940256099942544~3347511713
        // TRUE: ca-app-pub-5385342330837943~4689451955
        MobileAds.initialize(this, "ca-app-pub-5385342330837943~4689451955");
        //}

        //initializeMobileAds();
        //initializeRewardAd();

        button_banner = (Button) findViewById(R.id.button_banner);
        button_interstitial = (Button) findViewById(R.id.button_interstitial);
        button_reward = (Button) findViewById(R.id.button_reward);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        imageMain = (ImageView) findViewById(R.id.imageMain);
        img_next = (ImageView) findViewById(R.id.img_next);

        img_gif_unlock = (pl.droidsonroids.gif.GifImageView) findViewById(R.id.img_gift_unlock);

        //sound_yeah = MediaPlayer.create(MainActivity.this, R.raw.sound_yeah);
        //sound_no = MediaPlayer.create(MainActivity.this, R.raw.sound_no);
        //sound_next = MediaPlayer.create(MainActivity.this, R.raw.sound_next);

        //setVolumeControlStream(AudioManager.STREAM_MUSIC);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
            soundPool = new SoundPool.Builder().setMaxStreams(4).setAudioAttributes(audioAttributes).build();
        } else {
            soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        }

        sound_yeah = soundPool.load(this, R.raw.sound_yeah, 1);
        sound_no = soundPool.load(this, R.raw.sound_no, 1);
        sound_next = soundPool.load(this, R.raw.sound_next, 1);

        /*audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        curVolume = (float)audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        maxVolume = (float)audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volume = curVolume/maxVolume;*/

        music_background = MediaPlayer.create(MainActivity.this, R.raw.music_background);
        music_background.setLooping(true);
        music_background.setVolume(0.3f, 0.3f);
        music_background.start();


        startGame();

        //setImages();

//##################################################################################################

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turn++;

                if (turn == 10) {
                    checkEnd();
                } else {
                    //sound_next.start();
                    soundPool.play(sound_next, 1, 1, 0, 0, 1);
                    if (num_images == 20) {
                        setImages();
                    } else {
                        setImagesBonus();
                    }
                }
            }
        });

        img_gif_unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRewardAd();
            }
        });

        /*img_unlock_bonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRewardAd();
            }
        });*/

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (correctAnswer == 1) {
                    //sound_yeah.start();
                    soundPool.play(sound_yeah, 1, 1, 0, 0, 1);
                    score++;
                    if (num_images == 20) {
                        imageMain.setImageResource(images[images_numbers[turn]]);
                    } else {
                        imageMain.setImageResource(images[images_numbers_bonus[turn]]);
                    }
                    img_next.setVisibility(View.VISIBLE);
                } else {
                    //sound_no.start();
                    soundPool.play(sound_no, 1, 1, 0, 0, 1);
                    img_next.setVisibility(View.INVISIBLE);
                    if (num_images == 20) {
                        imageMain.setImageResource(images_shadow[images_numbers[turn]]);
                    } else {
                        imageMain.setImageResource(images_shadow[images_numbers_bonus[turn]]);
                    }
                    num_fails++;
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (correctAnswer == 2) {
                    //sound_yeah.start();
                    soundPool.play(sound_yeah, 1, 1, 0, 0, 1);
                    score++;
                    if (num_images == 20) {
                        imageMain.setImageResource(images[images_numbers[turn]]);
                    } else {
                        imageMain.setImageResource(images[images_numbers_bonus[turn]]);
                    }
                    img_next.setVisibility(View.VISIBLE);
                } else {
                    //sound_no.start();
                    soundPool.play(sound_no, 1, 1, 0, 0, 1);
                    img_next.setVisibility(View.INVISIBLE);
                    if (num_images == 20) {
                        imageMain.setImageResource(images_shadow[images_numbers[turn]]);
                    } else {
                        imageMain.setImageResource(images_shadow[images_numbers_bonus[turn]]);
                    }
                    num_fails++;
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (correctAnswer == 3) {
                    //sound_yeah.start();
                    soundPool.play(sound_yeah, 1, 1, 0, 0, 1);
                    score++;
                    if (num_images == 20) {
                        imageMain.setImageResource(images[images_numbers[turn]]);
                    } else {
                        imageMain.setImageResource(images[images_numbers_bonus[turn]]);
                    }
                    img_next.setVisibility(View.VISIBLE);
                } else {
                    //sound_no.start();
                    soundPool.play(sound_no, 1, 1, 0, 0, 1);
                    img_next.setVisibility(View.INVISIBLE);
                    if (num_images == 20) {
                        imageMain.setImageResource(images_shadow[images_numbers[turn]]);
                    } else {
                        imageMain.setImageResource(images_shadow[images_numbers_bonus[turn]]);
                    }
                    num_fails++;
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (correctAnswer == 4) {
                    //sound_yeah.start();
                    soundPool.play(sound_yeah, 1, 1, 0, 0, 1);
                    score++;
                    if (num_images == 20) {
                        imageMain.setImageResource(images[images_numbers[turn]]);
                    } else {
                        imageMain.setImageResource(images[images_numbers_bonus[turn]]);
                    }
                    img_next.setVisibility(View.VISIBLE);
                } else {
                    //sound_no.start();
                    soundPool.play(sound_no, 1, 1, 0, 0, 1);
                    img_next.setVisibility(View.INVISIBLE);
                    if (num_images == 20) {
                        imageMain.setImageResource(images_shadow[images_numbers[turn]]);
                    } else {
                        imageMain.setImageResource(images_shadow[images_numbers_bonus[turn]]);
                    }
                    num_fails++;
                }
            }
        });

//##################################################################################################

        button_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //initializeMobileAds();
                showBannerAd();
            }
        });

        button_interstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //initializeMobileAds();
                initializeInterstitialAd();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showInterstitialAd();
                    }
                }, 3000);
            }
        });

        button_reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //initializeMobileAds();
                //initializeRewardAd();
                showRewardAd();
            }
        });

//##################################################################################################


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                //Toast.makeText(MainActivity.this, "INTERSTITIAL LOADED", Toast.LENGTH_LONG).show();

                //button_interstitial.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {


            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.

                //button_interstitial.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                // Load the next interstitial.
                //mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });


    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//##################################################################################################


    public void initializeInterstitialAd() {

        // TEST: ca-app-pub-3940256099942544/1033173712
        // TRUE: ca-app-pub-5385342330837943/2037693290
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5385342330837943/2037693290");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void initializeRewardAd() {

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
    }

    private void loadRewardedVideoAd() {

        //TEST: ca-app-pub-3940256099942544/5224354917
        //TRUE:
        //mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
    }


    public void showBannerAd() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mAdView = findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
            }
        }, 5000);
    }

    public void showInterstitialAd() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            //Toast.makeText(this, "Interstitial not loaded", Toast.LENGTH_SHORT).show();
        }
    }

    public void showRewardAd() {

        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
    }

//##################################################################################################

    @Override
    public void onRewardedVideoAdLoaded() {

        if (reward == 0) {
            //img_gif_unlock.setVisibility(View.VISIBLE);

            //Toast.makeText(this, "REWARD VIDEO LOADED", Toast.LENGTH_SHORT).show();

            //button_reward.setVisibility(View.VISIBLE);
            //img_unlock_bonus.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onRewardedVideoAdOpened() {

        //Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();

        img_gif_unlock.setVisibility(View.INVISIBLE);
        music_background.pause();
        //music_background = null;
    }

    @Override
    public void onRewardedVideoStarted() {

        //Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {

        //Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();

        if (reward == 0) {

            music_background.start();
            loadRewardedVideoAd();
        } else {

            startGame();
        }

        /*music_background = MediaPlayer.create(MainActivity.this, R.raw.music_background);
        music_background.setLooping(true);
        music_background.setVolume(0.5f, 0.5f);
        music_background.start();*/
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

        Toast.makeText(this, "CONGRATULATIONS! ALL UNLOCKED!", Toast.LENGTH_SHORT).show();

        //button_reward.setVisibility(View.INVISIBLE);

        img_gif_unlock.setVisibility(View.INVISIBLE);

        reward = 1;

        num_images = 40;

        music_background.start();

        //music_background.stop();
        //music_background = null;

        //startGame();

        //loadRewardedVideoAd();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

        //Toast.makeText(this, "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show();

        //loadRewardedVideoAd();

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

        //Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {

        //Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();

        //loadRewardedVideoAd();
    }

//##################################################################################################


    private void startGame() {

        num_games++;

        //initializeMobileAds();

        initializeInterstitialAd();

        showBannerAd();

        if (reward == 0) {
            initializeRewardAd();
        }

        turn = 0;
        correctAnswer = 0;
        score = 0;
        num_fails = 0;

        //music_background.start();

        //soundPool.play(music_background, 1, 1, 1, 0, 1);

        Collections.shuffle(Arrays.asList(images_numbers));
        Collections.shuffle(Arrays.asList(images_numbers_bonus));

        if (num_images == 20) {
            setImages();
        } else {
            setImagesBonus();
        }
    }

//##################################################################################################

    private void setImages() {

        img_next.setVisibility(View.INVISIBLE);

        Random r = new Random();

        correctAnswer = r.nextInt(4) + 1;

        int wrongAnwser1, wrongAnwser2, wrongAnwser3;

        do {
            wrongAnwser1 = r.nextInt(num_images);
        } while (wrongAnwser1 == images_numbers[turn]);

        do {
            wrongAnwser2 = r.nextInt(num_images);
        } while (wrongAnwser2 == images_numbers[turn] || wrongAnwser2 == wrongAnwser1);

        do {
            wrongAnwser3 = r.nextInt(num_images);
        }
        while (wrongAnwser3 == images_numbers[turn] || wrongAnwser3 == wrongAnwser2 || wrongAnwser3 == wrongAnwser1);

        switch (correctAnswer) {

            case 1:
                image1.setImageResource(images[images_numbers[turn]]);
                image2.setImageResource(images[wrongAnwser1]);
                image3.setImageResource(images[wrongAnwser2]);
                image4.setImageResource(images[wrongAnwser3]);
                break;

            case 2:
                image1.setImageResource(images[wrongAnwser1]);
                image2.setImageResource(images[images_numbers[turn]]);
                image3.setImageResource(images[wrongAnwser2]);
                image4.setImageResource(images[wrongAnwser3]);
                break;

            case 3:
                image1.setImageResource(images[wrongAnwser1]);
                image2.setImageResource(images[wrongAnwser2]);
                image3.setImageResource(images[images_numbers[turn]]);
                image4.setImageResource(images[wrongAnwser3]);
                break;

            case 4:
                image1.setImageResource(images[wrongAnwser1]);
                image2.setImageResource(images[wrongAnwser2]);
                image3.setImageResource(images[wrongAnwser3]);
                image4.setImageResource(images[images_numbers[turn]]);
                break;
        }

        imageMain.setImageResource(images_shadow[images_numbers[turn]]);
    }

    private void setImagesBonus() {


        img_next.setVisibility(View.INVISIBLE);

        Random r = new Random();

        correctAnswer = r.nextInt(4) + 1;

        int wrongAnwser1, wrongAnwser2, wrongAnwser3;

        do {
            wrongAnwser1 = r.nextInt(num_images);
        } while (wrongAnwser1 == images_numbers_bonus[turn]);

        do {
            wrongAnwser2 = r.nextInt(num_images);
        } while (wrongAnwser2 == images_numbers_bonus[turn] || wrongAnwser2 == wrongAnwser1);

        do {
            wrongAnwser3 = r.nextInt(num_images);
        }
        while (wrongAnwser3 == images_numbers_bonus[turn] || wrongAnwser3 == wrongAnwser2 || wrongAnwser3 == wrongAnwser1);

        switch (correctAnswer) {

            case 1:
                image1.setImageResource(images[images_numbers_bonus[turn]]);
                image2.setImageResource(images[wrongAnwser1]);
                image3.setImageResource(images[wrongAnwser2]);
                image4.setImageResource(images[wrongAnwser3]);
                break;

            case 2:
                image1.setImageResource(images[wrongAnwser1]);
                image2.setImageResource(images[images_numbers_bonus[turn]]);
                image3.setImageResource(images[wrongAnwser2]);
                image4.setImageResource(images[wrongAnwser3]);
                break;

            case 3:
                image1.setImageResource(images[wrongAnwser1]);
                image2.setImageResource(images[wrongAnwser2]);
                image3.setImageResource(images[images_numbers_bonus[turn]]);
                image4.setImageResource(images[wrongAnwser3]);
                break;

            case 4:
                image1.setImageResource(images[wrongAnwser1]);
                image2.setImageResource(images[wrongAnwser2]);
                image3.setImageResource(images[wrongAnwser3]);
                image4.setImageResource(images[images_numbers_bonus[turn]]);
                break;
        }

        imageMain.setImageResource(images_shadow[images_numbers_bonus[turn]]);
    }

//##################################################################################################

    private void checkEnd() {

        AlertDialog.Builder alertDialogBuider = new AlertDialog.Builder(this);
        alertDialogBuider.setCancelable(false);
        alertDialogBuider.setMessage("GAME FINISHED. You fail " + num_fails + " times in 10 guesses.");

        alertDialogBuider.setPositiveButton(">>>>>  PLAY AGAIN  <<<<<", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                music_background.seekTo(0);
                //music_background = null;
                //soundPool.stop(music_background);

                showInterstitialAd();

                startGame();
            }
        });

        AlertDialog showEndMessage = alertDialogBuider.create();
        showEndMessage.show();
    }

//##################################################################################################

}
