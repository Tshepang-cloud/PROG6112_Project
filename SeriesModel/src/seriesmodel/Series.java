package seriesmodel;

import java.util.*;
import seriesmodel.SeriesModel;

public class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void CaptureSeries() {
        SeriesModel s = new SeriesModel();
        
        System.out.print("Enter Series ID: ");
        s.SeriesId = sc.nextLine();
        
        System.out.print("Enter Series Name: ");
        s.SeriesName = sc.nextLine();
        
        // Validate Age
        while (true) {
            try {
                System.out.print("Enter Age Restriction (2-18): ");
                s.SeriesAge = Integer.parseInt(sc.nextLine());
                if (s.SeriesAge >= 2 && s.SeriesAge <= 18) break;
                else System.out.println("Invalid age. Must be between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        
        System.out.print("Enter Number of Episodes: ");
        s.SeriesNumberOfEpisodes = Integer.parseInt(sc.nextLine());
        
        seriesList.add(s);
        System.out.println("✅ Series successfully saved!");
    }

    public void SearchSeries() {
        System.out.print("Enter Series ID to search: ");
        String id = sc.nextLine();
        
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                System.out.println("Series Found: " + s.SeriesName + " | Age: " + s.SeriesAge + " | Episodes: " + s.SeriesNumberOfEpisodes);
                return;
            }
        }
        System.out.println("❌ No series data could be found.");
    }

    public void UpdateSeries() {
        System.out.print("Enter Series ID to update: ");
        String id = sc.nextLine();
        
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                System.out.print("Enter New Series Name: ");
                s.SeriesName = sc.nextLine();
                
                System.out.print("Enter New Age Restriction (2-18): ");
                s.SeriesAge = Integer.parseInt(sc.nextLine());
                
                System.out.print("Enter New Number of Episodes: ");
                s.SeriesNumberOfEpisodes = Integer.parseInt(sc.nextLine());
                
                System.out.println("✅ Series updated!");
                return;
            }
        }
        System.out.println("❌ Series not found.");
    }

    public void DeleteSeries() {
        System.out.print("Enter Series ID to delete: ");
        String id = sc.nextLine();
        
        Iterator<SeriesModel> it = seriesList.iterator();
        while (it.hasNext()) {
            SeriesModel s = it.next();
            if (s.SeriesId.equalsIgnoreCase(id)) {
                System.out.print("Are you sure you want to delete this series? (Y/N): ");
                String confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    it.remove();
                    System.out.println("✅ Series deleted!");
                }
                return;
            }
        }
        System.out.println("❌ Series not found.");
    }

    public void SeriesReport() {
        System.out.println("📺 Series Report:");
        for (SeriesModel s : seriesList) {
            System.out.println(s.SeriesId + " | " + s.SeriesName + " | Age: " + s.SeriesAge + " | Episodes: " + s.SeriesNumberOfEpisodes);
        }
    }

    public void ExitSeriesApplication() {
        System.out.println("👋 Exiting application. Goodbye!");
        System.exit(0);
    }
}
