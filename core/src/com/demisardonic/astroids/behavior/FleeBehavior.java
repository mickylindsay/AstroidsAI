package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.Stage;
import com.demisardonic.astroids.Vector;
import com.demisardonic.astroids.entity.Entity;

public class FleeBehavior extends AbstractBehavior {
    protected float speed = 100f;
    protected float maxForce = 5f;

    @Override
    public void act(Entity entity, Entity target) {
        Vector desired = entity.center().sub(target.center()).nor(speed);
        Vector steering = desired.sub(entity.vel).trunk(maxForce);
        entity.vel = entity.vel.add(steering).trunk(speed);
    }
}
