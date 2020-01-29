package com.demisardonic.astroids.weapon;

import com.demisardonic.astroids.MainGame;
import com.demisardonic.astroids.entity.Entity;
import com.demisardonic.astroids.entity.Shot;
import com.demisardonic.astroids.weapon.Weapon;

public class SpreadWeapon extends Weapon {
    @Override
    public void innerShoot(Entity owner) {
        MainGame.stage.spawn(new Shot(owner));
        MainGame.stage.spawn(new Shot(owner, owner.center().x(), owner.center().y(), 1f, owner.rot+10));
        MainGame.stage.spawn(new Shot(owner, owner.center().x(), owner.center().y(), 1f, owner.rot-10));
    }
}
