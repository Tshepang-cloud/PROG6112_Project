package seriesmodel;

import java.util.*;
import seriesmodel.Series;

public class Main {
    public static void main(String[] args) {
        Series seriesApp = new Series();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- TV Series Management ---");
            System.out.println("1. Capture New Series");
            System.out.println("2. Search Series");
            System.out.println("3. Update Series");
            System.out.println("4. Delete Series");
            System.out.println("5. View Series Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> seriesApp.CaptureSeries();
                case 2 -> seriesApp.SearchSeries();
                case 3 -> seriesApp.UpdateSeries();
                case 4 -> seriesApp.DeleteSeries();
                case 5 -> seriesApp.SeriesReport();
                case 6 -> seriesApp.ExitSeriesApplication();
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
