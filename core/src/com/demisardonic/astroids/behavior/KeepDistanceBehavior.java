package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.behavior.condition.InsideRangeCondition;

public class KeepDistanceBehavior extends IfElseBehavior {

    public KeepDistanceBehavior(float distance) {
        super(new InsideRangeCondition(distance), new FleeBehavior(), new SeekBehavior());
    }
}
