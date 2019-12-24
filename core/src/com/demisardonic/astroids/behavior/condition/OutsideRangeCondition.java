package com.demisardonic.astroids.behavior.condition;

import com.demisardonic.astroids.entity.PhysicsObject;

public class OutsideRangeCondition extends AbstractCondition {
    private float range;

    public OutsideRangeCondition(float range) {
        this.range = range;
    }

    @Override
    public boolean actIf(PhysicsObject entity, PhysicsObject target) {
        float distance = target.center().sub(entity.center()).mag();
        return  distance > range;
    }
}
