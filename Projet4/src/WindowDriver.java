import edu.du.dudraw.Draw;

public class WindowDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WindowDisplay display = new WindowDisplay(300,300);
	
		display.addWindow(50, 50, 60, 80, Draw.BLUE);
		display.addWindow(100, 130, 80, 80, Draw.RED);
		display.addWindow(80, 80, 60, 80, Draw.GREEN);
		display.addWindow(120, 60, 100, 80, Draw.BLACK);
		display.refresh();
	}

}
