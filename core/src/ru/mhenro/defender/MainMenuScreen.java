package ru.mhenro.defender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by mhenr on 08.11.2016.
 */

public class MainMenuScreen implements Screen {
    final CitadelDefender game;
    OrthographicCamera camera;
    private BitmapFont font;
    private SpriteBatch batch;
    Mesh meshBack;
    ShaderProgram shaderProgram;
    float time;

    public MainMenuScreen(final CitadelDefender game) {
        this.game = game;

        meshBack = Constants.createMesh(0, 0, Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT, Color.toFloatBits(255, 0, 0, 90));
        //mesh = Constants.createMesh(1, 0, 4, 3);
        ShaderProgram.pedantic = false;
        shaderProgram = new ShaderProgram(Gdx.files.internal("shaders/vertex.glsl").readString(),
                Gdx.files.internal("shaders/fragment_menu.glsl").readString());
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.position.set(0, 0, 0);
        camera.setToOrtho(false, Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        camera.update();
        font = new BitmapFont();
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
        }

        batch.setProjectionMatrix(camera.combined);

        shaderProgram.begin();
        shaderProgram.setUniformMatrix("u_projTrans", camera.combined);
        shaderProgram.setUniformf("time", time);
        Vector2 resolution = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shaderProgram.setUniformf("resolution", resolution);
        meshBack.render(shaderProgram, GL20.GL_TRIANGLES);
        shaderProgram.end();

        batch.begin();
        font.draw(batch, "Tap on the screen to start the game!", Constants.VIEWPORT_GUI_WIDTH/2-100, Constants.VIEWPORT_GUI_HEIGHT/2 - 16);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
