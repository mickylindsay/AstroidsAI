package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.Vector;
import com.demisardonic.astroids.entity.PhysicsObject;

public class BasicChaseBehavior extends AbstractBehavior {
    protected float speed = 100f;

    @Override
    public void act(PhysicsObject entity, PhysicsObject target) {
        Vector targetPos = target.center();
        entity.vel = targetPos.sub(entity.center()).nor(speed);
    }
}
