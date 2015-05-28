package com.example.steve.sticks.game;

import javax.microedition.khronos.opengles.GL10;

import com.example.steve.sticks.gl.Animation;
import com.example.steve.sticks.gl.Camera2D;
import com.example.steve.sticks.gl.SpriteBatcher;
import com.example.steve.sticks.gl.TextureRegion;
import com.example.steve.sticks.impl.GLGraphics;

public class WorldRenderer
{
    static final float FRUSTRUM_WIDTH = 10;
    static final float FRUSTRUM_HEIGHT = 15;
    GLGraphics glGraphics;
    World world;
    Camera2D cam;
    SpriteBatcher batcher;

    public WorldRenderer(GLGraphics glGraphics, SpriteBatcher batcher, World world)
    {
        this.glGraphics = glGraphics;
        this.world = world;
        this.cam = new Camera2D(glGraphics, FRUSTRUM_WIDTH, FRUSTRUM_HEIGHT);
        this.batcher = batcher;
    }

    public void render()
    {
        if(world.player.position.y > cam.position.y)
            cam.position.y = world.player.position.y;
        cam.setViewportAndMatrices();
        renderBackground();
        renderObjects();
    }

    public void renderBackground()
    {
        batcher.beginBatch(Assets.background);
        batcher.drawSprite(cam.position.x, cam.position.y, FRUSTRUM_WIDTH, FRUSTRUM_HEIGHT, Assets.backgroundRegion);
        batcher.endBatch();
    }

    public void renderObjects()
    {
        GL10 gl = glGraphics.getGL();
        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        batcher.beginBatch(Assets.items);
        renderPlayer();
        renderOpponent();
        renderRing();
        batcher.endBatch();
        gl.glDisable(GL10.GL_BLEND);
    }

    private void renderPlayer()
    {
        TextureRegion keyFrame;
        switch(world.player.state)
        {
            case Player.PLAYER_LEFT:
                keyFrame = Assets.playerPushLeft.getKeyFrame(world.player.stateTime, Animation.ANIMATION_LOOPING);
                break;
            case Player.PLAYER_RIGHT:
                keyFrame = Assets.playerPushRight.getKeyFrame(world.player.stateTime, Animation.ANIMATION_LOOPING);
                break;
            case Player.PLAYER_PUSH:
                keyFrame = Assets.player;
                break;
            case Player.PLAYER_IDLE:
                default:
                    keyFrame = Assets.player;
        }
    }

    private void renderOpponent()
    {
        TextureRegion keyFrame;
        switch(world.opponent.state)
        {
            case Opponent.OPPONENT_STATE_IDLE:
            default:
                keyFrame = Assets.opponent;
        }
    }

    private void renderRing()
    {
        Ring ring = world.ring;
        batcher.drawSprite(ring.position.x, ring.position.y, 2, 2, Assets.arena);
    }
}
