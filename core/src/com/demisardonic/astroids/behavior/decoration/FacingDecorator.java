package com.demisardonic.astroids.behavior.decoration;

import com.demisardonic.astroids.behavior.AbstractBehavior;
import com.demisardonic.astroids.behavior.FacingBehavior;

public class FacingDecorator extends BehaviorDecorator {
    public FacingDecorator(AbstractBehavior beh) {
        super(new FacingBehavior(), beh);
    }
}
