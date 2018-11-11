import utils.PointsCalculation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Init {
    public void initialize() {
        try {
            Scanner scanner = new Scanner(new File(getFileName()));
            PointsCalculation pointsCalculation = new PointsCalculation();
            List<String[]> a = new ArrayList<>();
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] values = data.split(";");
                a.add(values);
            }
            pointsCalculation.athleteCalc(a);
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
    }

    public String getFileName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file name without extension:");
        String name = scan.nextLine();
        System.out.println("Enter file extension:");
        String extension =  scan.nextLine();
        return name + "." + extension;
    }
}
