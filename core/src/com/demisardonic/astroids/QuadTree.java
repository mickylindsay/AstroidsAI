package com.demisardonic.astroids;

import com.demisardonic.astroids.entity.PhysicsObject;

import java.util.ArrayList;
import java.util.List;

public class QuadTree<N extends PhysicsObject> {
    private static final int MAX_CAPACITY = 10;
    private float x, y, w, h;

    private List<N> values;

    private QuadTree<N> topLeft;
    private QuadTree<N> topRight;
    private QuadTree<N> bottomLeft;
    private QuadTree<N> bottomRight;

    public QuadTree(float x, float y, float w, float h) {
        values = new ArrayList<N>(MAX_CAPACITY);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void insert(N object) {
        if (!inBounds(object.pos)) return;
        if (values.size() < MAX_CAPACITY) {
            values.add(object);
        } else {
            if (topLeft == null) {
                topLeft = new QuadTree<N>(x, y+h/2, w/2, h/2);
                topRight = new QuadTree<N>(x+(w/2), y+(h/2), w/2, h/2);
                bottomLeft = new QuadTree<N>(x, y, w/2, h/2);
                bottomRight = new QuadTree<N>(x+(w/2), y, w/2, h/2);
            }

            topLeft.insert(object);
            topRight.insert(object);
            bottomLeft.insert(object);
            bottomRight.insert(object);
        }
    }

    public List<N> query(float x, float y, float r) {
        return null;
    }

    public boolean inBounds(Vector p) {
        return p.x() > this.x && p.x() <= this.x + this.w &&
                p.y() > this.y && p.y() <= this.y + this.h;
    }
}
