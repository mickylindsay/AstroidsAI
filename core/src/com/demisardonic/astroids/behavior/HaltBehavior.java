package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.entity.Entity;

public class HaltBehavior extends AbstractBehavior {
    @Override
    public void act(Entity entity, Entity target) {
        entity.vel = entity.vel.scl(0.9f);
    }
}
