public class problem7{
    public static void main(String[] args){
        double radiuskm = 6378;
        double radiusMiles = 6378 * 1.6;
        double volumeKm = (4/3) * Math.PI * Math.pow(radiuskm, 3);
        double volumeMiles = (4/3) * Math.PI * Math.pow(radiusMiles, 3);

        System.out.println("The volume of earth in cubic kilometers is " + volumeKm + " and cubic miles is " + volumeMiles);
    }
}