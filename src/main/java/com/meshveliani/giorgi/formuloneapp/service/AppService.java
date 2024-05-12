package com.meshveliani.giorgi.formuloneapp.service;

import com.meshveliani.giorgi.formuloneapp.model.Race;
import com.meshveliani.giorgi.formuloneapp.model.Racer;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public interface AppService {
    List<Race> createRaceList(Map<String, Racer> raceInfoMap, Map<String, Race> raceStart,
                              Map<String, Race> raceEnd);
}
