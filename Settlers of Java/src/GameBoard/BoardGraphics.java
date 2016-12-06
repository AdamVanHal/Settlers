/*
*	@file BoardGaphics.java
*	@author Adam Van Hal
*	@date 10-17-16
*	@Extends JPanel to create a custom graphic element for the GUI screen with the hexagon board
*/
package GameBoard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JPanel;
import gui.PlayWindow;
//eclipse is not detecting all my imported class uses,
//so I added this to suppress some warnings.
@SuppressWarnings("unused")
public class BoardGraphics extends JPanel {

	//auto generated id
	private static final long serialVersionUID = -6080271973075824997L;
	
	//set the length from the center to the far vertices of the hex. 
    //The radius of the circumscribed circle
	private double radius = 62;
	//calculate the radius of the inscribed circle
    //this helps with the math to place them
	private double shortR = radius * Math.sqrt(3)/2;
	//center of the topmost left hexagon
	private Point2D.Double start = new Point2D.Double(3*shortR+30, radius+65);
	//array with the center points of all hexagon
	private ArrayList<Point2D.Double> centerPoints = new ArrayList<Point2D.Double>(25);
	//array of all the vertex locations that can have settlements.
	private ArrayList<Point2D.Double> vertex = new ArrayList<Point2D.Double>(60);
	//array of all centers of edge locations where roads could be
	private ArrayList<Point2D.Double> edge = new ArrayList<Point2D.Double>(80);
	
	//arrays of edges correlating to their orientation
	private int[] UpDiagonalEdges 	= {1,3,5,11,13,15,17,24,26,28,30,32,41,43,45,47,49,56,58,60,62,68,70,72};
	private int[] DownDiagonalEdges = {2,4,6,12,14,16,18,25,27,29,31,33,40,42,44,46,48,55,57,59,61,67,69,71};
	private int[] verticalEdges 	= {7,8,9,10,19,20,21,22,23,34,35,36,37,38,39,50,51,52,53,54,63,64,65,66};
	
	//store the state the program is in for hit checking on the map
	//0=do no checks
	//1=try to build settlement
	//2=try to build road
	//3=try to build city
	private int cursorState = 0;
	
