package com.demisardonic.astroids.behavior.condition;

import com.demisardonic.astroids.behavior.condition.AbstractCondition;
import com.demisardonic.astroids.entity.Entity;

public class NotCondition extends AbstractCondition {
    protected AbstractCondition condition;
    public NotCondition(AbstractCondition condition) {
        this.condition = condition;
    }

    @Override
    public boolean actIf(Entity entity, Entity target) {
        return !condition.actIf(entity, target);
    }
}
