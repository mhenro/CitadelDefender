package ru.mhenro.defender;

import com.badlogic.gdx.utils.Array;

/**
 * Created by mhenr on 10.11.2016.
 */

public class Level {
    public Array<ZombieObject> zombies;
    public FogObject fog;
    public Fortress fortress;

    public Level() {
        zombies = new Array<ZombieObject>();
        fog = new FogObject();
        zombies.add(new ZombieObject());
        fortress = new Fortress();
    }
}
