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


}
