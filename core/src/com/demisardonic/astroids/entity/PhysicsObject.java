package com.demisardonic.astroids.entity;

import com.demisardonic.astroids.Vector;

public class PhysicsObject {
    public float rot, rotVel;
    public Vector pos, vel, acc;

    public PhysicsObject(){
        this(0f, 0f, 0f);
    }

    public PhysicsObject(float x, float y, float r) {
        this(new Vector(x, y), new Vector(0, 0), new Vector(0, 0), r, 0);
    }

    public PhysicsObject(Vector pos, Vector vel, Vector acc, float rot, float rotVel){
        this.pos = pos;
        this.vel = vel;
        this.acc = acc;
        this.rot = rot;
        this.rotVel = rotVel;
    }

    public Vector center() {
        return pos;
    }
}
