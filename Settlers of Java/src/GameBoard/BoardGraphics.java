package GameBoard;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.Stroke;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BoardGraphics extends JPanel {

	//auto generated id
	private static final long serialVersionUID = -6080271973075824997L;
	//get the graphics object from the parent by overriding the normal paint and making our own
	@Override
    public void paintComponent(Graphics g) {
		//cast to the more capable graphics type
        Graphics2D g2d = (Graphics2D) g;
        //draw the hex grid
        drawGrid(g2d);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private void drawGrid(Graphics2D g2d){
		//set the rules for drawing with the graphics object passed in
        g2d.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
		//set the length from the center to the far vertices of the hex. 
        //The radius of the circumscribed circle
        double radius = 62;
        //calculate the radius of the inscribed circle
        //this helps with the math to place them
		double shortR = radius * Math.sqrt(3)/2;
		//center of the topmost left hexagon
		Point2D.Double start = new Point2D.Double(3*shortR+10, radius+15);
		double Xstart = start.getX();
		double Ystart = start.getY();
		
		//array with the center points of all hexagon
		ArrayList<Point2D.Double> centerPoints = new ArrayList<Point2D.Double>();
		
		
		for(int i=0;i<3;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
			g2d.draw(Hexagon(Xnext,Ystart,radius));
		}
		Xstart = Xstart-shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<4;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
			g2d.draw(Hexagon(Xnext,Ystart,radius));
		}
		Xstart = Xstart-shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<5;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
			g2d.draw(Hexagon(Xnext,Ystart,radius));
		}
		Xstart = Xstart+shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<4;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
			g2d.draw(Hexagon(Xnext,Ystart,radius));
		}
		Xstart = Xstart+shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<3;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
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
