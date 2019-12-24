package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.Stage;
import com.demisardonic.astroids.Vector;
import com.demisardonic.astroids.entity.Entity;

public class BasicChaseBehavior extends AbstractBehavior {
    protected float speed = 100f;

    @Override
    public void act(Entity entity, Entity target) {
        Vector targetPos = target.center();
        entity.vel = targetPos.sub(entity.center()).nor(speed);
    }
}
