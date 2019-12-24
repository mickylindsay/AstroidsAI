package com.demisardonic.astroids.behavior.condition;

public class InsideRangeCondition extends NotCondition {
    public InsideRangeCondition(float range) {
        super(new OutsideRangeCondition(range));
    }
}
