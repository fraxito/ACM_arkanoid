package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GRect;

/*
 * Autor: Jorge Cisneros
 * 
 * El Arkanoid pero orientado a objetos
 */

public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1 = new Pelota(7, Color.GREEN);
	//Pelota pelota2 = new Pelota(30, Color.BLUE);
	Barra barra1 = new Barra(360, 15, Color.RED);
    int anchoLadrillo = 25;
    int altoLadrillo = 15;
    int espacioMenu = 200;
	
    //el sistema del marcador

    Marcador marcador = new Marcador(20, 40); 
    
	public void init(){
		addMouseListeners();
		setSize(600, 600);
		GRect lateral = new GRect(3, getHeight());
		lateral.setFilled(true);
		add(lateral, getWidth() - espacioMenu - lateral.getWidth() - pelota1.getWidth(), 0);
		add(pelota1, 0, getHeight()*0.60 - pelota1.getHeight());
		add(barra1, 0 , getHeight()*0.80);
	}
	
	public void run(){
		dibujaNivel01();
		marcador.dibuja(this);
		while (true){
			pelota1.muevete(this);
			//pelota2.muevete(this);
			barra1.mueveBarra((int)pelota1.getX(), getWidth()-espacioMenu);
			pause(1);
		}
		
	}
	
	public void mouseMoved (MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth()-espacioMenu);
	}
	
	private void dibujaNivel01(){
		int numLadrillos = 14; 
		for (int j=0; j < numLadrillos; j++){
			for(int i=j; i < numLadrillos; i++){
				Ladrillo miLadrillo =
				new Ladrillo(anchoLadrillo*i - anchoLadrillo*j/2,
						     altoLadrillo*j,
						     anchoLadrillo, 
						     altoLadrillo, 
						     Color.PINK);
				
				add(miLadrillo);
				pause(7);
			}
		}
	}
}











