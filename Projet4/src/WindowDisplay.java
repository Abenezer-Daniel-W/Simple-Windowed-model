import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;
import java.awt.Color;
import java.util.ArrayList;

public class WindowDisplay implements DrawListener {
	private Draw draw;
	private ArrayList<Window> win;
	private double x0;
	private double y0;
	private Window inUse;
	
	public WindowDisplay(int x, int y) {
		draw = new Draw();
		win = new ArrayList<Window>();
		draw.addListener(this);
		draw.setCanvasSize(x, y);
		draw.setXscale(0, x);
		draw.setYscale(0, y);
	}
	 class Window{
		private double x;
		private double y;
		
		private double sizeX;
		private double sizeY;
		private Color playerColor;
		
		public Window(double x, double y, double sizex,double sizey, Color c) {
			this.x = x;
			this.y = y;
			this.sizeX = sizex;
			this.sizeY = sizey;
			this.playerColor = c;
		}
		public void refresh() {
			
			draw.setPenColor(playerColor);
			draw.filledRectangle(x, y,sizeX, sizeY);
			draw.setPenColor(draw.RED);
			draw.filledRectangle(x-sizeX, y+sizeY, 5, 5);
			
		}
		public boolean checker(double Xpos, double Ypos) {
			if((Xpos>=this.x+this.sizeX || Xpos<= this.x-this.sizeX)
					||(Ypos>= this.y+this.sizeY || Ypos<= this.y-this.sizeY)) {
				return false;
			}
			return true;
		}
		public boolean Xchecker(double Xpos, double Ypos) {
			if((Xpos>=this.x-this.sizeX +5|| Xpos<= this.x-this.sizeX -5
					||(Ypos>= this.y+this.sizeY +5) || Ypos<= this.y+this.sizeY-5)) {
				return false;
			}
			return true;
		}
		public void reset(double Xpos, double Ypos) {
			this.x = Xpos;
			this.y = Ypos;
		}
		public void setX(double Xpos) {
			this.x = Xpos;
		}
		public void setY(double Ypos) {
			this.y = Ypos;
		}
		
	}
		

	public void addWindow(double x, double y, double sizex,double sizey, Color c) {
		Window w = new Window(x,y,sizex,sizey,c);
		win.add(w);
		this.x0 = x;
		this.y0 = y;
	}
	public void reset() {
		for(Window i : win) {
			i.reset(x0,y0);
		}
	}
	public void refresh() {
		draw.clear();
		for(Window i : win) {
			i.refresh();
		}
	}
	public Color randomColor() {
		Color playerColor = new Color((int)(Math.random()*255),
				(int)(Math.random()*255),(int)(Math.random()*255));
		return playerColor;
	}

	@Override
	public void keyPressed(int arg0) {
		
	}

	@Override
	public void keyReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(char arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Window w = new Window(draw.mouseX(), draw.mouseY(),Math.random() * 100,Math.random() * 100, randomColor()) ;
				if(arg0=='a') {
					win.add(w);
					refresh();
				} 
	}

	@Override
	public void mouseClicked(double x, double y) {
		// TODO Auto-generated method stub
		for(Window i : win) {
			if(i.Xchecker(x, y)) {
				win.remove(i);
				refresh();
				break;
			}
		}
			
	}

	@Override
	public void mouseDragged(double x, double y) {
		// TODO Auto-generated method stub
		inUse.setX(x);
		inUse.setY(y);
		refresh();
	}

	@Override
	public void mousePressed(double x, double y) {
		// TODO Auto-generated method stub
		for(Window i : win) {
			if(i.checker(x, y)) {
				inUse = i;
//				i.setX(x);
//				i.setY(y);
//				refresh();
			}
		}
	}

	@Override
	public void mouseReleased(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