	/*
	 * @pre    None
	 * @post   Constructor to setup public variables and create any swing components for this panel 
	 * @return None
	 */
	public BoardGraphics(){
		BoardGraphics bg = this;
		//store original Cursor in case we change it
		Cursor old = bg.getCursor();
		//calculate the important points on the grid, store in global array
		generateCenters();
		generateVertex();
		generateEdges();
		
		//Mouse listener that tracks clicks in map
		//Code currently uses states to find out if the user is trying to build something when clicking
		//this code is setup to execute code when it finds where the user is clicking and resets the state
		//Currently this does nothing if the position is not a valid coordinate for building
		bg.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent arg0){
				bg.setCursor(old);
				//Check for build settlement state
				if(cursorState == 1){
					Point2D pos = bg.getMousePosition();
					for(int i=0;i<vertex.size();i++){
						//check if the position of the cursor on click is within 1/3 of a radius of a vertex
						//this removes any ambiguity of what the user is clicking on
						if(vertex.get(i).distance(pos)<(radius/3)){
							//place code to build settlement here
							System.out.println("Build Settlement @ "+(i+1));
							break;
						}
					}
					cursorState = 0;
				}
				//check for build road state
				if(cursorState == 2){
					Point2D pos = bg.getMousePosition();
					for(int i=0;i<edge.size();i++){
						//check if the position of the cursor on click is within 1/3 of a radius of a vertex
						//this removes any ambiguity of what the user is clicking on
						if(edge.get(i).distance(pos)<(radius/3)){
							//place code here to build road
							System.out.println("Build Road @ "+(i+1));
							break;
						}
					}
					cursorState = 0;
				}
				//check for build city state
				if(cursorState == 3){
					Point2D pos = bg.getMousePosition();
					for(int i=0;i<vertex.size();i++){
						//check if the position of the cursor on click is within 1/3 of a radius of a vertex
						//this removes any ambiguity of what the user is clicking on
						if(vertex.get(i).distance(pos)<(radius/3)){
							//place code here to build city
							System.out.println("Build City @ "+(i+1));
							break;
						}
					}
					cursorState = 0;
				}
			}
		});
		
		//add buttons for building
		JButton bldSettlement = new JButton("Build Settlement");
		bldSettlement.setBounds(0, 0, 89, 23);
		bldSettlement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Cursor c = new Cursor(Cursor.HAND_CURSOR);
				bg.setCursor(c);
				//set state to acknowledge to the other listener code that we are building
				cursorState = 1;
			}
		});
		bg.add(bldSettlement);
		
		JButton bldRoad = new JButton("Build Road");
		bldRoad.setBounds(95, 0, 89, 23);
		bldRoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Cursor c = new Cursor(Cursor.HAND_CURSOR);
				bg.setCursor(c);
				//set state to acknowledge to the other listener code that we are building
				cursorState = 2;
			}
		});
		bg.add(bldRoad);
		
		JButton bldCity = new JButton("Build City");
		bldCity.setBounds(184, 0, 89, 23);
		bldCity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Cursor c = new Cursor(Cursor.HAND_CURSOR);
				bg.setCursor(c);
				//set state to acknowledge to the other listener code that we are building
				cursorState = 3;
			}
		});
		bg.add(bldCity);
	}
	
	/*
	 * @pre    A valid Graphics object from the parent
	 * @post   Uses the graphics object passed to it and overrides the paint command to paint our objects 
	 * @return None
	 */
	@Override
    public void paintComponent(Graphics g) {
		//cast to the more capable graphics type
        Graphics2D g2d = (Graphics2D) g;
        //adds the blue water background
        g2d.setBackground(new Color(61,179,219,128));
        g2d.clearRect(0, 0, 685, 644);
        //this.setBackground(new Color(61,179,219,128));
        //draw the hex grid
        drawGrid(g2d);
    }
	
	/*
	 * @pre    None
	 * @post   None 
	 * @return None
	 */
	public static void main(String[] args) {
		// stub for if we decide to make this stand alone for prototyping reasons

	}
	
	/*
	 * @pre    Valid Graphics2D object from caller to draw with
	 * @post   Draw the game grid in the proper position 
	 * @return None
	 */
	private void drawGrid(Graphics2D g2d){
		//set the rules for drawing with the graphics object passed in
        g2d.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
		//draw tiles
        for(int i=0; i<centerPoints.size();i++){
        	//set the color used by graphics and fill in a hexagon
        	
        	int ResourceType = PlayWindow.game.getPiece(i).getTileResource();
        	
        	//changing the color to draw with depending on the type of the resource tile, 0: Desert 1: grain 2: lumber 3: wool 4: ore  5: brick  
        	if(ResourceType == 0){
        		g2d.setPaint(new Color(242,241,234,255));
        	}
        	else if(ResourceType == 1){
        		g2d.setPaint(new Color(249,237,9,255));
        	}
        	else if(ResourceType == 2){
        		g2d.setPaint(new Color(19,119,8,255));
        	}
        	else if(ResourceType == 3){
        		g2d.setPaint(new Color(136,214,19,255));
        	}
        	else if(ResourceType == 4){
        		g2d.setPaint(new Color(114,107,97,255));
        	}
        	else if(ResourceType == 5){
        		g2d.setPaint(new Color(209,79,50,255));
        	}
        	//g2d.setPaint(new Color((float)Math.random(),(float)Math.random(),(float)Math.random(),1));
        	g2d.fill(Hexagon(centerPoints.get(i).getX(),centerPoints.get(i).getY(),radius));
        }
        //draw labels for tiles, vertexes and edges
        g2d.setPaint(new Color(0,0,0,255));
        for(int i=0; i<centerPoints.size();i++){
        	
        	g2d.drawString(Integer.toString(PlayWindow.game.getPiece(i).getTileID()), (float)centerPoints.get(i).getX(), (float)centerPoints.get(i).getY());
        }
        
        //g2d.fill(Robber(centerPoints.get(5).getX(), centerPoints.get(5).getY(), 6));
        
        
        //function that creates a settlement at every vertex
        /*g2d.setPaint(new Color(49,92,119,255));
        for(int i = 0; i<vertex.size();i++){
        	//g2d.rotate(Math.toRadians(45),(float)vertex.get(i).getX(),(float)vertex.get(i).getY());
        	g2d.fill(City((float)vertex.get(i).getX(), (float)vertex.get(i).getY(), 8));
        	//g2d.rotate(Math.toRadians(-45),(float)vertex.get(i).getX(),(float)vertex.get(i).getY());
        }*/
        for(int i = 0; i < 54; i++){
        	if(PlayWindow.game.getPoint(i).hasSettlement()){
        		if(PlayWindow.game.getPoint(i).getPlayerNumber() == 1){
        			g2d.setPaint(new Color(49,92,119,255));
        		}
        		else if(PlayWindow.game.getPoint(i).getPlayerNumber() == 2){
        			g2d.setPaint(new Color(49,92,119,255));
        		}
        		else if(PlayWindow.game.getPoint(i).getPlayerNumber() == 3){
        			g2d.setPaint(new Color(49,92,119,255));
				}
        		else if(PlayWindow.game.getPoint(i).getPlayerNumber() == 4){
        			g2d.setPaint(new Color(49,92,119,255));
				}
        		g2d.fill(City((float)vertex.get(i).getX(), (float)vertex.get(i).getY(), 8));
        	}
        }
        
        //function that creates a rectangle on every edge
        /*g2d.setPaint(new Color(49,92,119,255));
        for(int i = 0; i<edge.size();i++){
        	for(int j = 0; j < 24; j++){
        		if(i == (UpDiagonalEdges[j]-1)){
        			g2d.rotate(Math.toRadians(-30),(float)edge.get(i).getX(),(float)edge.get(i).getY());
                	g2d.fill(Road((float)edge.get(i).getX(), (float)edge.get(i).getY(), 10));
                	g2d.rotate(Math.toRadians(30),(float)edge.get(i).getX(),(float)edge.get(i).getY());
        		}
        		else if(i == (DownDiagonalEdges[j]-1)){
        			g2d.rotate(Math.toRadians(30),(float)edge.get(i).getX(),(float)edge.get(i).getY());
                	g2d.fill(Road((float)edge.get(i).getX(), (float)edge.get(i).getY(), 10));
                	g2d.rotate(Math.toRadians(-30),(float)edge.get(i).getX(),(float)edge.get(i).getY());
        		}
        		else if(i == (verticalEdges[j]-1)){
        			g2d.rotate(Math.toRadians(90),(float)edge.get(i).getX(),(float)edge.get(i).getY());
                	g2d.fill(Road((float)edge.get(i).getX(), (float)edge.get(i).getY(), 10));
                	g2d.rotate(Math.toRadians(-90),(float)edge.get(i).getX(),(float)edge.get(i).getY());
        		}
        	}
        }*/
        
        
        g2d.setPaint(new Color(0,0,0,255));
        for(int i=0;i<vertex.size();i++){
        	g2d.drawString(Integer.toString(i+1), (float)vertex.get(i).getX(), (float)vertex.get(i).getY());
        }
        
        for(int i=0;i<edge.size();i++){
        	g2d.drawString(Integer.toString(i+1), (float)edge.get(i).getX(), (float)edge.get(i).getY());
        }
	}
	
	/*
	 * @pre    Center of the hexagon and the radius of the hexagon
	 * @post   None 
	 * @return GeneralPath object that describes the perimeter of a hexagon
	 */
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
	
	/*
	 * @pre    Center of the Road and the distance of a quarter of the length
	 * @post   None 
	 * @return GeneralPath object that describes the Road
	 */
	private GeneralPath Road(double Xcenter, double Ycenter, double radius ){
		double Xpoints[] = {Xcenter+(2*radius),		Xcenter+(2*radius),		Xcenter-(2*radius),		Xcenter-(2*radius)};
		double Ypoints[] = {Ycenter+(radius/2),	Ycenter-(radius/2), Ycenter-(radius/2),	Ycenter+(radius/2)};
		GeneralPath road = new GeneralPath(GeneralPath.WIND_EVEN_ODD,Xpoints.length);
		//add coordinates to the shape
		road.moveTo(Xpoints[0], Ypoints[0]);
		for (int index = 1; index < Xpoints.length; index++) {
	        road.lineTo(Xpoints[index], Ypoints[index]);
		};
		//close the polygon off
		road.closePath();
		return road;
	}
	
	/*
	 * @pre    Center of the City and the distance of a portion of the size
	 * @post   None 
	 * @return GeneralPath object that describes the City
	 */
	private GeneralPath City(double Xcenter, double Ycenter, double radius ){
		double Xpoints[] = {Xcenter-(radius/2),	Xcenter-(radius/2),	Xcenter+(radius/2),	Xcenter+(1.5*radius),	Xcenter+(1.5*radius),	Xcenter-(1.5*radius),	Xcenter-(1.5*radius)};
		double Ypoints[] = {Ycenter-(radius/2),	Ycenter-(1.5*radius), Ycenter-(2.5*radius),	Ycenter-(1.5*radius), Ycenter+(1.5*radius), Ycenter+(1.5*radius), Ycenter-(radius/2)};
		GeneralPath city = new GeneralPath(GeneralPath.WIND_EVEN_ODD,Xpoints.length);
		//add coordinates to the shape
		city.moveTo(Xpoints[0], Ypoints[0]);
		for (int index = 1; index < Xpoints.length; index++) {
	        city.lineTo(Xpoints[index], Ypoints[index]);
		};
		//close the polygon off
		city.closePath();
		return city;
	}
	
	/*
	 * @pre    Center of the City and the distance of a portion of the size
	 * @post   None 
	 * @return GeneralPath object that describes the City
	 */
	private GeneralPath Robber(double Xcenter, double Ycenter, double radius ){
		double Xpoints[] = {Xcenter-(radius/2),		Xcenter+(radius/2),		Xcenter+(1.5*radius),	Xcenter+(1.5*radius),	
							Xcenter+(radius/2),		Xcenter+(1.5*radius),	Xcenter+(1.5*radius),	Xcenter-(1.5*radius),
							Xcenter-(1.5*radius),	Xcenter-(radius/2),		Xcenter-(1.5*radius),	Xcenter-(1.5*radius)};
		double Ypoints[] = {Ycenter-(3*radius),		Ycenter-(3*radius),		Ycenter-(2*radius),		Ycenter, 
							Ycenter+radius,			Ycenter+(2*radius),		Ycenter+(3*radius),		Ycenter+(3*radius),
							Ycenter+(2*radius),		Ycenter+radius,			Ycenter,				Ycenter-(2*radius)};
		GeneralPath city = new GeneralPath(GeneralPath.WIND_EVEN_ODD,Xpoints.length);
		//add coordinates to the shape
		city.moveTo(Xpoints[0], Ypoints[0]);
		for (int index = 1; index < Xpoints.length; index++) {
	        city.lineTo(Xpoints[index], Ypoints[index]);
		};
		//close the polygon off
		city.closePath();
		return city;
	}
	
	/*
	 * @pre    Center of the hexagon and the radius of the hexagon
	 * @post   None 
	 * @return GeneralPath object that describes the perimeter of a hexagon
	 */
	private GeneralPath Settlement(double Xcenter, double Ycenter, double radius ){
		double Xpoints[] = {Xcenter,				Xcenter+(1.5*radius),	Xcenter+radius,	Xcenter+radius,			Xcenter-radius, 		Xcenter-radius,	Xcenter-(1.5*radius)};
		double Ypoints[] = {Ycenter-(1.5 *radius),	Ycenter, 				Ycenter,		Ycenter+(1.5*radius),	Ycenter+(1.5*radius),	Ycenter,		Ycenter};
		GeneralPath settle = new GeneralPath(GeneralPath.WIND_EVEN_ODD,Xpoints.length);
		//add coordinates to the shape
		settle.moveTo(Xpoints[0], Ypoints[0]);
		for (int index = 1; index < Xpoints.length; index++) {
	        settle.lineTo(Xpoints[index], Ypoints[index]);
		};
		//close the polygon off
		settle.closePath();
		return settle;
	}
	
	/*
	 * @pre    Valid Radius and start point defined in gobal variables
	 * @post   Centers of all hexagons found 
	 * @return None
	 */
	private void generateCenters(){
		//construct the array of center locations
		double Xstart = start.getX();
		double Ystart = start.getY();
		for(int i=0;i<3;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
		}
		Xstart = Xstart-shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<4;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
		}
		Xstart = Xstart-shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<5;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
		}
		Xstart = Xstart+shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<4;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
		}
		Xstart = Xstart+shortR;
		Ystart = Ystart+1.5*radius;
		for(int i=0;i<3;i++){
			double Xnext = 2*i*shortR+Xstart;
			centerPoints.add(new Point2D.Double(Xnext,Ystart));
		}
	}
	/*
	 * @pre    Valid Radius and start point defined in gobal variables
	 * @post   Vertexes of all hexagons found 
	 * @return None
	 */
	private void generateVertex(){
		//add vertex points
		double Xstart = start.getX();
		double Ystart = start.getY()-radius;
		//move in Y direction
		for(int i=0;i<12;i++){
			//adjust y position as we move in rows
			//moving from even to odd rows is half a radius down, odd to even is a full radius moved
			if(i%2==0 && i!=0){Ystart+=radius;}
			if(i%2==1){Ystart+=0.5*radius;}
			//adjust the first x coordinate
			//we go out one shortR on even to odd transitions in the top half
			//and we go in one shortR on even to odd transitions in the bottom
			if(i%2==1 && i<6){Xstart-=shortR;}
			if(i%2==1 && i>6){Xstart+=shortR;}
			//calculate number of vertexes in row
			int col = 6;
			if(i<=4){
				col = 3+((int)((i+1)/2));
			}
			if(i>=7){
				col = 6-((int)((i-5)/2));
			}
			//move in X position
			for(int j=0;j<col;j++){
				double Xnext = Xstart+2*j*shortR;
				vertex.add(new Point2D.Double(Xnext, Ystart));
			}
		}//end calculate vertexes
	}
	/*
	 * @pre    Valid Radius and start point defined in gobal variables
	 * @post   Centers of the edges of all hexagons found 
	 * @return None
	 */
	private void generateEdges(){
		//add locations of edge centers
		double Xstart = start.getX()-0.5*shortR;
		double Ystart = start.getY()-0.75*radius;
		//move in Y direction
		for(int i=0;i<11;i++){
			//adjust y position as we move in rows
			//moving down 0.75 radius every time
			if(i!=0){Ystart+=0.75*radius;}
			//adjust the first x coordinate
			//always step out half a short radius until row 5 then in
			if(i!=0 && i<=5){Xstart-=0.5*shortR;}
			if(i>5){Xstart+=0.5*shortR;}
			//calculate number of edges in row
			int col=0;
			if(i%2==0&&i<5){col = 6+i;}
			if(i%2==0&&i>5){col = 10-(i-6);}
			if(i%2==1&&i<6){col = (int)i/2+4;}
			if(i%2==1&&i>6){col = (int)6 - (i-5)/2;}
			//move in X position
			for(int j=0;j<col;j++){
				double Xnext;
				if(i%2==0){
					Xnext = Xstart+shortR*j;
				}else{
					Xnext = Xstart+2*j*shortR;
				}
				edge.add(new Point2D.Double(Xnext, Ystart));
			}
		}//end edge center calc
	}
}
