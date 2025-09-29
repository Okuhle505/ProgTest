package progtest;

/**
 *
 * @author RC_Student_lab
 */
public class PROGTest {

    public static void main(String[] args) {
        // Stadium names
        String[] stadiums = {"Kingsmead", "St Georges", "Wanderers"};

        // Batsmen names
        String[] batsmen = {"Jacques Kallis", "Hashim Amla", "AB de Villiers"};

        // Runs scored [rows = stadiums, cols = batsmen]
        int[][] runs = {
            {5000, 3800, 4200},  // Kingsmead
            {3500, 3700, 3900},  // St Georges
            {6200, 5000, 5200}   // Wanderers
        };

        // Calculate total runs by each batsman
        int[] totalByBatsman = new int[batsmen.length];
        for (int col = 0; col < batsmen.length; col++) {
            int sum = 0;
            for (int row = 0; row < stadiums.length; row++) {
                sum += runs[row][col];
            }
            totalByBatsman[col] = sum;
        }

        // Calculate total runs by each stadium
        int[] totalByStadium = new int[stadiums.length];
        for (int row = 0; row < stadiums.length; row++) {
            int sum = 0;
            for (int col = 0; col < batsmen.length; col++) {
                sum += runs[row][col];
            }
            totalByStadium[row] = sum;
        }

        // Display report
        System.out.println("=== Total Runs Per Batsman ===");
        for (int i = 0; i < batsmen.length; i++) {
            System.out.println(batsmen[i] + ": " + totalByBatsman[i]);
        }

        System.out.println("\n=== Total Runs Per Stadium ===");
        for (int i = 0; i < stadiums.length; i++) {
            System.out.println(stadiums[i] + ": " + totalByStadium[i]);
        }

        // Find highest runs per stadium
        System.out.println("\n=== Highest Runs Scored Per Stadium ===");
        for (int i = 0; i < stadiums.length; i++) {
            int maxRuns = runs[i][0];
            String bestBatsman = batsmen[0];
            for (int j = 1; j < batsmen.length; j++) {
                if (runs[i][j] > maxRuns) {
                    maxRuns = runs[i][j];
                    bestBatsman = batsmen[j];
                }
            }
            System.out.println(stadiums[i] + ": " + bestBatsman + " (" + maxRuns + ")");
        }

        // Find stadium with most total runs
        int maxStadiumRuns = totalByStadium[0];
        String bestStadium = stadiums[0];
        for (int i = 1; i < stadiums.length; i++) {
            if (totalByStadium[i] > maxStadiumRuns) {
                maxStadiumRuns = totalByStadium[i];
                bestStadium = stadiums[i];
            }
        }
        System.out.println("\nStadium with Most Runs: " + bestStadium + " (" + maxStadiumRuns + ")");
    }
}
