package com.demisardonic.astroids;

public class Vector {
    private float x, y;

    public Vector(final float x, final float y){
        this.x = x;
        this.y = y;
    }

    public float x() { return x; }
    public float y() { return y; }
    public Vector add(float dx, float dy) { return new Vector(x + dx, y + dy); }
    public Vector add(Vector v) { return add(v.x, v.y); }
    public Vector sub(float dx, float dy) {  return add(-dx, -dy); }
    public Vector sub(Vector v) { return add(-v.x, -v.y); }
    public Vector scl(float s) { return new Vector(x * s, y * s); }
    public float mag() { return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); }
    public float dist(Vector v) { return (float) Math.sqrt(Math.pow(v.x-x, 2) + Math.pow(v.y-y, 2)); }
    public Vector nor(float f) {
        float mag = mag();
        if (mag == 0)
            return new Vector(0, 0);
        return scl(f/mag());
    }
    public Vector nor() { return nor(1f); }
    public Vector trunk(float m) {
        if (mag() > m) return nor(m);
        return this;
    }

    public String toString() { return "x: " + x + ",y: " + y; }
}
