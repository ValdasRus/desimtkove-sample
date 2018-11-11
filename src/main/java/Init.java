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
            System.out.println("Toks failas nerastas");
        }
    }

    public String getFileName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Suveskite failo pavadinima:");
        String name = scan.nextLine();
        System.out.println("suveskite pletini:");
        String extension =  scan.nextLine();
        return name + "." + extension;
    }
}
