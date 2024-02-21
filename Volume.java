import java.util.*;


public class Volume {
    
    // these values are final because they are not input from the command line
    static final int pyramidHeight = 9;
    static final int pyrBaseLength = 10;

    static Volume obj = new Volume();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double volCylinder = 0.0;
        double volCone = 0.0;

        volPyramid(pyramidHeight, pyrBaseLength);

        System.out.println("What is height and radius of cylinder and cube?");
        int height = scanner.nextInt();
        int radius = scanner.nextInt();

        /*
         * Since the volCylinder module is non-static, we must
         * create an instance of the class and use it to call the method
         */
        volCylinder = obj.volCylinder(height,radius);
        System.out.println("Cylinder volume with height = " + (double)height + " and radius = " + (double)radius + " is: " + String.format("%.2f", volCylinder));


        volCone = volCone(height, radius);
        System.out.println("Cone volume with height = " + (double)height + " and radius = " + (double)radius + " is: " + String.format("%.2f", volCone));

        scanner.close();
    }

    /*
     * This method calculates the volume of a pyramid
     * given the height and base length
     */
    static void volPyramid(int height, int baseLength) {

        // Calucate the volume of a pyramid
        double volume = (1.0/3.0) * height * (baseLength*baseLength);

        System.out.println("Pyramid volume with height = " + pyramidHeight + " and base length = " + pyrBaseLength + " is: " + volume);
    }

    /*
     * This method calculates the volume of a cylinder
     * given the height and radiius
     */
    public double volCylinder(int height, int radius) {
        
        double volume = 0.0;
        double radiusTimesHeight = redundantCalc(height, radius);

        volume = Math.PI * radiusTimesHeight;

        return volume;
    }

    /*
     * This method calculates the volume of a cone
     * given the height and radiius
     */
    public static double volCone(int height, int radius) {
        
        double volume = 0.0;
        double radiusTimesHeight = obj.redundantCalc(height, radius);

        volume = (1.0/3.0) * Math.PI * radiusTimesHeight;

        return volume;
    }

    double redundantCalc (int height, int radius) {

        double result = (radius*radius) * height;

        return result;
    }
}
