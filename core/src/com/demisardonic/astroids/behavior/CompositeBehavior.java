package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.entity.Entity;

import java.util.List;

public class CompositeBehavior extends AbstractBehavior{
    protected AbstractBehavior[] behaviors;
    public CompositeBehavior(AbstractBehavior... behaviors) {
        this.behaviors = behaviors;
    }

    @Override
    public void act(Entity entity, Entity target) {
        for(AbstractBehavior b : behaviors){
            b.act(entity, target);
        }
    }
}
