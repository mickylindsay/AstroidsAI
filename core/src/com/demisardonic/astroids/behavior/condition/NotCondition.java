package com.demisardonic.astroids.behavior.condition;

import com.demisardonic.astroids.entity.PhysicsObject;

public class NotCondition extends AbstractCondition {
    protected AbstractCondition condition;
    public NotCondition(AbstractCondition condition) {
        this.condition = condition;
    }

    @Override
    public boolean actIf(PhysicsObject entity, PhysicsObject target) {
        return !condition.actIf(entity, target);
    }
}
