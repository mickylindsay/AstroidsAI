package com.demisardonic.astroids.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.demisardonic.astroids.Collideable;
import com.demisardonic.astroids.Renderer;
import com.demisardonic.astroids.Weapon;

public class Player extends Entity{
    private final float THRUST, ROTATION;
    private float baseDrag;

    private Weapon weapon;

    public Player(float x, float y){
        super("entity.player", x, y, 1f, 0f);
        THRUST = 200f;
        ROTATION = 3f;
        this.speed = 300;
        this.baseDrag = this.drag = 1f;
        this.weapon = new Weapon();
    }

    @Override
    public void update(float dt) {
        // shooting
        weapon.tick(dt);
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) weapon.shoot(this);

        // moving
        this.drag = this.baseDrag;
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            rotation += ROTATION;
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            rotation -= ROTATION;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            float dx = (float) (THRUST * Math.cos(Math.toRadians(rotation + 90)));
            float dy = (float) (THRUST * Math.sin(Math.toRadians(rotation + 90)));
            acc = acc.add(dx, dy);
            this.drag = 0.2f; // Less drag when accelerating
        }

        super.update(dt);

        // Bound position and rotation within screen
        if (pos.x() < -(texture.getWidth()/2f)) pos = pos.add(Gdx.graphics.getWidth(), 0);
        if (pos.x() > Gdx.graphics.getWidth() - (texture.getWidth()/2f)) pos = pos.add(-Gdx.graphics.getWidth(), 0);
        if (pos.y() < -(texture.getHeight()/2f)) pos = pos.add(0, Gdx.graphics.getHeight());
        if (pos.y() > Gdx.graphics.getHeight() - (texture.getHeight()/2f)) pos = pos.add(0, -Gdx.graphics.getHeight());

    }

    @Override
    public void render(Renderer renderer, float dt){
        // Render multiple players to handle edge overlap
        for (int c = -1; c <= 1 ; c++) {
            for (int r = -1; r <= 1; r++) {
                if (c == 0 && r == 0) continue;
                renderer.renderSprite(texture, pos.x() + Gdx.graphics.getWidth()*c, pos.y()+ Gdx.graphics.getHeight()*r, scale, rotation);
            }
        }
        super.render(renderer, dt);
    }

    public void collide(Collideable collideable) {
        collideable.collide(this);
    }
}
