package com.demisardonic.astroids;

import com.badlogic.gdx.Gdx;
import com.demisardonic.astroids.entity.Enemy;
import com.demisardonic.astroids.entity.Entity;
import com.demisardonic.astroids.entity.Player;

import java.util.*;

public class Stage {
    private Set<Entity> entities;
    public Entity player;
    private List<Entity> toKill;
    private QuadTree<Entity> quadTree;

    public Stage(){
        player = new Player(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        entities = new HashSet<Entity>();
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            entities.add(new Enemy(rand.nextFloat()*Gdx.graphics.getWidth(), rand.nextFloat()*Gdx.graphics.getHeight()));
        }
        toKill = new ArrayList<Entity>();
    }

    public void update(float dt){
        quadTree = new QuadTree<Entity>(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        float maxEntityRadius = 0;
        for (Entity e : entities) {
            if (e.radius() > maxEntityRadius)
                maxEntityRadius = e.radius();
            quadTree.insert(e);
        }
        // Collision
        for (Entity e : entities) {
            for (Entity e2 : quadTree.query(e.pos.x(), e.pos.y(), maxEntityRadius + e.radius())) {
                if (e == e2) continue;
                float dist = e.center().dist(e2.center());
                float rad = e.radius() + e2.radius();
                if ( dist < rad ){
                    e.collide(e2);
                }
            }
        }

        for (Entity e : entities){
            e.update(dt);
            if (e.dead()){
                toKill.add(e);
            }
        }
        player.update(dt);
        entities.removeAll(toKill);
    }

    public void render(Renderer renderer, float dt){
        for (Entity e : entities){
            e.render(renderer, dt);
        }
        player.render(renderer, dt);
        if (MainGame.renderQuadTree) quadTree.render(renderer);
    }

    public Entity player() {
        return player;
    }

    public void spawn(Entity e) {
        entities.add(e);
    }
}
