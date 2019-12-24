package com.demisardonic.astroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.demisardonic.astroids.behavior.*;
import com.demisardonic.astroids.entity.Enemy;
import com.demisardonic.astroids.entity.Entity;
import com.demisardonic.astroids.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stage {
    private Set<Entity> entities;
    public static Entity player;
    private List<Entity> toKill;

    public Stage(){
        player = new Player(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        entities = new HashSet<Entity>();
        entities.add(new Enemy(200, 200, new CompositeBehavior(new FacingBehavior(), new SeekBehavior())));
        toKill = new ArrayList<Entity>();
    }

    public void update(float dt){
        for (Entity e : entities){
            e.update(dt);
            if(e.dead()){
                toKill.add(e);
            }
        }
        player.update(dt);
        entities.removeAll(toKill);
    }

    public void render(SpriteBatch batch, float dt){
        for (Entity e : entities){
            e.render(batch, dt);
        }

        player.render(batch, dt);
    }

    public Entity player() {
        return player;
    }
}
