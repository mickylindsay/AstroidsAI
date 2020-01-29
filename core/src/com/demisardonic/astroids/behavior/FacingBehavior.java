package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.Vector;
import com.demisardonic.astroids.entity.PhysicsObject;

public class FacingBehavior extends AbstractBehavior {
    private final float SPEED = 2f;
    @Override
    public void act(PhysicsObject entity, PhysicsObject target) {
        Vector targetPos = target.center().sub(entity.center());
        float desired = (float) (Math.toDegrees(Math.atan((targetPos.y()/targetPos.x()))));
        desired += targetPos.x() > 0 ? 270f : 90f;
        float alterRot = entity.rot;
        float dRot = desired > alterRot ? SPEED : -SPEED;
        if (desired - alterRot > 180 )
            dRot = -SPEED;
        else if (desired - alterRot < -180 )
            dRot = SPEED;

        entity.rot += dRot;
    }
}
