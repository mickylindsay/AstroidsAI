package com.demisardonic.astroids.behavior.condition;

import com.demisardonic.astroids.entity.Entity;

public abstract class AbstractCondition {
    public abstract boolean actIf(Entity entity, Entity target);
}
