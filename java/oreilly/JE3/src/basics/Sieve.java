package basics;

import sun.font.TrueTypeFont;

public class Sieve {

    public static void main(String[] args) {
        int max = 100;
        try { max = Integer.parseInt(args[0]); }
        catch (Exception e) { }

        boolean[] isprime = new boolean[max + 1];

        for (int i = 0; i <= max; i ++) isprime[i] = true;

        isprime[0] = isprime[1] = false;

        int n = (int) Math.ceil(Math.sqrt(max));

        for (int i = 0; i <= n; i ++) {
            if (isprime[i])
                for (int j = 2*i; j <= max; j += i)
                    isprime[j] = false;
        }

        int largest;
        for (largest = max; !isprime[largest]; largest --) ;

        System.out.println("The largest prime less than or equal to " + max + " is " + largest);
    }

}
