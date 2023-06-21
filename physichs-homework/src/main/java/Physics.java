/*
Created by Akın Tatar
- Project name :physics-homework
- Date :21.06.2023
- School ID :                       (optional)
 */
import java.lang.Math;
public class Physics {
    public static void main(String[] args) {
            /*
           (60) Programming*: Write code to compute these values for each question.
           Attach (or copy-paste) your code and the results to your homework file.
            Point P is located X distance away from the center point
            of a rod of length 2L and total charge of Q.
            Take X=1m, Q=1 nanoC, 2L=2m (L=1m).
             */

        double x = 1.0; // Distance from the center point in meters
        double q = 1e-9; // Total charge in Coulombs (1 nanoCoulomb)
        double l = 1.0; // Half-length of the rod in meters (2L=2m, L=1m)

        double v0 = computePotentialOfRod(x, q, l);
        System.out.println("Potential at point P (Vo): " + v0 + " V");

        double v1 = computePotentialOfSingleCharge(l,q);
        System.out.println("Potential at point P (V1): "+ v1 + " V");

        double v2 = computePotentialForNTimes(2,q,l,x);
        System.out.println("Potential at point P (V2): "+v2+" V");

        double v4 = computePotentialForNTimes(4,q,l,x);
        System.out.println("Potential at point P (V3): "+v4+" V");

        double v6 = computePotentialForNTimes(6,q,l,x);
        System.out.println("Potential at point P (V6): "+v6+" V");

        double v8 = computePotentialForNTimes(8,q,l,x);
        System.out.println("Potential at point P (V8): "+v8+" V");

        double v1100 = computePotentialForNTimes(1100,q,l,x);
        System.out.println("Potential at point P (V1100): "+v1100+" V");

        double v100000 = computePotentialForNTimes(100000,q,l,x);
        System.out.println("Potential at point P (V100000): "+v100000+" V");
    }
    public static double computePotentialOfRod(double x, double q, double l) {
        double lambda = q/2*l; //charge density = Q / 2a
        double k = 8.988e9; // k constant of the formula k= 8.988 * 10^9
        double middleValue = Math.log(
                (Math.sqrt(Math.pow(l, 2) + Math.pow(x, 2)) + l)
                        / (Math.sqrt(Math.pow(l, 2) + Math.pow(x, 2)) - l));
        //the formula above is the natural logarithm part of the formula

        //formula for the proper rod

        return k*lambda*middleValue;
    }
    public static double computePotentialOfSingleCharge(double l , double q) {
        double k =8.988e9;
        return k*q/l;
    }
    public static double computePotentialForNTimes(double N , double q , double l , double x){
                                            //q = charge        l = distance between edge charge and middle point
                                                        // x = middle point and point p distance
        double k = 8.988e9; // Coulomb's constant in Nm^2/C^2
        double potential = 0.0;
        double distance = 0;
        for (int i = 0; i < N/2; i++) {
            distance = calculateHypotenuse(x,l-(i*2*l/(N-1)));
            double contribution = k * ( (q/N )/ distance);
            potential += contribution;
        }
        double result = 2*potential;
        if(N % 2 ==1){
            result+= k*(q/N)/x;
        }

        // Round the result to 2 decimal places
        return result;
    }
    public static double calculateHypotenuse(double x,double l){
        double hypo = Math.sqrt(Math.pow(x,2)+Math.pow(l,2));
        return hypo;
    }

}
