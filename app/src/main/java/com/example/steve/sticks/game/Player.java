package com.example.steve.sticks.game;

import com.example.steve.sticks.DynamicGameObject;
import com.example.steve.sticks.math.Vector2;

public class Player extends DynamicGameObject
{
    public static final int PLAYER_IDLE = 0;
    public static final int PLAYER_LEFT = 1;
    public static final int PLAYER_RIGHT = 2;
    public static final int PLAYER_PUSH = 3;
    public static final float PLAYER_VELOCITY = 1f;
    public static final float PLAYER_WIDTH = 64f;
    public static final float PLAYER_HEIGHT = 64f;

    int state;
    float stateTime;

    public Player(float x, float y)
    {
        super(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
        state = PLAYER_IDLE;
        stateTime = 0;
    }

    public void update(float deltaTime)
    {
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        bounds.lowerLeft.set(position).sub(bounds.width / 2, bounds.height / 2);
    }

    public void slapRight()
    {
        if (state !=PLAYER_RIGHT)
        {
            state = PLAYER_RIGHT;
            if (stateTime < 1.0f)
            {
                state = PLAYER_IDLE;
                stateTime = 0;
            }
        }
    }

    public void slapLeft()
    {
        if (state != PLAYER_LEFT)
        {
            state = PLAYER_LEFT;
            if(stateTime < 1.0f)
            {
                state = PLAYER_IDLE;
                stateTime = 0;
            }
        }
    }

    public void grab()
    {
        if (state != PLAYER_PUSH)
        {
            state = PLAYER_PUSH;
            if (stateTime < 1.0f)
            {
                state = PLAYER_IDLE;
                stateTime = 0;
            }
        }
    }

}
