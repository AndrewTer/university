import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

/**
 *
 * @author terehin.andrey
 */

public class Dragon extends Canvas
{
    int iteration_count = 0;
    int selected_color = 0;
    
    Dragon(int selectediter, int selectedIndex) 
    {
        iteration_count = selectediter;
        selected_color = selectedIndex;
    }

    @Override
    public void paint(Graphics g)
    {
        setBackground(Color.black);
        
        switch(selected_color)
        {
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
            default:
                g.setColor(Color.blue);
                break;
        }
        drawDragon(180, 200, 400, 450, iteration_count, g);
    }

    private void drawDragon(int x1, int y1, int x2, int y2, int n, Graphics g)
    {
        int xx, yy;
        if(n > 0)
        {
            xx = (x1 + x2) / 2 + (y2 - y1) / 2;
            yy = (y1 + y2) / 2 - (x2 - x1) / 2 ;
            drawDragon(x2, y2, xx, yy, n - 1, g);
            drawDragon(x1, y1, xx, yy, n - 1, g);
        }
        if(n == 0)
            g.drawLine(x1, y1, x2, y2);
    }
}
