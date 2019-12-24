package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.entity.Entity;

public abstract class AbstractBehavior {
    public abstract void act(Entity entity, Entity target);
}
