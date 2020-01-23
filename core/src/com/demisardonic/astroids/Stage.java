package com.demisardonic.astroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.demisardonic.astroids.behavior.*;
import com.demisardonic.astroids.behavior.condition.InsideRangeCondition;
import com.demisardonic.astroids.entity.Enemy;
import com.demisardonic.astroids.entity.Entity;
import com.demisardonic.astroids.entity.Player;

import java.util.*;

public class Stage {
    private Set<Entity> entities;
    public Entity player;
    private List<Entity> toKill;

    public Stage(){
        player = new Player(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        entities = new HashSet<Entity>();
        entities.add(new Enemy(200, 200, new CompositeBehavior(new FacingBehavior(), new ArriveBehavior(100f))));
        entities.add(new Enemy(300, 100, new CompositeBehavior(new FacingBehavior(),
                new IfElseBehavior(new InsideRangeCondition(100f), new HaltBehavior(), new SeekBehavior()))));
        entities.add(new Enemy(500, 100, new CompositeBehavior(new FacingBehavior(), new KeepDistanceBehavior(100f))));
        Random rand = new Random();
        for (int i = 0; i < 2000; i++) {

            entities.add(new Enemy(rand.nextFloat()*Gdx.graphics.getWidth(), rand.nextFloat()*Gdx.graphics.getHeight(), new CompositeBehavior(new FacingBehavior(), new KeepDistanceBehavior(100f))));
        }
        toKill = new ArrayList<Entity>();
    }

    public void update(float dt){
        QuadTree<Entity> quadTree = new QuadTree<Entity>(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        for (Entity e : entities) quadTree.insert(e);
        // Collision
        for (Entity e : entities) {
            for (Entity e2 : entities /* TODO query quadtree */) {
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
    }

    public Entity player() {
        return player;
    }

    public void spawn(Entity e) {
        entities.add(e);
    }
}
