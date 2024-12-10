package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.util.Reader;

public class CrewRepository {
    private static final Map<Course, List<Crew>> crews = new LinkedHashMap<>();
    private static final CrewRepository instance = new CrewRepository();

    public static void initializeCrew() {
        List<Crew> frontendCrews = Reader.readFrontendCrew().stream()
                .map(Crew::new)
                .collect(Collectors.toList());
        crews.put(Course.FRONTEND, frontendCrews);

        List<Crew> backendCrews = Reader.readBackendCrew().stream()
                .map(Crew::new)
                .collect(Collectors.toList());
        crews.put(Course.BACKEND, backendCrews);
    }

    public static CrewRepository getInstance() {
        return instance;
    }

    public List<Crew> findCrewsByCourse(Course course) {
        return crews.get(course);
    }

    public void shuffle(Course course) {
        List<Crew> shuffledCrews = Randoms.shuffle(crews.get(course));
        crews.replace(course, shuffledCrews);
    }

    public List<Crew> matchCrew(int startIndex, int endIndex, Course course) {
        return new ArrayList<>(crews.get(course).subList(startIndex, endIndex));
    }
}
