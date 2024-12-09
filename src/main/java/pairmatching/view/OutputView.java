package pairmatching.view;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;
import pairmatching.dto.PairsDto;

public class OutputView {

    public void printCourseLevelMission() {
        System.out.println("#############################################");
        printCourse();
        printMissions();

        System.out.println("#############################################");

    }

    private void printCourse() {
        String courseOutput = "";
        for (Course course : Course.values()) {
            courseOutput += (course.getName() + " | ");
        }
        courseOutput = courseOutput.substring(0, courseOutput.length() - 3);
        System.out.println("과정: " + courseOutput);
    }

    private void printMissions() {
        System.out.println("미션:");
        for (Level level : Level.values()) {
            printMissionByLevel(level);
        }
    }

    private void printMissionByLevel(Level level) {
        String missionOutput = "  - " + level.getName() + ": ";
        boolean isExist = false;
        for (Mission mission : Mission.values()) {
            if (mission.getLevel().equals(level)) {
                missionOutput += (mission.getName() + " | ");
                isExist = true;
            }
        }

        if (isExist) {
            missionOutput = missionOutput.substring(0, missionOutput.length() - 3);
        }
        System.out.println(missionOutput);
    }

    public void printMatchResult(PairsDto pairsDto) {
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(pairsDto.toString());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printInitializeMessage() {
        System.out.println("초기화 되었습니다.");
    }
}
