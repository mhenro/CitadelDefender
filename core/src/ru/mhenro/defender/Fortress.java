package ru.mhenro.defender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by mhenr on 10.11.2016.
 */

public class Fortress extends AbstractGameObject {
    TextureRegion tex;

    public Fortress() {
        init();
    }

    private void init() {
        TextureAtlas atlas;
        atlas = new TextureAtlas(Gdx.files.internal("test/test.atlas"));
        tex = atlas.findRegion("fortress");
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void render(SpriteBatch batch) {
        //batch.setColor();
        batch.draw(tex, 3, 0, 2, 3);
    }
}
