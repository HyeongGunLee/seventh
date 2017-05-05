/*
 * see license.txt 
 */
package seventh.game.weapons;

import seventh.game.Game;
import seventh.game.entities.Entity;
import seventh.game.entities.Entity.Type;
import seventh.math.Vector2f;
import seventh.shared.SoundType;
import seventh.shared.TimeStep;

/**
 * The grenade belt holds a set of grenades for launching.
 * 
 * @author Tony
 *
 */
public class GrenadeBelt extends Weapon {
        
    public static GrenadeBelt newFrag(Game game, Entity owner, int amount) {
        GrenadeBelt belt = new GrenadeBelt(game, owner, Type.GRENADE);
        belt.bulletsInClip = amount;
        return belt;
    }
    
    public static GrenadeBelt newSmoke(Game game, Entity owner, int amount) {
        GrenadeBelt belt = new GrenadeBelt(game, owner, Type.SMOKE_GRENADE);
        belt.bulletsInClip = amount;
        return belt;
    }
    
    
    private final int nextShotTime;
    private int timePinPulled;
    private boolean isPinPulled;
    
    /**
     * @param game
     * @param owner
     */
    public GrenadeBelt(Game game, Entity owner) {
        this(game, owner, Type.GRENADE);
    }
    
    /**
     * @param game
     * @param owner
     * @param grenadeType
     */
    public GrenadeBelt(Game game, Entity owner, Type grenadeType) {
        super(game, owner, grenadeType);
            
        this.nextShotTime = 600;
        this.damage = 100;
                
        this.bulletsInClip = 3;
        this.totalAmmo = 0;
        this.clipSize = 0;
        
        applyScriptAttributes("grenade_belt");
    }
    
    @Override
    public boolean isPrimary() {    
        return false;
    }
        
    public int getNumberOfGrenades() {
        return this.bulletsInClip;
    }
    
    /**
     * @return if the pin is pulled
     */
    public boolean isPinPulled() {
        return this.isPinPulled;
    }
    
    public boolean pullPin() {
        return beginFire();
    }
    
    /**
     * Throws a grenade
     */
    public boolean throwGrenade() {
        beginFire();
        return endFire();
    }
    
    /* (non-Javadoc)
     * @see palisma.game.Weapon#update(leola.live.TimeStep)
     */
    @Override
    public void update(TimeStep timeStep) {
        super.update(timeStep);
        
        if(this.isPinPulled) {
            this.timePinPulled++;
        }
    }
    
    /* (non-Javadoc)
     * @see palisma.game.Weapon#beginFire()
     */
    @Override
    public boolean beginFire() {
        if(!this.isPinPulled && canFire()) {
            this.isPinPulled = true;
            game.emitSound(getOwnerId(), SoundType.GRENADE_PINPULLED, getPos());
            return true;
        }
        return super.beginFire();
    }
    
    /* (non-Javadoc)
     * @see palisma.game.Weapon#endFire()
     */
    @Override
    public boolean endFire() {    
        if ( canFire() ) {
            newGrenade(getType(), timePinPulled);
            game.emitSound(getOwnerId(), SoundType.GRENADE_THROW, getPos());
            
            bulletsInClip--;
            weaponTime = nextShotTime;
            
            isPinPulled = false;
            timePinPulled = 0;
            
            setFireState();             
            return true;
        }
                
        return false;
    }
    
    /* (non-Javadoc)
     * @see palisma.game.Weapon#calculateVelocity(leola.live.math.Vector2f)
     */
    @Override
    protected Vector2f calculateVelocity(Vector2f facing) {
        return facing.createClone();
    }

}
