/*
 * see license.txt
 */
package seventh.game.entities;

import seventh.game.Game;
import seventh.game.net.NetEntity;
import seventh.math.Vector2f;
import seventh.shared.SoundType;
import seventh.shared.TimeStep;

/**
 * Health pack which adds health to a Player's entity.
 * 
 * @author Tony
 *
 */
public class HealthPack extends Entity {

    private NetEntity netEntity;
    
    /**
     * @param position
     * @param game
     */
    public HealthPack(Vector2f position, Game game) {
        this(game.getNextPersistantId(), position, game);        
    }

    /**
     * @param id
     * @param position
     * @param game
     */
    public HealthPack(int id, Vector2f position, final Game game) {
        super(id, position, 0, game, Type.HEALTH_PACK);
        init(game);
    }

    private void init(final Game game) {
        this.onTouch = new OnTouchListener() {
            
            @Override
            public void onTouch(Entity me, Entity other) {
                if(other.isAlive() && other.getType().equals(Type.PLAYER) && !other.isAtMaxHealth()) {
                    other.setHealth(other.getMaxHealth());
                    game.emitSound(getId(), SoundType.HEALTH_PACK_PICKUP, getCenterPos());
                    softKill();
                }
            }
        };
        this.bounds.width = 16;
        this.bounds.height = 16;
        
        this.netEntity = new NetEntity();
        this.netEntity.type = Type.HEALTH_PACK.netValue();      
        
    }
    /* (non-Javadoc)
     * @see seventh.game.Entity#getNetEntity()
     */
    @Override
    public NetEntity getNetEntity() {
        setNetEntity(this.netEntity);
        return this.netEntity;
    }

    /* (non-Javadoc)
     * @see seventh.game.Entity#canTakeDamage()
     */
    @Override
    public boolean canTakeDamage() {
        return false;
    }
    
    /* (non-Javadoc)
     * @see seventh.game.Entity#update(seventh.shared.TimeStep)
     */
    @Override
    public boolean update(TimeStep timeStep) {        
        game.doesTouchPlayers(this);        
        return true;
    }
}
