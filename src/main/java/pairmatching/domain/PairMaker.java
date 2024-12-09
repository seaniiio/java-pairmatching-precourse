package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;

public class PairMaker {

    private static final int MAX_ATTEMPT = 3;

    public Pairs pairMatch(Course course, Level level, Mission mission, Crews crews, List<Pairs> createdPairs) {
        for (int i = 0; i < MAX_ATTEMPT; i++) {
            Pairs newPairs = new Pairs(course, level, mission);
            crews.shuffle();
            match(newPairs, crews);

            if (isExistingPairs(newPairs, findSameLevelPairs(level, createdPairs))) {
                continue;
            }

            return newPairs;
        }
        throw new IllegalArgumentException(ErrorMessage.MATCHING_FAIL_ERROR.getErrorMessage());
    }

    private void match(Pairs newPairs, Crews crews) {
        int size = crews.getSize();
        if (size % 2 == 0) {
            for (int i = 0; i < size - 1; i += 2) {
                newPairs.addPair(new Pair(crews.matchCrew(i, i+2)));
            }
        }

        if (size % 2 == 1) {
            for (int i = 0; i < size - 3; i += 2) {
                newPairs.addPair(new Pair(crews.matchCrew(i, i+2)));
            }
            newPairs.addPair(new Pair(crews.matchCrew(crews.getSize()-3, crews.getSize())));
        }
    }

    private List<Pairs> findSameLevelPairs(Level level, List<Pairs> createdPairs) {
        List<Pairs> sameLevelPairs = new ArrayList<>();
        for (Pairs createdPair : createdPairs) {
            if (createdPair.isLevel(level)) { // 레벨이 같은 페어들에 대해 같이 매칭된사람이 없어야 함
                sameLevelPairs.add(createdPair);
            }
        }
        return sameLevelPairs;
    }

    private boolean isExistingPairs(Pairs newPairs, List<Pairs> createdPairs) {
        for (Pairs createdPair : createdPairs) {
            if (createdPair.isDuplicatedPair(newPairs)) {
                return true;
            }
        }
        return false;
    }
}
