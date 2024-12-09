package pairmatching.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.PairMaker;
import pairmatching.domain.Pairs;
import pairmatching.dto.PairsDto;

public class PairService {

    private final Map<Course, Crews> crews;
    private final PairMaker pairMaker;
    private List<Pairs> createdPairs;

    public PairService(final PairMaker pairMaker) {
        Map<Course, Crews> crews = new LinkedHashMap<>();

        List<Crew> frontendCrews = Reader.readFrontendCrew().stream()
                .map(Crew::new)
                .collect(Collectors.toList());
        crews.put(Course.FRONTEND, new Crews(frontendCrews));

        List<Crew> backendCrews = Reader.readBackendCrew().stream()
                .map(Crew::new)
                .collect(Collectors.toList());
        crews.put(Course.BACKEND, new Crews(backendCrews));

        this.crews = crews;
        this.pairMaker = pairMaker;
        this.createdPairs = new ArrayList<>();
    }

    public PairsDto pairMatching(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);

        Pairs matchedPairs = pairMaker.pairMatch(course, level, mission, crews.get(course), createdPairs);
        return new PairsDto(matchedPairs.getPairs());
    }
}
