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
        entities = new HashSet<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            entities.add(new Enemy(rand.nextFloat()*Gdx.graphics.getWidth(), rand.nextFloat()*Gdx.graphics.getHeight()));
        }
        toKill = new ArrayList<>();
    }

    public void update(float dt){
        // Generate the quad tree and find largest radius
        // used to reduce number of possible collisions that need to be calculated
        quadTree = new QuadTree<>(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        float maxEntityRadius = 0;
        for (Entity e : entities) {
            if (e.radius() > maxEntityRadius)
                maxEntityRadius = e.radius();
            quadTree.insert(e);
        }

        // Collision
        for (Entity e : entities) {
            // Max distance that needs to be queried is this entities radius plus
            // the largest radius that could cause an collision (the largest collision radius being rendered)
            for (Entity e2 : quadTree.query(e.pos.x(), e.pos.y(), maxEntityRadius + e.radius())) {
                if (e == e2) continue;
                if ( e.center().dist(e2.center()) < e.radius() + e2.radius() ){
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
