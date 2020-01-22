package com.demisardonic.astroids;

import com.demisardonic.astroids.entity.Enemy;
import com.demisardonic.astroids.entity.Player;
import com.demisardonic.astroids.entity.Shot;

public interface Collideable {
    void collide(Collideable collideable);

    void collide(Player p);
    void collide(Shot s);
    void collide(Enemy e);
}
