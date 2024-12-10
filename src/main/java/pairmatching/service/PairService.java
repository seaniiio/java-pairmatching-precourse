package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pairs;
import pairmatching.dto.PairsDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;
import pairmatching.util.Parser;

public class PairService {

    private static final CrewRepository crewRepository = CrewRepository.getInstance();
    private static final PairRepository pairRepository = PairRepository.getInstance();

    public void initializeCrew() {
        CrewRepository.initializeCrew();
    }

    public boolean checkPairExist(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);

        return pairRepository.checkPairExist(course, level, mission);
    }

    public PairsDto pairMatching(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);

        return new PairsDto(pairRepository.pairMatch(course, level, mission, crewRepository.findCrewsByCourse(course)));
    }

    public PairsDto rematch(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);

        Pairs rematchedPairs = pairRepository.rematch(course, level, mission, crewRepository.findCrewsByCourse(course));
        return new PairsDto(rematchedPairs);
    }

    public PairsDto checkPair(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);

        return new PairsDto(pairRepository.find(course, level, mission));
    }

    public void initializePairs() {
        pairRepository.initializePairs();
    }
}
