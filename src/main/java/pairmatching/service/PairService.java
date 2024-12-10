package pairmatching.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;
import pairmatching.domain.Crews;
import pairmatching.domain.PairMaker;
import pairmatching.domain.Pairs;
import pairmatching.dto.PairsDto;
import pairmatching.util.Parser;

public class PairService {

    private final Map<Course, Crews> crews;
    private final PairMaker pairMaker;
    private List<Pairs> createdPairs;

    public PairService(final PairMaker pairMaker) {
        Map<Course, Crews> crews = new LinkedHashMap<>();

        List<String> frontendCrews = Reader.readFrontendCrew().stream()
                .map(String::new)
                .collect(Collectors.toList());
        crews.put(Course.FRONTEND, new Crews(frontendCrews));

        List<String> backendCrews = Reader.readBackendCrew().stream()
                .map(String::new)
                .collect(Collectors.toList());
        crews.put(Course.BACKEND, new Crews(backendCrews));

        this.crews = crews;
        this.pairMaker = pairMaker;
        this.createdPairs = new ArrayList<>();
    }

    public boolean checkPairExist(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);

        for (Pairs createdPair : createdPairs) {
            if (createdPair.isExistingPairs(course, level, mission)) {
                return true;
            }
        }
        return false;
    }

    public PairsDto pairMatching(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);

        Pairs matchedPairs = pairMaker.pairMatch(course, level, mission, crews.get(course), createdPairs);
        this.createdPairs.add(matchedPairs);
        return new PairsDto(matchedPairs.getPairs());
    }

    public PairsDto rematch(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);

        Pairs matchedPairs = pairMaker.pairMatch(course, level, mission, crews.get(course), createdPairs);
        // 바꿔치기
        for (Pairs createdPair : createdPairs) {
            if (createdPair.isExistingPairs(course, level, mission)) {
                createdPair.swapPairs(matchedPairs);
            }
        }

        return new PairsDto(matchedPairs.getPairs());
    }

    public PairsDto checkPair(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);

        for (Pairs createdPair : createdPairs) {
            if (createdPair.isExistingPairs(course, level, mission)) {
                return new PairsDto(createdPair.getPairs());
            }
        }

        throw new IllegalArgumentException(ErrorMessage.NO_PAIR_ERROR.getErrorMessage());
    }

    public void initializePairs() {
        this.createdPairs = new ArrayList<>();
    }
}
