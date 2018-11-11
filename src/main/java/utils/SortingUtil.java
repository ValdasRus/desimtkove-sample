package utils;

import model.AthleteModel;

import java.util.Comparator;

public class SortingUtil implements Comparator<AthleteModel> {

    @Override
    public int compare(AthleteModel o1, AthleteModel o2) {
        return (String.valueOf(o2.getTotalPoints()).compareTo(String.valueOf(o1.getTotalPoints())));
    }
}