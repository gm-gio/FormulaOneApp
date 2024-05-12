package com.meshveliani.giorgi.formuloneapp.parser;

import com.meshveliani.giorgi.formuloneapp.model.Race;
import com.meshveliani.giorgi.formuloneapp.model.Racer;

import java.util.List;
import java.util.Map;

public interface AppRaceParser {
    Map<String, Racer> parseRaceInfo(List<String> lines);

    Map<String, Race> parseRaceStart(List<String> timeStart);

    Map<String, Race> parseRaceEnd(List<String> timeEnd);

    Map<String, Race> parseRaceTime(List<String> times, boolean isStartTime);
}
