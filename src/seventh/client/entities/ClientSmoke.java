/*
 * see license.txt 
 */
package seventh.client.entities;

import seventh.client.ClientGame;
import seventh.client.gfx.AnimatedImage;
import seventh.client.gfx.Art;
import seventh.client.gfx.Camera;
import seventh.client.gfx.Canvas;
import seventh.client.gfx.effects.particle_system.Emitter;
import seventh.client.gfx.effects.particle_system.Emitters;
import seventh.client.sfx.Sounds;
import seventh.game.net.NetEntity;
import seventh.game.net.NetSmoke;
import seventh.math.Vector2f;
import seventh.shared.TimeStep;

/**
 * @author Tony
 *
 */
public class ClientSmoke extends ClientEntity {
    
    private boolean soundPlayed;    
    private long ownerId;    
    private Emitter smoke;    
    private AnimatedImage fireImg;
    /**
     * 
     */
    public ClientSmoke(ClientGame game, Vector2f pos) {
        super(game, pos);
        
        this.soundPlayed = false;
        
        bounds.width = 16;
        bounds.height = 16;
        //smoke = Emitters.newFireEmitter(pos);//new FireEmitter(pos, 3_900, 0, 500);
        //smoke.attachTo(this);
        
        fireImg = Art.newFireAnim();
    }
        
    /* (non-Javadoc)
     * @see palisma.client.ClientEntity#update(leola.live.TimeStep)
     */
    @Override
    public void update(TimeStep timeStep) {    
        super.update(timeStep);
        
//        if(!soundPlayed) {
//            Sounds.playSound(Sounds.explodeSnd, ownerId, pos);
//            this.soundPlayed = true;
//        }        
//        
//        smoke.update(timeStep);
//        fireImg.update(timeStep);
    }

    /* (non-Javadoc)
     * @see leola.live.gfx.Renderable#render(leola.live.gfx.Canvas, leola.live.gfx.Camera, long)
     */
    @Override
    public void render(Canvas canvas, Camera camera, float alpha) {        
        
//        Vector2f cameraPos = camera.getPosition();
//        int x = (int)(pos.x - cameraPos.x);
//        int y = (int)(pos.y - cameraPos.y);
        
        //canvas.drawScaledImage(fireImg.getCurrentImage(), x-bounds.width/4, y-bounds.height/4, 32, 32, 0x3fffffff);
//        smoke.render(canvas, camera, alpha);
    }

}

