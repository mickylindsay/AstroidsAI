package com.demisardonic.astroids.entity;

import com.demisardonic.astroids.Vector;

public class PhysicsObject {
    public float rotation;
    public Vector pos, vel, acc;

    public PhysicsObject(){
        this(0, 0);
    }

    public PhysicsObject(float x, float y) {
        this(new Vector(x, y), new Vector(0, 0), new Vector(0, 0), 0f);
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
