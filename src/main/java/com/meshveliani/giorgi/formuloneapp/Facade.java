package com.meshveliani.giorgi.formuloneapp;


import com.meshveliani.giorgi.formuloneapp.formatter.impl.Formatter;

import com.meshveliani.giorgi.formuloneapp.model.Race;
import com.meshveliani.giorgi.formuloneapp.model.Racer;
import com.meshveliani.giorgi.formuloneapp.parser.RaceParser;
import com.meshveliani.giorgi.formuloneapp.reader.impl.Reader;
import com.meshveliani.giorgi.formuloneapp.service.impl.Service;

import java.io.IOException;

import java.util.List;
import java.util.Map;

public class Facade {
    public List<String> processFormulaOneData(String racersFile, String startFile, String endFile) throws IOException {
        Reader reader = new Reader();
        Formatter formatter = new Formatter();
        Service service = new Service();
        RaceParser raceParser = new RaceParser();

        List<String> raceInfo = reader.readFile(racersFile);
        List<String> startTimes = reader.readFile(startFile);
        List<String> endTimes = reader.readFile(endFile);

        Map<String, Racer> raceInfoMap = raceParser.parseRaceInfo(raceInfo);
        Map<String, Race> raceStart = raceParser.parseRaceStart(startTimes);
        Map<String, Race> raceEnd = raceParser.parseRaceEnd(endTimes);

        List<Race> raceList = service.createRaceList(raceInfoMap, raceStart, raceEnd);

        String formattedResult = formatter.format(raceList);

        return List.of(formattedResult);
    }
}
