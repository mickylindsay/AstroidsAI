package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.behavior.condition.AbstractCondition;
import com.demisardonic.astroids.entity.PhysicsObject;

public class IfBehavior extends AbstractBehavior {
    protected AbstractCondition condition;
    protected AbstractBehavior behavior;
    public IfBehavior(AbstractCondition condition, AbstractBehavior behavior) {
        this.condition = condition;
        this.behavior = behavior;
    }
    @Override
    public void act(PhysicsObject entity, PhysicsObject target){
        if (condition.actIf(entity, target))
            behavior.act(entity, target);
    }
}
