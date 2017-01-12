package ru.mhenro.defender;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by mhenr on 08.11.2016.
 */

public abstract class AbstractGameObject {

    public Vector2 position;
    public Vector2 dimension;
    public Vector2 origin;
    public Vector2 scale;
    public float rotation;

    public void update(float deltaTime) {}
    public void render(SpriteBatch batch) {}
}
