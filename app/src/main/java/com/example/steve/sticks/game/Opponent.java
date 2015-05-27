package com.example.steve.sticks.game;

import com.example.steve.sticks.DynamicGameObject;

public class Opponent extends DynamicGameObject
{
    public static final float OPPONENT_WIDTH = 64;
    public static final float OPPONENT_HEIGHT = 64;
    public static final float OPPONENT_VELOCITY = 3f;

    float stateTime = 0;

    public Opponent(float x, float y)
    {
        super(x, y, OPPONENT_WIDTH, OPPONENT_HEIGHT);
        velocity.set(OPPONENT_VELOCITY, 0);
    }

    public void update(float deltaTime)
    {
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        bounds.lowerLeft.set(position).sub(OPPONENT_WIDTH / 2, OPPONENT_HEIGHT / 2);

        if (position.x < OPPONENT_WIDTH / 2)
        {
            position.x = OPPONENT_WIDTH / 2;
            velocity.x = OPPONENT_VELOCITY;
        }
        stateTime += deltaTime;
    }
}
