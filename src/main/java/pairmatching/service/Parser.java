package pairmatching.service;

import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;

public class Parser {

    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    public static Course parseCourse(String courseLevelMissionInput) {
        String course = parse(courseLevelMissionInput, COURSE_INDEX);
        return Course.find(course);
    }

    public static Level parseLevel(String courseLevelMissionInput) {
        String level = parse(courseLevelMissionInput, LEVEL_INDEX);
        return Level.find(level);
    }

    public static Mission parseMission(String courseLevelMissionInput) {
        String mission = parse(courseLevelMissionInput, MISSION_INDEX);
        return Mission.find(mission);
    }

    private static String parse(String courseLevelMissionInput, int index) {
        try {
            String[] input = courseLevelMissionInput.split(",");
            return input[index].trim();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_ERROR.getErrorMessage());
        }
    }
}
