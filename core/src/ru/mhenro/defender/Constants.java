package ru.mhenro.defender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

/**
 * Created by mhenr on 08.11.2016.
 */

public class Constants {
    public static final float VIEWPORT_WIDTH = 5.0f;
    public static final float VIEWPORT_HEIGHT = 5.0f;
    public static final float VIEWPORT_GUI_WIDTH = 800.0f;
    public static final float VIEWPORT_GUI_HEIGHT = 480.0f;

    public static final String TEXTURE_ATLAS_OBJECTS = "images/canyonbunny.pack";

    /* helper function to creating a mesh */
    public static Mesh createMesh(float posX, float posY, float width, float height, float color) {
        Mesh tmpMesh = null;

        tmpMesh = new Mesh(true, 4, 6,
                new VertexAttribute(VertexAttributes.Usage.Position, 3, ShaderProgram.POSITION_ATTRIBUTE),
                new VertexAttribute(VertexAttributes.Usage.ColorPacked, 4, ShaderProgram.COLOR_ATTRIBUTE),
                new VertexAttribute(VertexAttributes.Usage.TextureCoordinates, 2, ShaderProgram.TEXCOORD_ATTRIBUTE + "0"));

        tmpMesh.setVertices(new float[] {
                posX, posY, 0, color, -1f, -1f,
                posX + width, posY, 0, color, 1f, -1f,
                posX + width, posY + height, 0, color, 1f, 1f,
                posX, posY + height, 0, color -1f, 1f
        });
        tmpMesh.setIndices(new short[] {0, 1, 2, 2, 3, 0});

        return tmpMesh;
    }
}
