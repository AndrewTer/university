public class Generic250PairOfNumbers {
    public static void main(String[] args) {
        int count0to02and0to02 = 0, count0to02and02to04 = 0, count0to02and04to06 = 0, count0to02and06to08 = 0, count0to02and08to1 = 0;
        int count02to04and0to02 = 0, count02to04and02to04 = 0, count02to04and04to06 = 0, count02to04and06to08 = 0, count02to04and08to1 = 0;
        int count04to06and0to02 = 0, count04to06and02to04 = 0, count04to06and04to06 = 0, count04to06and06to08 = 0, count04to06and08to1 = 0;
        int count06to08and0to02 = 0, count06to08and02to04 = 0, count06to08and04to06 = 0, count06to08and06to08 = 0, count06to08and08to1 = 0;
        int count08to1and0to02 = 0, count08to1and02to04 = 0, count08to1and04to06 = 0, count08to1and06to08 = 0, count08to1and08to1 = 0;
        
        for (int i = 1; i <= 250; i++)
        {
            final double rnd1 = Math.random() * 1;
            final double rnd2 = Math.random() * 1;
            
            System.out.print(String.format("(%.5f , %.5f) ", rnd1, rnd2));
           
            if ((rnd1 > 0) && (rnd1 <= 0.2) && (rnd2 > 0) && (rnd2 <= 0.2))
                count0to02and0to02++;
            else if ((rnd1 > 0.) && (rnd1 <= 0.2) && (rnd2 > 0.2) && (rnd2 <= 0.4))
                count0to02and02to04++;
            else if ((rnd1 > 0) && (rnd1 <= 0.2) && (rnd2 > 0.4) && (rnd2 <= 0.6))
                count0to02and04to06++;
            else if ((rnd1 > 0) && (rnd1 <= 0.2) && (rnd2 > 0.6) && (rnd2 <= 0.8))
                count0to02and06to08++;
            else if ((rnd1 > 0) && (rnd1 <= 0.2) && (rnd2 > 0.8) && (rnd2 <= 1))
                count0to02and08to1++;
            else if ((rnd1 > 0.2) && (rnd1 <= 0.4) && (rnd2 > 0) && (rnd2 <= 0.2))
                count02to04and0to02++;
            else if ((rnd1 > 0.2) && (rnd1 <= 0.4) && (rnd2 > 0.2) && (rnd2 <= 0.4))
                count02to04and02to04++;
            else if ((rnd1 > 0.2) && (rnd1 <= 0.4) && (rnd2 > 0.4) && (rnd2 <= 0.6))
                count02to04and04to06++;
            else if ((rnd1 > 0.2) && (rnd1 <= 0.4) && (rnd2 > 0.6) && (rnd2 <= 0.8))
                count02to04and06to08++;
            else if ((rnd1 > 0.2) && (rnd1 <= 0.4) && (rnd2 > 0.8) && (rnd2 <= 1))
                count02to04and08to1++;
            else if ((rnd1 > 0.4) && (rnd1 <= 0.6) && (rnd2 > 0) && (rnd2 <= 0.2))
                count04to06and0to02++;
            else if ((rnd1 > 0.4) && (rnd1 <= 0.6) && (rnd2 > 0.2) && (rnd2 <= 0.4))
                count04to06and02to04++;
            else if ((rnd1 > 0.4) && (rnd1 <= 0.6) && (rnd2 > 0.4) && (rnd2 <= 0.6))
                count04to06and04to06++;
            else if ((rnd1 > 0.4) && (rnd1 <= 0.6) && (rnd2 > 0.6) && (rnd2 <= 0.8))
                count04to06and06to08++;
            else if ((rnd1 > 0.4) && (rnd1 <= 0.6) && (rnd2 > 0.8) && (rnd2 <= 1))
                count04to06and08to1++;
            else if ((rnd1 > 0.6) && (rnd1 <= 0.8) && (rnd2 > 0) && (rnd2 <= 0.2))
                count06to08and0to02++;
            else if ((rnd1 > 0.6) && (rnd1 <= 0.8) && (rnd2 > 0.2) && (rnd2 <= 0.4))
                count06to08and02to04++;
            else if ((rnd1 > 0.6) && (rnd1 <= 0.8) && (rnd2 > 0.4) && (rnd2 <= 0.6))
                count06to08and04to06++;
            else if ((rnd1 > 0.6) && (rnd1 <= 0.8) && (rnd2 > 0.6) && (rnd2 <= 0.8))
                count06to08and06to08++;
            else if ((rnd1 > 0.6) && (rnd1 <= 0.8) && (rnd2 > 0.8) && (rnd2 <= 1))
                count06to08and08to1++;
            else if ((rnd1 > 0.8) && (rnd1 <= 1) && (rnd2 > 0) && (rnd2 <= 0.2))
                count08to1and0to02++;
            else if ((rnd1 > 0.8) && (rnd1 <= 1) && (rnd2 > 0.2) && (rnd2 <= 0.4))
                count08to1and02to04++;
            else if ((rnd1 > 0.8) && (rnd1 <= 1) && (rnd2 > 0.4) && (rnd2 <= 0.6))
                count08to1and04to06++;
            else if ((rnd1 > 0.8) && (rnd1 <= 1) && (rnd2 > 0.6) && (rnd2 <= 0.8))
                count08to1and06to08++;
            else if ((rnd1 > 0.8) && (rnd1 <= 1) && (rnd2 > 0.8) && (rnd2 <= 1))
                count08to1and08to1++;
  
            if (i%5 == 0)
                System.out.print("\n");
        }
        
        System.out.println("\n            0-0.2       0.2-0.4       0.4-0.6       0.6-0.8       0.8-1");
        System.out.printf("0-0.2 %9d %12d %14d %12d %12d\n", count0to02and0to02, count0to02and02to04, count0to02and04to06, count0to02and06to08, count0to02and08to1);
        System.out.printf("0.2-0.4 %7d %12d %14d %12d %12d\n", count02to04and0to02, count02to04and02to04, count02to04and04to06, count02to04and06to08, count02to04and08to1);
        System.out.printf("0.4-0.6 %7d %12d %14d %12d %12d\n", count04to06and0to02, count04to06and02to04, count04to06and04to06, count04to06and06to08, count04to06and08to1);
        System.out.printf("0.6-0.8 %7d %12d %14d %12d %12d\n", count06to08and0to02, count06to08and02to04, count06to08and04to06, count06to08and06to08, count06to08and08to1);
        System.out.printf("0.8-1 %9d %12d %14d %12d %12d\n", count08to1and0to02, count08to1and02to04, count08to1and04to06, count08to1and06to08, count08to1and08to1);
    }
}
