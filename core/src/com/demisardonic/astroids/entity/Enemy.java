package com.demisardonic.astroids.entity;

import com.demisardonic.astroids.Collideable;
import com.demisardonic.astroids.EnemyBrain;
import com.demisardonic.astroids.behavior.AbstractBehavior;
import com.demisardonic.astroids.behavior.NullBehavior;

public class Enemy extends Entity {
    private AbstractBehavior abstractBehavior;
    private PhysicsObject target;
    private EnemyBrain brain;

    public Enemy(float x, float y){
        this(x, y, new NullBehavior());
    }

    public Enemy(float x, float y, AbstractBehavior abstractBehavior){
        super("entity.enemy", x, y, 1f, 0f);
        this.abstractBehavior = abstractBehavior;
        this.target = new PhysicsObject();
        this.brain = new EnemyBrain();
    }

    public Enemy(float x, float y, AbstractBehavior abstractBehavior, PhysicsObject target){
        super("entity.enemy", x, y, 1f, 0f);
        this.abstractBehavior = abstractBehavior;
        this.target = target;
    }

    @Override
    public void update(float dt) {
        this.brain = new EnemyBrain();
        this.acc = brain.getAcc();
        this.rotVel = brain.getRot();
        abstractBehavior.act(this, target);
        super.update(dt);
    }

    public void collide(Collideable collideable) {
        collideable.collide(this);
    }

    public void collide(Shot s) {
        if (this != s.getOwner()) {
            this.kill();
            s.kill();
        }
    }

    public void collide(Player p) {
        this.kill();
    }
}
