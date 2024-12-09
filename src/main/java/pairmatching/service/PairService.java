package pairmatching.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;

public class PairService {

    private final Map<Course, Crews> crews;

    public PairService() {
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
    }

    public void pairMatching(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);


    }
}
