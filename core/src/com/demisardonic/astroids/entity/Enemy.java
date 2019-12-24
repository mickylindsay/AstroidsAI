package com.demisardonic.astroids.entity;

import com.demisardonic.astroids.Stage;
import com.demisardonic.astroids.Vector;
import com.demisardonic.astroids.behavior.AbstractBehavior;

public class Enemy extends Entity {
    private AbstractBehavior abstractBehavior;

    public Enemy(float x, float y, AbstractBehavior abstractBehavior){
        super("entity.enemy", x, y, 1f, 0f);
        this.abstractBehavior = abstractBehavior;
    }

    @Override
    public void update(float dt) {
        abstractBehavior.act(this, Stage.player);
        super.update(dt);

    }
}
