package com.demisardonic.astroids.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.demisardonic.astroids.AssetManager;
import com.demisardonic.astroids.Stage;
import com.demisardonic.astroids.Vector;

public class Entity extends PhysicsObject{
    protected final Texture texture;
    protected float scale, drag, speed;

    public Entity(String key, float x, float y, float scale, float rotation){
        super(x, y);
        texture = AssetManager.instance().texture(key);
        this.scale = scale;
        this.drag = 0.5f;
        this.speed = 100f;
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

    public void render(SpriteBatch batch, float dt){
       drawTexture(batch, pos.x(), pos.y(), scale, rotation);
    }

    public void dispose() { }

    public boolean dead() { return false; }

    public Vector center() {
        return super.center().add(texture.getWidth()/2f, texture.getHeight()/2f);
    }

    protected void drawTexture(SpriteBatch batch, float x, float y, float scale, float rotation){
        batch.draw(texture, x, y, texture.getWidth()/2f*scale, texture.getHeight()/2f*scale, texture.getWidth() * scale, texture.getHeight() * scale, 1, 1, rotation, 0, 0, texture.getWidth(), texture.getHeight(), false,false);
    }
}
