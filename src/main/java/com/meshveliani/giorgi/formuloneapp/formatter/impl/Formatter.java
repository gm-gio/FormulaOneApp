package com.meshveliani.giorgi.formuloneapp.formatter.impl;

import com.meshveliani.giorgi.formuloneapp.formatter.AppFormatter;
import com.meshveliani.giorgi.formuloneapp.model.Race;
import com.meshveliani.giorgi.formuloneapp.model.Racer;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Formatter implements AppFormatter {

    private static final String RACE_FORMAT_PRINT = "%d. %s | %s | %s";
    private static final String TIME_DURATION_FORMATTER = "%02d:%02d:%02d.%03d";
    private static final String NEW_LINE = "\n";

    @Override
    public String format(List<Race> raceList) {
        if (raceList.isEmpty()) {
            return "No races to format";
        }

        List<Race> sortedRaceList = raceList.stream()
                .sorted(Comparator.comparing(this::calculateRaceTime)).toList();

        return IntStream.range(0, sortedRaceList.size())
                .mapToObj(index -> formatRace(sortedRaceList.get(index), index + 1)).collect(Collectors.joining(NEW_LINE));
    }

    @Override
    public Duration calculateRaceTime(Race race) {
        return Duration.between(race.getStartTime(), race.getEndTime());
    }

    @Override
    public String formatRace(Race race, int position) {
        Racer racer = race.getRacer();
        Duration raceTime = calculateRaceTime(race);

        return String.format(RACE_FORMAT_PRINT, position, racer.getFullName(), racer.getTeamName(),
                formatDuration(raceTime));
    }

    @Override
    public String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        long millis = duration.toMillisPart();

        return String.format(TIME_DURATION_FORMATTER, hours, minutes, seconds, millis);
    }
}
