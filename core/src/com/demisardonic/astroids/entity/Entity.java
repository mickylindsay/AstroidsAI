package com.demisardonic.astroids.entity;

import com.badlogic.gdx.graphics.Texture;
import com.demisardonic.astroids.*;

public abstract class Entity extends PhysicsObject implements Collideable {
    protected final Texture texture;
    protected float scale, drag, speed;
    protected boolean dead;
    protected float radius;

    public Entity(String key, float x, float y, float scale, float rotation){
        super(x, y, rotation);
        texture = AssetManager.instance().texture(key);
        this.scale = scale;
        this.drag = 0.5f;
        this.speed = 100f;
        this.dead = false;
        this.radius = texture.getWidth() / 2f; //TODO better sphere bounds per entity
    }

    public void update(float dt) {
        pos = pos.add(vel.scl(dt));
        vel = vel.add(acc.scl(dt));
        acc = new Vector(0,0);

        // Speed tends to zero
        vel = vel.add(vel.scl(-1 * dt * drag));
        // Bound speed
        vel = vel.trunk(speed);

        if (rotation >= 360f) rotation -= 360f;
        if (rotation < 0f) rotation += 360f;
    }

    public void render(Renderer renderer, float dt){
       renderer.renderSprite(texture, pos.x(), pos.y(), scale, rotation);
       if (MainGame.renderCollision)
           renderer.renderCircle(center().x(), center().y(), radius);
    }

    public void dispose() { }

    public boolean dead() { return dead; }

    public void kill() { dead = true; }

    public Vector center() {
        return super.center().add(texture.getWidth()/2f, texture.getHeight()/2f);
    }

    public float radius() { return radius; }

    public abstract void collide(Collideable collideable);

    public void collide(Player p) { }
    public void collide(Shot s) { }
    public void collide(Enemy e) { }
}
