package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.Vector;
import com.demisardonic.astroids.entity.PhysicsObject;

public class SeekBehavior extends AbstractBehavior {
    protected float speed = 100f;
    protected float maxForce = 5f;

    @Override
    public void act(PhysicsObject entity, PhysicsObject target) {
        Vector desired = desired(entity, target);
        Vector steering = desired.sub(entity.vel).trunk(maxForce);
        entity.vel = entity.vel.add(steering).trunk(speed);
    }

    protected Vector desired(PhysicsObject entity, PhysicsObject target) {
        return target.center().sub(entity.center()).nor(speed);
    }
}
