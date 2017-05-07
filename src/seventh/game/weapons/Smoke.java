/*
 * see license.txt 
 */
package seventh.game.weapons;

import seventh.game.Game;
import seventh.game.entities.Entity;
import seventh.game.net.NetEntity;
import seventh.game.net.NetSmoke;
import seventh.map.Map;
import seventh.math.Rectangle;
import seventh.math.Vector2f;
import seventh.shared.TimeStep;

/**
 * @author Tony
 *
 */
public class Smoke extends Entity {
    
    private NetSmoke netEntity;
    private long torchTime;
    private Vector2f targetVel;
    
    /**
     * @param position
     * @param speed
     * @param game
     * @param type
     */
    public Smoke(Vector2f position, int speed, Game game, final Vector2f targetVel) {
        super(position, speed, game, Type.SMOKE);
                
        this.targetVel = targetVel;
        
        this.bounds.width = 4;
        this.bounds.height = 4;
                
        this.torchTime = 10_000;
        
        this.netEntity = new NetSmoke();
        this.collisionHeightMask = 0;                
    }
    
    
    /* (non-Javadoc)
     * @see palisma.game.Entity#update(leola.live.TimeStep)
     */
    @Override
    public boolean update(TimeStep timeStep) {
        this.vel.set(this.targetVel);
        boolean isBlocked = super.update(timeStep);
                
        Map map = game.getMap();
        
        // grow the hit box
        // TODO: Hide players who
        // are within the bounds of smoke
        // to prevent cheating!!
        if(bounds.width < 64) {
            bounds.width += 1;
            if( map.rectCollides(bounds, 0) ) {
                isBlocked = true;
                bounds.width -= 1;
                                
            }        
        }
        
        if(bounds.height < 64) {
            bounds.height += 1;
            if( map.rectCollides(bounds, 0)) {
                isBlocked = true;
                bounds.height -= 1;
            }
        }
        
        torchTime -= timeStep.getDeltaTime();
        if(torchTime <= 0 ) {
            kill(this);
        }
        
        if(this.speed > 0) {
            this.speed -= 1;
        }
        
        int min = 10;
        if(speed < min) {
            speed = min;
        }
        
        
        //DebugDraw.drawRectRelative(this.bounds, 0x0a00ffff);

        return isBlocked;
    }
    
    protected void decreaseSpeed(float factor) {
        speed =  (int)(speed * factor);
    }
    
    
    /* (non-Javadoc)
     * @see palisma.game.Entity#collideX(int, int)
     */
    @Override
    protected boolean collideX(int newX, int oldX) {            
        this.targetVel.x = -this.targetVel.x;
        this.speed = (int)(this.speed * 0.7f);
        return true;
    }
    
    /* (non-Javadoc)
     * @see palisma.game.Entity#collideY(int, int)
     */
    @Override
    protected boolean collideY(int newY, int oldY) {
        this.targetVel.y = -this.targetVel.y;
        this.speed = (int)(this.speed * 0.7f);
        return true;        
    }

    @Override
    protected boolean collidesAgainstEntity(Rectangle bounds) {
        return false;
    }
    
    /* (non-Javadoc)
     * @see seventh.game.Entity#getNetEntity()
     */
    @Override
    public NetEntity getNetEntity() {    
        return getNetSmokeEntity();
    }
    
    
    public NetEntity getNetSmokeEntity() {
        setNetEntity(netEntity);        
        return this.netEntity;
    }
}
