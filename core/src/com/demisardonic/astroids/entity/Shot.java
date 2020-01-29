package com.demisardonic.astroids.entity;

import com.badlogic.gdx.Gdx;
import com.demisardonic.astroids.Collideable;
import com.demisardonic.astroids.Vector;

public class Shot extends Entity {
    private Entity owner;

    public Shot(Entity owner, float x, float y, float scale, float rot) {
        super("entity.shot", x, y, scale, rot);
        this.drag = 0f;
        this.speed = 500f;

        Vector v = new Vector(1f,0f).rotate(Math.toRadians(rot + 90f));
//        v = new Vector(v.x() * (float) Math.cos(Math.toRadians(rot + 90f)),
//                v.x() * (float) Math.sin(Math.toRadians(rot + 90f)));
        this.vel = v.scl(this.speed);

        //Shift shot pos by its exture width and place it in front of the owner
        this.pos = this.pos.sub(texture.getWidth() / 2f, texture.getHeight() / 2f).add(v.scl(owner.texture.getWidth() / 2f));
        this.owner = owner;
    }

    public Shot(Entity owner) {
        super("entity.shot", owner.center().x(), owner.center().y(), 1f, owner.rot);
        this.drag = 0f;
        this.speed = 500f;

        Vector v = new Vector(1f,0f);
        v = new Vector(v.x() * (float) Math.cos(Math.toRadians(owner.rot + 90f)),
                v.x() * (float) Math.sin(Math.toRadians(owner.rot + 90f)));
        this.vel = v.scl(this.speed);

        //Shift shot pos by its exture width and place it in front of the owner
        this.pos = this.pos.sub(texture.getWidth() / 2f, texture.getHeight() / 2f).add(v.scl(owner.texture.getWidth() / 2f));
        this.owner = owner;
    }

    public Entity getOwner() {
        return owner;
    }

    public boolean dead() {
        return super.dead() ||
               pos.x() < -texture.getWidth() ||
               pos.x() > Gdx.graphics.getWidth() + texture.getWidth() ||
               pos.y() < -texture.getHeight() ||
               pos.y() > Gdx.graphics.getHeight() + texture.getHeight();
    }

    public void collide(Collideable collideable) {
        collideable.collide(this);
    }
}

