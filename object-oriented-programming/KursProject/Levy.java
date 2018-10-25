import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author terehin.andrey
 */

public class Levy extends Canvas 
{
    int iteration_count = 0;
    int selected_color = 0;
    
    Levy(int selectediter, int selecteditem ) 
    {
        iteration_count = selectediter;
        selected_color = selecteditem;
    }
    
    @Override
    public void paint(Graphics g) 
    {
        setBackground(Color.black);
        
        switch(selected_color){
            case 0:
                g.setColor(Color.red);
                break;
            case 1:
                g.setColor(Color.blue);
                break;
            case 2:
                g.setColor(Color.green);
                break;
            case 3:
                g.setColor(Color.yellow);
                break;
            case 4:
                g.setColor(Color.white);
                break;
            default:
                g.setColor(Color.blue);
                break;
        }
        drawLevy(150, 350, 450, 350, iteration_count, g);
    }
    private void drawLevy(int x1, int y1, int x2, int y2, int n, Graphics g ) 
    {
        if (n == 0) g.drawLine(x1, y1, x2, y2);
        else {
            int xx = (x1 + x2) / 2 + (y2 - y1) / 2;//Находим точки для дальнейшего разбиения и поворота(точки излома)
            int yy = (y1 + y2) / 2 - (x2 - x1) / 2;
            drawLevy(x1, y1, xx, yy, n - 1, g);
            drawLevy(xx, yy, x2, y2, n - 1, g);
        }
    }
}
