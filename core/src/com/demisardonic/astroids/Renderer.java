package com.demisardonic.astroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Renderer {
    private OrthographicCamera camera;

    private SpriteBatch spriteBatch;
    private boolean openSprite;

    private ShapeRenderer shapeRenderer;
    private ShapeRenderer.ShapeType shapeType;

    public Renderer() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        camera.update();
        spriteBatch = new SpriteBatch();
        openSprite = false;
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeType = null;

    }

    public void renderSprite(Texture texture, float x, float y, float scale, float rotation) {
        if (!openSprite) {
            openSprite = true;
            spriteBatch.begin();
        }
        spriteBatch.draw(texture, x, y, texture.getWidth()/2f*scale, texture.getHeight()/2f*scale, texture.getWidth() * scale, texture.getHeight() * scale, 1, 1, rotation, 0, 0, texture.getWidth(), texture.getHeight(), false,false);
    }

    public void renderCircle(float x, float y, float radius) {
        if (shapeType != ShapeRenderer.ShapeType.Line) {
            if (shapeType != null)
                shapeRenderer.end();
            shapeType = ShapeRenderer.ShapeType.Line;
            shapeRenderer.begin(shapeType);
        }
        shapeRenderer.setColor(1, 1, 0, 1); //TODO allow for unique color
        shapeRenderer.circle(x, y, radius);
    }

    // TODO render line for debug entity acceleration

    public void close() {
        if (openSprite) {
            openSprite = false;
            spriteBatch.end();
        }

        if (shapeType != null) {
            shapeType = null;
            shapeRenderer.end();
        }
    }

    public void dispose() {
        spriteBatch.dispose();
    }
}
