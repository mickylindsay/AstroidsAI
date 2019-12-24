package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.behavior.condition.AbstractCondition;
import com.demisardonic.astroids.entity.PhysicsObject;

public class IfElseBehavior extends AbstractBehavior {
    protected AbstractCondition condition;
    protected AbstractBehavior ifBehavior;
    protected AbstractBehavior elseBehavior;
    public IfElseBehavior(AbstractCondition condition, AbstractBehavior ifBehavior, AbstractBehavior elseBehavior) {
        this.condition = condition;
        this.ifBehavior = ifBehavior;
        this.elseBehavior = elseBehavior;
    }
    @Override
    public void act(PhysicsObject entity, PhysicsObject target){
        if (condition.actIf(entity, target))
            ifBehavior.act(entity, target);
        else
            elseBehavior.act(entity, target);
    }
}
