import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
 
/**
 *
 * @author terehin.andrey
 */

public class Koch extends Canvas 
{
    int iteration_count = 0;
    int selected_color = 0;
    
    Koch(int selectediter, int selecteditem ) 
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
        drawKoch(g,iteration_count,150,410,410,410);   
        drawKoch(g,iteration_count,410,410,280,150);   
        drawKoch(g,iteration_count,280,150,150,410);    
    }
  
    private void drawKoch (Graphics g, int lev, int x1, int y1, int x5, int y5)
    {
          int deltaX, deltaY, x2, y2, x3, y3, x4, y4;
 
          if (lev == 0)
          {
 
              g.drawLine(x1, y1, x5, y5);
          }
          else{
                deltaX = x5 - x1;
                deltaY = y5 - y1;
 
                x2 = x1 + deltaX / 3;
                y2 = y1 + deltaY / 3;
 
                x3 = (int) (0.5 * (x1+x5) + Math.sqrt(3) * (y1-y5)/6);
                y3 = (int) (0.5 * (y1+y5) + Math.sqrt(3) * (x5-x1)/6);
 
                x4 = x1 + 2 * deltaX /3;
                y4 = y1 + 2 * deltaY /3;
 
                drawKoch (g,lev-1, x1, y1, x2, y2);
                drawKoch (g,lev-1, x2, y2, x3, y3);
                drawKoch (g,lev-1, x3, y3, x4, y4);
                drawKoch (g,lev-1, x4, y4, x5, y5);
            }
    }
}