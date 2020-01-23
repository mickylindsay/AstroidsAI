package com.demisardonic.astroids.entity;

import com.demisardonic.astroids.Collideable;
import com.demisardonic.astroids.MainGame;
import com.demisardonic.astroids.behavior.AbstractBehavior;

public class Enemy extends Entity {
    private AbstractBehavior abstractBehavior;

    public Enemy(float x, float y){
        this(x, y, null);
    }

    public Enemy(float x, float y, AbstractBehavior abstractBehavior){
        super("entity.enemy", x, y, 1f, 0f);
        this.abstractBehavior = abstractBehavior;
    }

    @Override
    public void update(float dt) {
        if (abstractBehavior != null)
            abstractBehavior.act(this, MainGame.stage.player());
        super.update(dt);
    }

    public void collide(Collideable collideable) {
        collideable.collide(this);
    }

    public void collide(Shot s) {
        if (this != s.getOwner()) {
            this.kill();
            s.kill();
        }
    }
}
