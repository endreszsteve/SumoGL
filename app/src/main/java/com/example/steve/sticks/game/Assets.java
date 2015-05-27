package com.example.steve.sticks.game;


import com.example.steve.sticks.Music;
import com.example.steve.sticks.Sound;
import com.example.steve.sticks.gl.Animation;
import com.example.steve.sticks.gl.Font;
import com.example.steve.sticks.gl.Texture;
import com.example.steve.sticks.gl.TextureRegion;
import com.example.steve.sticks.impl.GLGame;

public class Assets
{
    public static Texture background; // Game background
    public static TextureRegion backgroundRegion;

    public static Texture items;
    public static Texture players;
    public static TextureRegion mainMenu;
    public static TextureRegion pauseMenu;
    public static TextureRegion ready;
    public static TextureRegion gameOver;
    public static TextureRegion highScoreRegion;
    public static TextureRegion logo;
    public static TextureRegion soundOn;
    public static TextureRegion soundOff;
    public static TextureRegion leftArrow;
    public static TextureRegion rightArrow;
    public static TextureRegion pause;
    public static TextureRegion cancel;
    public static TextureRegion leftPush;
    public static TextureRegion rightPush;
    public static TextureRegion push;
    public static TextureRegion judge;
    public static TextureRegion arena;
    public static TextureRegion player;
    public static TextureRegion opponent;

    public static Animation playerPushRight;
    public static Animation playerPushLeft;
    public static Animation cpuPushRight;
    public static Animation cpuPushLeft;

    public static Font font;

    public static Music music;

    public static Sound clickSound;
    public static Sound slapSound;
    public static Sound winSound;
    public static Sound loseSound;
    public static Sound fightStart;

    public static void load(GLGame game)
    {
        background = new Texture(game, "background.png");
        backgroundRegion = new TextureRegion(background, 0, 0, 320, 480);

        items = new Texture(game, "items.png");
        players = new Texture(game, "player.png");
        mainMenu = new TextureRegion(items, 0, 195, 192, 101);
        pauseMenu = new TextureRegion(items, 0, 300, 160, 66);
        ready = new TextureRegion(items, 0, 375, 225, 75);
        gameOver = new TextureRegion(items, 0, 0, 0, 0); // need to update this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        highScoreRegion = new TextureRegion(Assets.items, 0, 257, 300, 110 /3);
        logo = new TextureRegion(items, 254, 0, 256, 126);
        soundOn = new TextureRegion(items, 0, 0, 64, 64);
        soundOff = new TextureRegion(items, 64, 0, 64, 64);
        leftArrow = new TextureRegion(items, 0, 64, 64, 64);
        rightArrow = new TextureRegion(items, 64, 64, 64, 64);
        pause = new TextureRegion(items, 64, 128, 64, 64);
        cancel = new TextureRegion(items, 0, 128, 64, 64);
        leftPush = new TextureRegion(items,128, 64, 64, 64);
        rightPush = new TextureRegion(items,128, 0, 64, 64);
        push = new TextureRegion(items, 128,127, 64, 64);
        arena = new TextureRegion(items, 221, 140, 291, 272);
        player = new TextureRegion(players, 0, 0, 64, 64);
        opponent = new TextureRegion(players, 0, 64, 64, 64);

        playerPushRight = new Animation(2.0f,
                                        new TextureRegion(players, 0, 0, 64, 64),
                                        new TextureRegion(players, 124, 0, 64, 64),
                                        new TextureRegion(players, 0, 0, 64, 64)
                                        );
        playerPushLeft = new Animation(2.0f,
                                       new TextureRegion(players, 0, 0, 64, 64),
                                       new TextureRegion(players, 64, 0, 64, 64),
                                       new TextureRegion(players, 0, 0, 64, 64)
                                       );
        cpuPushRight = new Animation(2.0f,
                                     new TextureRegion(players, 0, 64, 64, 64),
                                     new TextureRegion(players, 124, 64, 64, 64),
                                     new TextureRegion(players, 0, 64, 64, 64)
                                    );
        cpuPushLeft = new Animation(2.0f,
                                    new TextureRegion(players, 0, 64, 64, 64),
                                    new TextureRegion(players, 64, 64, 64, 64),
                                    new TextureRegion(players, 0, 64, 64, 64)
                                    );

        font = new Font(items, 0,0, 0, 0, 0); ///// need to update this as well!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        music = game.getAudio().newMusic("cartoonBattle.mp3");
        music.setLooping(true);
        music.setVolume(0.5f);
        if(Settings.soundenabled)
            music.play();
        clickSound = game.getAudio().newSound("click.ogg");
        slapSound = game.getAudio().newSound("slap.ogg");
        winSound = game.getAudio().newSound("win.ogg");
        loseSound = game.getAudio().newSound("lose.ogg");
    }

    public static void reload()
    {
        background.reload();
        items.reload();
        if(Settings.soundenabled)
            music.play();
    }

    public static void playSound(Sound sound)
    {
        if(Settings.soundenabled)
            sound.play(1);
    }
}
