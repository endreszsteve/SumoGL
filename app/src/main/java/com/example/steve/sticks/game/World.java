package com.example.steve.sticks.game;

import android.os.Debug;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.steve.sticks.Screen;
import com.example.steve.sticks.gl.Camera2D;
import com.example.steve.sticks.math.Circle;
import com.example.steve.sticks.math.OverlapTester;
import com.example.steve.sticks.math.Vector2;

public class World
{
    public interface WorldListener
    {
        public void slap();
        public void win();
        public void lose();
    }

    public static final float WORLD_WIDTH = 10;
    public static final float WORLD_HEIGHT = 10;
    public static final int WORLD_STATE_RUNNING = 0;
    public static final int WORLD_STATE_NEXT_LEVEL = 1;
    public static final int WORLD_STATE_GAME_OVER = 3;

    public final Player player;
    public final Ring ring;
    public final Opponent opponent;
    public final WorldListener listener;
    public int score;
    public int state;
    public Vector2 center = new Vector2(5f,7.5f);

    public World(WorldListener listener)
    {
        this.ring = new Ring(5, 7);
        this.opponent = new Opponent(5, 9);
        this.player = new Player(5, 5);
        this.listener = listener;


        this.score = 0;
        this.state = WORLD_STATE_RUNNING;
    }

    public void update(float deltaTime, float accelY, float accelZ)
    {
        updatePlayer(deltaTime, accelY, accelZ);
        updateOpponent(deltaTime);
        checkBounds();
        checkRoundOver();
        checkGameOver();
    }

    private void updatePlayer(float deltaTime, float accelY, float accelZ)
    {
        player.velocity.x = -accelY /10 * Player.PLAYER_VELOCITY;
        player.velocity.y = accelZ /10 * Player.PLAYER_VELOCITY;
        player.update(deltaTime);
    }

    private void updateOpponent(float deltaTime)
    {
        float dirX = player.position.x - opponent.position.x;
        float dirY = player.position.y - opponent.position.y;

        double hyp = Math.sqrt(dirX * dirX + dirY * dirY );

        dirX /= hyp;
        dirY /= hyp;

        if(opponent.position.dist(player.position) >= 0.5f)
        {
            opponent.position.y += dirY * Opponent.OPPONENT_VELOCITY;
            opponent.position.x += dirX * Opponent.OPPONENT_VELOCITY;
        }
        opponent.update(deltaTime);


    }

    private void checkBounds()
    {
        if(center.dist(player.position.x, player.position.y) > 4.5)
        {
            state = WORLD_STATE_GAME_OVER;
        }
        if(center.distSquared(opponent.position) <= 5)
        {
            Log.d("opp", "out");
        }

    }

    private void checkRoundOver()
    {

    }

    private void checkGameOver()
    {

    }

    private void bounceOff()
    {
    }

}
