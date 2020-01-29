package com.demisardonic.astroids.weapon;

import com.demisardonic.astroids.MainGame;
import com.demisardonic.astroids.entity.Entity;
import com.demisardonic.astroids.entity.Shot;

public class Weapon {
    private float cooldown;
    private float maxCooldown;

    public Weapon(){
        this(0.1f);
    }

    public Weapon(float cooldown){
        this.maxCooldown = cooldown;
        this.cooldown = 0;
    }

    public void innerShoot(Entity owner) {
        MainGame.stage.spawn(new Shot(owner));
    }

    public void shoot(Entity owner) {
        if(cooldown < 0f){
            cooldown = maxCooldown;
            innerShoot(owner);
        }
    }

    public void tick(float dt) {
        cooldown -= dt;
    }
}
