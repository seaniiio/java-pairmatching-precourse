package pairmatching.service;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;

public class PairService {

    public void pairMatching(String courseLevelMissionInput) {
        Course course = Parser.parseCourse(courseLevelMissionInput);
        Level level = Parser.parseLevel(courseLevelMissionInput);
        Mission mission = Parser.parseMission(courseLevelMissionInput);


    }
}
