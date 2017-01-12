package ru.mhenro.defender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.sun.media.jfxmediaimpl.MediaDisposer;

/**
 * Created by mhenr on 08.11.2016.
 */

public class WorldRenderer implements Disposable {
    private static String TAG = WorldRenderer.class.getName();

    private BitmapFont font;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController worldController;

    /* constructor */
    public WorldRenderer(WorldController worldController) {
        this.worldController = worldController;
        init();
    }

    private void init() {
        camera = new OrthographicCamera();
        camera.position.set(0, 0, 0);
        camera.setToOrtho(false, Constants.VIEWPORT_WIDTH , Constants.VIEWPORT_HEIGHT);
        camera.update();
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public void render() {
        batch.setProjectionMatrix(camera.combined);
        worldController.game.level.fog.render(batch);

        batch.begin();

        /* rendering zombies */
        for (ZombieObject zombie : worldController.game.level.zombies) {
            zombie.render(batch);
        }

        worldController.game.level.fortress.render(batch);

        batch.end();
    }

    public void resize(int width, int height) {
        camera.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
