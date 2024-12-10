package pairmatching.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.util.Reader;

public class CrewRepository {
    private static final Map<Course, Crews> crews = new LinkedHashMap<>();
    private static final CrewRepository instance = new CrewRepository();

    public static void initializeCrew() {
        List<String> frontendCrews = Reader.readFrontendCrew().stream()
                .map(String::new)
                .collect(Collectors.toList());
        crews.put(Course.FRONTEND, new Crews(frontendCrews));

        List<String> backendCrews = Reader.readBackendCrew().stream()
                .map(String::new)
                .collect(Collectors.toList());
        crews.put(Course.BACKEND, new Crews(backendCrews));
    }

    public static CrewRepository getInstance() {
        return instance;
    }

    public Crews findCrewsByCourse(Course course) {
        return crews.get(course);
    }
}
