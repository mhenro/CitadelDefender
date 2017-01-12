package ru.mhenro.defender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by mhenr on 09.11.2016.
 */

public class FogObject extends AbstractGameObject {
    Mesh mesh;
    ShaderProgram shaderProgram;
    float stateTime;

    Texture img;

    /* constructor */
    public FogObject() {
        init();
    }

    private void init() {
        mesh = Constants.createMesh(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Color.toFloatBits(255, 0, 0, 90));
        //mesh = Constants.createMesh(1, 0, 4, 3);
        ShaderProgram.pedantic = false;
        shaderProgram = new ShaderProgram(Gdx.files.internal("shaders/vertex.glsl").readString(),
                Gdx.files.internal("shaders/fragment_fog.glsl").readString());


        img = new Texture("badlogic.jpg");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        float dt = Gdx.graphics.getDeltaTime();
        stateTime += dt;
        float angle = stateTime * (2 * MathUtils.PI);
        if (angle > (2 * MathUtils.PI)) {
            angle -= (2 * MathUtils.PI);
        }

        shaderProgram.begin();
        shaderProgram.setUniformMatrix("u_projTrans", batch.getProjectionMatrix());
        shaderProgram.setUniformf("iGlobalTime", stateTime);
        Vector2 resolution = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shaderProgram.setUniformf("iResolution", resolution);
        mesh.render(shaderProgram, GL20.GL_TRIANGLES);
        shaderProgram.end();
    }
}
