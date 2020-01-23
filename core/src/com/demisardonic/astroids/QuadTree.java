package com.demisardonic.astroids;

import com.demisardonic.astroids.entity.PhysicsObject;

import java.util.ArrayList;
import java.util.List;

public class QuadTree<N extends PhysicsObject> {
    private static final int MAX_CAPACITY = 8;
    private float x, y, w, h;
    private boolean divide;

    private List<N> values;

    private QuadTree<N> topLeft;
    private QuadTree<N> topRight;
    private QuadTree<N> bottomLeft;
    private QuadTree<N> bottomRight;

    public QuadTree(float x, float y, float w, float h) {
        values = new ArrayList<>(MAX_CAPACITY);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.divide = false;
    }

    public void insert(N object) {
        if (!inBounds(object.pos)) return;
        if (values.size() < MAX_CAPACITY) {
            values.add(object);
        } else {
            if (!divide) {
                divide = true;
                topLeft = new QuadTree<>(x, y+h/2, w/2, h/2);
                topRight = new QuadTree<>(x+(w/2), y+(h/2), w/2, h/2);
                bottomLeft = new QuadTree<>(x, y, w/2, h/2);
                bottomRight = new QuadTree<>(x+(w/2), y, w/2, h/2);
            }

            topLeft.insert(object);
            topRight.insert(object);
            bottomLeft.insert(object);
            bottomRight.insert(object);
        }
    }

    public List<N> query(float x, float y, float r) {
        List<N> values = new ArrayList<>();
        queryReq(x, y, r, values);
        return values;
    }

    public void render(Renderer renderer){
        renderer.renderRect(x, y, w, h);
        if (divide){
            topLeft.render(renderer);
            topRight.render(renderer);
            bottomLeft.render(renderer);
            bottomRight.render(renderer);
        }
    }

    private void queryReq(float x, float y, float r, List<N> retValues) {
        if(intersectsCircle(x,y,r)) retValues.addAll(values);
        if(divide) {
            topLeft.queryReq(x, y, r, retValues);
            topRight.queryReq(x, y,r, retValues);
            bottomLeft.queryReq(x, y,r, retValues);
            bottomRight.queryReq(x, y,r, retValues);
        }
    }

    private boolean inBounds(Vector p) {
        return p.x() > this.x && p.x() <= this.x + this.w &&
                p.y() > this.y && p.y() <= this.y + this.h;
    }

    private boolean intersectsCircle(float cX, float cY, float r) {
        // Spent quite a bit thinking about AABB intersections with circles
        // Thanks https://stackoverflow.com/questions/21089959/detecting-collision-of-rectangle-with-circle
        float distX = Math.abs(cX-x-(w/2));
        float distY = Math.abs(cY-y-(h/2));

        if (distX > (w/2+r) || distY > (h/2+r))
            return false;
        if (distX <= w/2 || distY <= h/2)
            return true;

        float dx = distX - w / 2;
        float dy = distY - h / 2;
        return (dx * dx + dy * dy <= r * r);
    }
}
