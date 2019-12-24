package com.demisardonic.astroids.behavior.condition;

import com.demisardonic.astroids.entity.PhysicsObject;

public abstract class AbstractCondition {
    public abstract boolean actIf(PhysicsObject entity, PhysicsObject target);
}
