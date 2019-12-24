package com.demisardonic.astroids.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.demisardonic.astroids.Stage;
import com.demisardonic.astroids.Vector;

public class Player extends Entity{

    private final float THRUST, ROTATION;

    public Player(float x, float y){
        super("entity.player", x, y, 1f, 0f);
        THRUST = 200f;
        ROTATION = 3f;
        this.speed = 300;
        this.drag = 1f;
        System.out.println(pos);
    }

    @Override
    public void update(float dt) {
        float drag = this.drag;
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            rotation += ROTATION;
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            rotation -= ROTATION;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            float dx = (float) (THRUST * Math.cos(Math.toRadians(rotation + 90)));
            float dy = (float) (THRUST * Math.sin(Math.toRadians(rotation + 90)));
            acc = acc.add(dx, dy);
            drag = 0.2f; // Less drag when accelerating
        }

        super.update(dt);

        // Bound position and rotation within screen and 360 degrees
        if (pos.x() < -(texture.getWidth()/2f)) pos = pos.add(Gdx.graphics.getWidth(), 0);
        if (pos.x() > Gdx.graphics.getWidth() - (texture.getWidth()/2f)) pos = pos.add(-Gdx.graphics.getWidth(), 0);
        if (pos.y() < -(texture.getHeight()/2f)) pos = pos.add(0, Gdx.graphics.getHeight());
        if (pos.y() > Gdx.graphics.getHeight() - (texture.getHeight()/2f)) pos = pos.add(0, -Gdx.graphics.getHeight());

    }

    @Override
    public void render(SpriteBatch batch, float dt){
        for (int c = -1; c <= 1 ; c++) {
            for (int r = -1; r <= 1; r++) {
                drawTexture(batch, pos.x() + Gdx.graphics.getWidth()*c, pos.y()+ Gdx.graphics.getHeight()*r, scale, rotation);
            }
        }
    }
}
