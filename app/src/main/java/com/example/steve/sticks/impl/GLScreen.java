package com.example.steve.sticks.impl;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Screen;

public abstract class GLScreen extends Screen {
    protected final GLGraphics glGraphics;
    protected final GLGame glGame;
    
    public GLScreen(Game game) {
        super(game);
        glGame = (GLGame)game;
        glGraphics = glGame.getGLGraphics();
    }
}
