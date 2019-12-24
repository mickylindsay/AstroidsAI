package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.Vector;
import com.demisardonic.astroids.entity.PhysicsObject;

public class ArriveBehavior extends SeekBehavior {
    private float range;

    public ArriveBehavior(float range){
        this.range = range;
    }

    @Override
    protected Vector desired(PhysicsObject entity, PhysicsObject target) {
        Vector desired = super.desired(entity, target);
        float dist = entity.center().dist((target.center()));
        if(dist < range) {
            desired = desired.scl(dist / range);
        }
        return desired;
    }
}
