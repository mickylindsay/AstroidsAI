package com.demisardonic.astroids.behavior.condition;

import com.demisardonic.astroids.behavior.condition.AbstractCondition;
import com.demisardonic.astroids.entity.Entity;

public class OutsideRangeCondition extends AbstractCondition {
    private float range;

    public OutsideRangeCondition(float range) {
        this.range = range;
    }

    @Override
    public boolean actIf(Entity entity, Entity target) {
        float distance = target.center().sub(entity.center()).mag();
        return  distance > range;
    }
}
