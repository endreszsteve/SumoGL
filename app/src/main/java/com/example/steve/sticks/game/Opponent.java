package com.example.steve.sticks.game;

import com.example.steve.sticks.DynamicGameObject;

public class Opponent extends DynamicGameObject
{
    public static final float OPPONENT_WIDTH = 64;
    public static final float OPPONENT_HEIGHT = 64;
    public static final float OPPONENT_VELOCITY = 0.1f;
    public static final int OPPONENT_STATE_IDLE = 0;
    public static final int OPPONENT_STATE_LEFT_PUSH = 1;
    public static final int OPPONENT_STATE_RIGHT_PUSH = 2;
    public static final int OPPONENT_STATE_GRAB = 3;

    int state;
    float stateTime = 0;

    public Opponent(float x, float y)
    {
        super(x, y, OPPONENT_WIDTH, OPPONENT_HEIGHT);
        state = OPPONENT_STATE_IDLE;
        stateTime = 0;
        velocity.set(OPPONENT_VELOCITY, OPPONENT_VELOCITY);

    }

    public void update(float deltaTime)
    {
        bounds.lowerLeft.set(position).sub(OPPONENT_WIDTH / 2, OPPONENT_HEIGHT / 2);

        stateTime += deltaTime;
    }
}
