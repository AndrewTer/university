public class Generic100RandElements {

    public static void main(String[] args) {
        int count0to01 = 0, count01to02 = 0, count02to03 = 0, count03to04 = 0, count04to05 = 0, count05to06 = 0, count06to07 = 0, count07to08 = 0, count08to09 = 0, count09to1 = 0;
        int[] arr = new int[100];
        for (int i = 1; i <= 100; i++)
        {
            final double rnd = Math.random() * 1;
            
            System.out.print(String.format("%(.5f ", rnd));
           
            if ((rnd > 0) && (rnd <= 0.1))
                count0to01++;
            else if ((rnd > 0.1) && (rnd <= 0.2))
                count01to02++;
            else if ((rnd > 0.2) && (rnd <= 0.3))
                count02to03++;
            else if ((rnd > 0.3) && (rnd <= 0.4))
                count03to04++;
            else if ((rnd > 0.4) && (rnd <= 0.5))
                count04to05++;
            else if ((rnd > 0.5) && (rnd <= 0.6))
                count05to06++;   
            else if ((rnd > 0.6) && (rnd <= 0.7))
                count06to07++;
            else if ((rnd > 0.7) && (rnd <= 0.8))
                count07to08++;    
            else if ((rnd > 0.8) && (rnd <= 0.9))
                count08to09++;
            else if ((rnd > 0.9) && (rnd <= 1))
                count09to1++;
            
            if (i%10 == 0)
                System.out.print("\n");
        }
        
        System.out.printf("\nCount 0 to 0.1: %d\nCount 0.1 to 0.2: %d\nCount 0.2 to 0.3: %d\n"
                + "Count 0.3 to 0.4: %d\nCount 0.4 to 0.5: %d\nCount 0.5 to 0.6: %d\n"
                + "Count 0.6 to 0.7: %d\nCount 0.7 to 0.8: %d\nCount 0.8 to 0.9: %d\n"
                + "Count 0.9 to 1: %d\n", count0to01, count01to02, count02to03, count03to04, count04to05, count05to06, count06to07, count07to08, count08to09, count09to1);
    }
}
