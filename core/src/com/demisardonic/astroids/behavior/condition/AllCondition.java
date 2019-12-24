package com.demisardonic.astroids.behavior.condition;

import com.demisardonic.astroids.entity.PhysicsObject;

import java.util.List;

public class AllCondition extends AbstractCondition {
    protected List<AbstractCondition> conditions;
    public AllCondition(List<AbstractCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean actIf(PhysicsObject entity, PhysicsObject target) {
        for(AbstractCondition c : conditions){
            if (!c.actIf(entity, target))
                return false;
        }
        return true;
    }
}
