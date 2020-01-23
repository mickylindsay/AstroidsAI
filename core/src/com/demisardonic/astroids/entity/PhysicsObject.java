package com.demisardonic.astroids.entity;

import com.demisardonic.astroids.Vector;

public class PhysicsObject {
    public float rotation;
    public Vector pos, vel, acc;

    public PhysicsObject(){
        this(0f, 0f, 0f);
    }

    public PhysicsObject(float x, float y, float r) {
        this(new Vector(x, y), new Vector(0, 0), new Vector(0, 0), r);
    }

    public PhysicsObject(Vector pos, Vector vel, Vector acc, float rotation){
        this.pos = pos;
        this.vel = vel;
        this.acc = acc;
        this.rotation = rotation;
    }

    public Vector center() {
        return pos;
    }
}
