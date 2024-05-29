package fr.sae.game.maps;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.sae.game.Global;
import fr.sae.game.Warp;

public class Foret7 extends BasicGameState {
	Warp Warp1;
	Warp Warp2;
	Warp Warp3;
	public Foret7(int stateID) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.Warp1= new Warp(1910, 0, 10, 70, 50, 60);//D
		this.Warp2= new Warp(1910, 840, 10, 130, 50, 900);//D
		this.Warp3= new Warp(0, 0, 1160, 10, 400, 1020);//HAUT
	}

	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.drawImage(new Image("data/maps/Map007.png").getScaledCopy(Global.width, Global.height), 0, 0);
        
        try {
	    	Global.P1.Sprite(g);
	    	Global.P1.getAnimation().stop();
	    	
        }catch(Exception e) {	
        	e.getMessage();
        	System.out.print(e);
        }
        this.Warp1.warp(Global.P1, sbg, 13);
        this.Warp2.warp(Global.P1, sbg, 13);
        this.Warp3.warp(Global.P1, sbg, 15);
       

//--------------------------------------------------------------------------------------------------------------------------
	//Temp	    

	    //Affiche toutes les collisions de la map et du joueur
	    if (true) {
		    g.draw(Global.P1.getHitbox());
		    
		    Global.CollisionMapForet7.drawCollisions(g);
		    this.Warp1.draw(g);
		    this.Warp2.draw(g);
		    this.Warp3.draw(g);
	    	}
//--------------------------------------------------------------------------------------------------------------------------
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Global.updatePlayerMovement(gc.getInput(),Global.CollisionMapForet7,delta);
		Global.P1.AnimateWhileMoove();
		
	}

	@Override
	public int getID() {
		return 17;
	}

}