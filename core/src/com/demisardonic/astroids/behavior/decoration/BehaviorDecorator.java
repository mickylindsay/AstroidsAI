package com.demisardonic.astroids.behavior.decoration;

import com.demisardonic.astroids.behavior.AbstractBehavior;
import com.demisardonic.astroids.entity.PhysicsObject;

public abstract class BehaviorDecorator extends AbstractBehavior {
    private AbstractBehavior outerBehavior;
    private AbstractBehavior innerBehavior;
    public BehaviorDecorator(AbstractBehavior outer, AbstractBehavior inner) {
        outerBehavior = outer;
        innerBehavior = inner;
    }

    @Override
    public void act(PhysicsObject entity, PhysicsObject target) {
        outerBehavior.act(entity, target);
        innerBehavior.act(entity, target);
    }
}
