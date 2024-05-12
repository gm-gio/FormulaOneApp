package com.meshveliani.giorgi.formuloneapp.service.impl;

import com.meshveliani.giorgi.formuloneapp.model.Race;
import com.meshveliani.giorgi.formuloneapp.model.Racer;
import com.meshveliani.giorgi.formuloneapp.service.AppService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Service implements AppService {
    @Override
    public List<Race> createRaceList(Map<String, Racer> raceInfoMap, Map<String, Race> raceStart,
                                     Map<String, Race> raceEnd) {
        List<Race> raceList = new ArrayList<>();

        for (String abbreviation : raceInfoMap.keySet()) {
            Racer racer = raceInfoMap.get(abbreviation);
            Race startRace = raceStart.getOrDefault(abbreviation, new Race(null, null, null));
            Race endRace = raceEnd.getOrDefault(abbreviation, new Race(null, null, null));

            LocalTime startTime = startRace.getStartTime();
            LocalTime endTime = endRace.getEndTime();

            Race race = new Race(startTime, endTime, racer);
            raceList.add(race);
        }

        return raceList;
    }
}
