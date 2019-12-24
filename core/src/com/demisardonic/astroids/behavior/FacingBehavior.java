package com.demisardonic.astroids.behavior;

import com.demisardonic.astroids.Vector;
import com.demisardonic.astroids.entity.Entity;

public class FacingBehavior extends AbstractBehavior {
    private final float SPEED = 2f;
    @Override
    public void act(Entity entity, Entity target) {
        Vector targetPos = target.center().sub(entity.center());
        float desired = (float) (Math.toDegrees(Math.atan((targetPos.y()/targetPos.x()))));
        desired += targetPos.x() > 0 ? 270f : 90f;
        float alterRot = entity.rotation;
        float dRot = desired > alterRot ? SPEED : -SPEED;
        if (desired - alterRot > 180 )
            dRot = -SPEED;
        else if (desired - alterRot < -180 )
            dRot = SPEED;

        entity.rotation += dRot;
    }
}
