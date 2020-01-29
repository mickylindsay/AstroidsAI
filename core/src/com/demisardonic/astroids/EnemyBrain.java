package com.demisardonic.astroids;

import com.demisardonic.astroids.entity.PhysicsObject;

public class EnemyBrain {
    private Vector acc;
    private float rot;

    private PhysicsObject target;

    public EnemyBrain(Vector a, float r) {
        this.acc = a;
        this.rot = r;
    }

    public EnemyBrain() {
        this(new Vector(0,0), 0f);
    }

    public void addAcc(Vector a, float dt){
        acc.add(a.scl(dt));
    }

    public void addRot(float r, float dt){
        rot += r*dt;
    }

    public Vector getAcc(){ return acc; }

    public float getRot(){
        return rot;
    }


    public void setTarget(PhysicsObject target) {
        this.target = target;
    }

    public PhysicsObject getTarget() { return target; }
}
