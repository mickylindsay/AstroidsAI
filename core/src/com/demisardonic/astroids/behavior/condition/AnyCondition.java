package com.demisardonic.astroids.behavior.condition;

import com.demisardonic.astroids.entity.PhysicsObject;

import java.util.List;

public class AnyCondition extends AbstractCondition {
    protected List<AbstractCondition> conditions;
    public AnyCondition(List<AbstractCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean actIf(PhysicsObject entity, PhysicsObject target) {
        for(AbstractCondition c : conditions){
            if (c.actIf(entity, target))
                return true;
        }
        return false;
    }
}
