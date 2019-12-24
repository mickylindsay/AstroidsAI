package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.entity.PhysicsObject;

public class CompositeBehavior extends AbstractBehavior{
    protected AbstractBehavior[] behaviors;
    public CompositeBehavior(AbstractBehavior... behaviors) {
        this.behaviors = behaviors;
    }

    @Override
    public void act(PhysicsObject entity, PhysicsObject target) {
        for(AbstractBehavior b : behaviors){
            b.act(entity, target);
        }
    }
}
