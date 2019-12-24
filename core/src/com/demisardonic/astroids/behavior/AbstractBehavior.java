package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.entity.PhysicsObject;

public abstract class AbstractBehavior {
    public abstract void act(PhysicsObject entity, PhysicsObject target);
}
