package com.example.steve.sticks.game;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import com.example.steve.sticks.Game;
import com.example.steve.sticks.Input.TouchEvent;
import com.example.steve.sticks.gl.Camera2D;
import com.example.steve.sticks.gl.SpriteBatcher;
import com.example.steve.sticks.gl.Texture;
import com.example.steve.sticks.gl.TextureRegion;
import com.example.steve.sticks.impl.GLScreen;
import com.example.steve.sticks.math.OverlapTester;
import com.example.steve.sticks.math.Rectangle;
import com.example.steve.sticks.math.Vector2;

public class HelpScreen2 extends GLScreen
{
    Camera2D guiCam;
    SpriteBatcher batcher;
    Rectangle nextBounds;
    Vector2 touchpoint;
    Texture helpImage;
    TextureRegion helpRegion;

    public HelpScreen2(Game game)
    {
        super(game);

        guiCam = new Camera2D(glGraphics, 320, 480);
        nextBounds = new Rectangle(320 - 64, 0, 64, 64);
        touchpoint = new Vector2();
        batcher = new SpriteBatcher(glGraphics, 1);
    }

    @Override
    public void resume()
    {
        helpImage = new Texture(glGame, "help2.png");
        helpRegion = new TextureRegion(helpImage, 0, 0, 320, 480);
    }

    @Override
    public void pause()
    {
        helpImage.dispose();
    }

    @Override
    public void update(float deltaTime)
    {
        List<TouchEvent>touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        int len = touchEvents.size();

        for(int i = 0; i < len; i++)
        {
            TouchEvent event = touchEvents.get(i);
            touchpoint.set(event.x, event.y);
            guiCam.touchToWorld(touchpoint);

            if(event.type == TouchEvent.TOUCH_UP)
            {
                if(OverlapTester.pointInRectangle(nextBounds, touchpoint))
                {
                    Assets.playSound(Assets.clickSound);
                    game.setScreen(new HelpScreen3(game));
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime)
    {
        GL10 gl = glGraphics.getGL();
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        guiCam.setViewportAndMatrices();

        gl.glEnable(GL10.GL_TEXTURE_2D);

        batcher.beginBatch(helpImage);
        batcher.drawSprite(160, 240, 320, 480, helpRegion);
        batcher.endBatch();

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        batcher.beginBatch(Assets.items);
        batcher.drawSprite(320 -31, 32, 64, 64, Assets.leftArrow);
        batcher.endBatch();

        gl.glDisable(GL10.GL_BLEND);
    }

    @Override
    public void dispose()
    {

    }
}