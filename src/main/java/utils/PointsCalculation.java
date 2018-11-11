package utils;

import model.AthleteModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsCalculation {
    static int maxPoints= 10000;
    static int position = 1;
    static int count = 0;
    private List<AthleteModel> athleteList;

    public void athleteCalc(List<String[]> data) {
        setAndSortAthleteValues(data);
        positionAthlete();
        doConvert();
    }

    public void doConvert() {
        ToXmlConverter c = new ToXmlConverter();
        c.convert(getAthleteList());
    }

    public void positionAthlete() {
        getAthleteList().get(0).setPosition(String.valueOf(position));
        for (int i = 1; i < getAthleteList().size(); i++) {
            if (getAthleteList().get(i).getTotalPoints() != getAthleteList().get(i-1).getTotalPoints()) {
                position++;
                getAthleteList().get(i).setPosition(String.valueOf(position));
                count=0;
            } else {
                getAthleteList().get(i-1).setPosition(String.valueOf(position-count));
                getAthleteList().get(i).setPosition(String.valueOf(position-count));
                position++;
                count++;
            }
        }
        addPositionRange();
    }

    public void addPositionRange() {
        for (AthleteModel a : getAthleteList()) {
            int endPoint = Integer.parseInt(a.getPosition()) + (getMap().get(a.getTotalPoints())-1);
            if (getMap().get(a.getTotalPoints()) != 1) {
                a.setNewPosition(a.getPosition() + " - " + endPoint);
            } else {
                a.setNewPosition(a.getPosition());
            }
        }
    }

    public Map<Integer, Integer> getMap() {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (AthleteModel item: getAthleteList()) {

            if (countMap.containsKey(item.getTotalPoints()))
                countMap.put(item.getTotalPoints(), countMap.get(item.getTotalPoints()) + 1);
            else
                countMap.put(item.getTotalPoints(), 1);
        }
        return countMap;
    }

    public void setAndSortAthleteValues(List<String[]> data) {
        List<AthleteModel> athleteList = new ArrayList<>();

        for (String[] masyvas : data) {
            AthleteModel athlete = new AthleteModel();

            athlete.setName(masyvas[0]);
            athlete.setRunning100m(masyvas[1]);
            athlete.setRunning100mInput(Double.parseDouble(masyvas[1]));
            athlete.setLongJump(masyvas[2]);
            athlete.setLongJumpInput(Double.parseDouble(masyvas[2]));
            athlete.setShortPut(masyvas[3]);
            athlete.setShortPutInput(Double.parseDouble(masyvas[3]));
            athlete.setHighJump(masyvas[4]);
            athlete.setHighJumpInput(Double.parseDouble(masyvas[4]));
            athlete.setRunning400m(masyvas[5]);
            athlete.setRunning400mInput(Double.parseDouble(masyvas[5]));
            athlete.setHurdles(masyvas[6]);
            athlete.setHurdlesInput(Double.parseDouble(masyvas[6]));
            athlete.setDiscusThrow(masyvas[7]);
            athlete.setDiscusThrowInput(Double.parseDouble(masyvas[7]));
            athlete.setPoleVault(masyvas[8]);
            athlete.setPoleVaultInput(Double.parseDouble(masyvas[8]));
            athlete.setJavelinThrow(masyvas[9]);
            athlete.setJavelinThrowInput(Double.parseDouble(masyvas[9]));

            String running1500m = masyvas[10];
            String[] time = running1500m.split("\\.");
            double minutes = Double.parseDouble(time[0]);
            double seconds = Double.parseDouble(time[1]);
            double milliseconds = Double.parseDouble(time[2]);
            double timeInSeconds = minutes * 60 + seconds + milliseconds / 100;
            athlete.setRunning1500m(timeInSeconds);
            athlete.setRunning1500mInput(timeInSeconds);

            if (athlete.getTotalPoints() <= maxPoints) {
                athleteList.add(athlete);
            } else {
                System.out.println("Klaidingi failo duomenys");
            }

            athleteList.sort(new SortingUtil());
            setAthleteList(athleteList);
        }
    }

    public List<AthleteModel> getAthleteList() {
        return athleteList;
    }

    public void setAthleteList(List<AthleteModel> athleteList) {
        this.athleteList = athleteList;
    }
}
