package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.entity.PhysicsObject;

public class HaltBehavior extends AbstractBehavior {
    @Override
    public void act(PhysicsObject entity, PhysicsObject target) {
        entity.vel = entity.vel.scl(0.9f);
    }
}
