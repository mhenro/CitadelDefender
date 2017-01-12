package ru.mhenro.defender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by mhenr on 08.11.2016.
 */

public class ZombieObject extends AbstractGameObject {
    private static final int FRAME_COLS = 6;
    private static final int FRAME_ROWS = 5;

    Animation walkAnimation;
    TextureRegion walkSheet;
    TextureRegion[] walkFrames;
    TextureRegion currentFrame;

    float stateTime;

    /* constructor */
    public ZombieObject() {
        init();
    }

    private void init() {
        TextureAtlas atlas;
        atlas = new TextureAtlas(Gdx.files.internal("test/test.atlas"));
        walkSheet = atlas.findRegion("anim");

        TextureRegion[][] tmp = TextureRegion.split(walkSheet.getTexture(), walkSheet.getRegionWidth()/FRAME_COLS, walkSheet.getRegionHeight()/FRAME_ROWS);
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(0.1f, walkFrames);      // #11
        stateTime = 0f;                         // #13
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();           // #15
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);  // #16
        //batch.setColor(255, 0, 0, 210);
        batch.draw(currentFrame, 0, 0, 1, 1);             // #17
    }
}
