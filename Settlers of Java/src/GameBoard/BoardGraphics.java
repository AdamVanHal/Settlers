package GameBoard;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;
import java.awt.Stroke;

import javax.swing.JPanel;

public class BoardGraphics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6080271973075824997L;

	@Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        drawGrid(g2d);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private void drawGrid(Graphics2D g2d){
		double radius = 25;
		double shortR = radius * Math.sqrt(3)/2;
		double Xstart = 190;
		double Ystart = 60;
		for(int i=0;i<3;i++){
			double Xnext = 2*i*shortR+Xstart;
			g2d.draw(Hexagon(Xnext,Ystart,radius));
		}
		Xstart = Xstart-shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<4;i++){
			double Xnext = 2*i*shortR+Xstart;
			g2d.draw(Hexagon(Xnext,Ystart,radius));
		}
		Xstart = Xstart-shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<5;i++){
			double Xnext = 2*i*shortR+Xstart;
			g2d.draw(Hexagon(Xnext,Ystart,radius));
		}
		Xstart = Xstart+shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<4;i++){
			double Xnext = 2*i*shortR+Xstart;
			g2d.draw(Hexagon(Xnext,Ystart,radius));
		}
		Xstart = Xstart+shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<3;i++){
			double Xnext = 2*i*shortR+Xstart;
			g2d.draw(Hexagon(Xnext,Ystart,radius));
		}
	}
	
	private GeneralPath Hexagon(double Xcenter, double Ycenter, double radius ){
		//calculate the relative location of all points on a hexagon
		double shortR = radius * Math.sqrt(3)/2;
		double Xpoints[] = {Xcenter+shortR,		Xcenter+shortR,		Xcenter,		Xcenter-shortR, 	Xcenter-shortR, 	Xcenter};
		double Ypoints[] = {Ycenter+0.5*radius,	Ycenter-0.5*radius, Ycenter-radius,	Ycenter-0.5*radius,	Ycenter+0.5*radius,	Ycenter+radius};
		GeneralPath hex = new GeneralPath(GeneralPath.WIND_EVEN_ODD,Xpoints.length);
		//add coordinates to the shape
		hex.moveTo(Xpoints[0], Ypoints[0]);
		for (int index = 1; index < Xpoints.length; index++) {
	        hex.lineTo(Xpoints[index], Ypoints[index]);
		};
		//close the polygon off
		hex.closePath();
		return hex;
	}
}
