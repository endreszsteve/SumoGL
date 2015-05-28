package com.example.steve.sticks.game;

import java.util.ArrayList;
import java.util.List;

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
    public static final float WORLD_HEIGHT = 15;
    public static final int WORLD_STATE_RUNNING = 0;
    public static final int WORLD_STATE_NEXT_LEVEL = 1;
    public static final int WORLD_STATE_GAME_OVER = 3;

    public final Player player;
    public final Ring ring;
    public final Opponent opponent;
    public final WorldListener listener;
    public int score;
    public int state;

    public World(WorldListener listener)
    {
        this.ring = new Ring(5, 7);
        this.opponent = new Opponent(5, 7);
        this.player = new Player(3, 5);
        this.listener = listener;

        this.score = 0;
        this.state = WORLD_STATE_RUNNING;
    }

    public void update(float deltaTime, float accelX, float accelZ)
    {
        updatePlayer(deltaTime, accelX, accelZ);
        updateOpponent(deltaTime);
        checkBounds();
        checkRoundOver();
        checkGameOver();
    }

    private void updatePlayer(float deltaTime, float accelX, float accelZ)
    {
        player.velocity.x = -accelX / 10 * Player.PLAYER_VELOCITY;
        player.velocity.y = -accelZ / 10 * Player.PLAYER_VELOCITY;
        player.update(deltaTime);
    }

    private void updateOpponent(float deltaTime)
    {
        if (opponent.position.x - player.position.x <= 0 || opponent.position.y - player.position.y <= 0)
        {
            //opponent.position.set(player.position);
            opponent.update(deltaTime);
        }
    }

    private void checkBounds()
    {
        Circle arena = new Circle(this.ring.RING_WIDTH * 0.5f, this.ring.RING_HEIGHT * 0.5f, 117);

    }

    private void checkRoundOver()
    {

    }

    private void checkGameOver()
    {

    }

}
