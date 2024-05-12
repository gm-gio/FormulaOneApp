package com.meshveliani.giorgi.formuloneapp.formatter;

import com.meshveliani.giorgi.formuloneapp.model.Race;

import java.time.Duration;
import java.util.List;

public interface AppFormatter {
    String format(List<Race> raceList);

    Duration calculateRaceTime(Race race);

    String formatRace(Race race, int position);

    String formatDuration(Duration duration);
}
