package com.demisardonic.astroids;

import com.demisardonic.astroids.entity.Entity;
import com.demisardonic.astroids.entity.Shot;

public class Weapon {
    private float cooldown;
    private float maxCooldown;

    public Weapon(){
        this.maxCooldown = 0.1f;
        this.cooldown = 0;
    }

    public void shoot(Entity owner) {
        if(cooldown < 0f){
            cooldown = maxCooldown;
            MainGame.stage.spawn(new Shot(owner));
        }
    }

    public void tick(float dt) {
        cooldown -= dt;
    }
}
