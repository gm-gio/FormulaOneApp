package com.meshveliani.giorgi.formuloneapp.parser;

import com.meshveliani.giorgi.formuloneapp.model.Race;
import com.meshveliani.giorgi.formuloneapp.model.Racer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceParser implements AppRaceParser {

    private static final String TIME_FORMAT = "HH:mm:ss.SSS";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

    @Override
    public Map<String, Racer> parseRaceInfo(List<String> lines) {
        return lines.stream()
                .map(line -> line.split("_"))
                .filter(parts -> parts.length == 3)
                .collect(Collectors.toMap(parts -> parts[0], parts -> new Racer(parts[1], parts[2])));
    }

    @Override
    public Map<String, Race> parseRaceStart(List<String> timeStart) {
        return parseRaceTime(timeStart, true);
    }

    @Override
    public Map<String, Race> parseRaceEnd(List<String> timeEnd) {
        return parseRaceTime(timeEnd, false);
    }

    @Override
    public Map<String, Race> parseRaceTime(List<String> times, boolean isStartTime) {
        return times.stream()
                .collect(Collectors.toMap(
                        time -> time.substring(0, 3),
                        time -> {
                            String raceTimeString = time.substring(14);
                            try {
                                LocalTime localTime = LocalTime.parse(raceTimeString, FORMATTER);
                                return isStartTime ? new Race(localTime, null, null) : new Race(null, localTime, null);
                            } catch (Exception e) {
                                System.err.println("Time parsing error: Invalid time format -  " + e.getMessage());
                                return null;
                            }
                        }));
    }
}
