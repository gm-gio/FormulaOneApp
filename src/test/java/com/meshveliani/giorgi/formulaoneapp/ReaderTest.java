package com.meshveliani.giorgi.formulaoneapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.meshveliani.giorgi.formuloneapp.formatter.impl.Formatter;
import com.meshveliani.giorgi.formuloneapp.model.Race;
import com.meshveliani.giorgi.formuloneapp.model.Racer;
import com.meshveliani.giorgi.formuloneapp.parser.RaceParser;
import com.meshveliani.giorgi.formuloneapp.reader.impl.Reader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReaderTest {

    @Test
    void fileReaderMethod() throws IOException {

        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        when(bufferedReaderMock.readLine()).thenReturn("Line 1", "Line 2", "Line 3", null);

        Reader formulaOneReader = new Reader(bufferedReaderMock);

        List<String> result = formulaOneReader.readFile("dummyFilePath");

        assertEquals(Arrays.asList("Line 1", "Line 2", "Line 3"), result);
    }

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }



    @Test
    void schouldInputFormatterMethodTs() {

        Racer racer1 = new Racer("Sebastian Vettel", "FERRARI ");
        Racer racer2 = new Racer("Daniel Ricciardo", "Daniel Ricciardo");

        Race race1 = new Race(LocalTime.of(12, 0), LocalTime.of(12, 1, 30), racer1);
        Race race2 = new Race(LocalTime.of(12, 0), LocalTime.of(12, 1, 35), racer2);

        List<Race> raceList = Arrays.asList(race1, race2);

        Formatter formulaAppFormatter = new Formatter();

        String actualOutput = formulaAppFormatter.format(raceList);
        System.out.println(actualOutput);

        String expectedOutput = "1. Sebastian Vettel | FERRARI  | 00:01:30.000\n"
                + "2. Daniel Ricciardo | Daniel Ricciardo | 00:01:35.000";

        assertEquals(expectedOutput, actualOutput.trim());

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @BeforeEach
    public void setUpPars() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }



    @Test
    void shouldParse() {
        ;
        List<String> lines = Arrays.asList("1_Sebastian Vettel_FERRARI", "2_Daniel Ricciardo_Daniel Ricciardo",
                "3_Lewis Hamilton_MERCEDES");

        RaceParser parser = new RaceParser();

        Map<String, Racer> result = parser.parseRaceInfo(lines);

        Map<String, Racer> expectedOutput = new HashMap<>();
        expectedOutput.put("1", new Racer("Sebastian Vettel", "FERRARI"));
        expectedOutput.put("2", new Racer("Daniel Ricciardo", "Daniel Ricciardo"));
        expectedOutput.put("3", new Racer("Lewis Hamilton", "MERCEDES"));

        assertEquals(expectedOutput, result);

    }

    @AfterEach
    public void tearDownPars() {
        System.setOut(standardOut);
    }

}

