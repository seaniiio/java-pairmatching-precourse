package pairmatching.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;

public class MissionsDto {

    private final Map<Level, List<Mission>> missions;

    public MissionsDto() {
        Map<Level, List<Mission>> missions = new LinkedHashMap<>();
        for (Level level : Level.values()) {
            missions.put(level, new ArrayList<>());
        }
        this.missions = missions;
    }

    public void addMission(Mission mission) {
        this.missions.get(mission.getLevel()).add(mission);
    }

    public List<String> getMissions(Level level) {
        List<Mission> missionsOfLevel = this.missions.get(level);
        return missionsOfLevel.stream()
                .map(Mission::name)
                .collect(Collectors.toList());
    }
}
