package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import pairmatching.constant.ErrorMessage;
import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;

public class PairRepository {

    private static final int MAX_ATTEMPT = 3;

    private static final PairRepository instance = new PairRepository();
    private static List<Pairs> pairs = new ArrayList<>();

    public static PairRepository getInstance() {
        return instance;
    }

    public Pairs pairMatch(Course course, Level level, Mission mission, Crews crews) {
        for (int i = 0; i < MAX_ATTEMPT; i++) {
            Pairs newPairs = new Pairs(course, level, mission);
            crews.shuffle();
            match(newPairs, crews);

            if (isExistingPairs(newPairs, findSameLevelPairs(level, pairs))) {
                continue;
            }

            pairs.add(newPairs);
            return newPairs;
        }
        throw new IllegalArgumentException(ErrorMessage.MATCHING_FAIL_ERROR.getErrorMessage());
    }

    public Pairs rematch(Course course, Level level, Mission mission, Crews crewsByCourse) {
        Pairs matchedPairs = pairMatch(course, level, mission, crewsByCourse);
        for (Pairs createdPair : pairs) {
            if (createdPair.isExistingPairs(course, level, mission)) {
                createdPair.swapPairs(matchedPairs);
            }
        }

        return matchedPairs;
    }

    public boolean checkPairExist(Course course, Level level, Mission mission) {
        for (Pairs createdPair : pairs) {
            if (createdPair.isExistingPairs(course, level, mission)) {
                return true;
            }
        }
        return false;
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
            if (createdPair.isLevel(level)) {
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

    public Pairs find(Course course, Level level, Mission mission) {
        for (Pairs createdPair : pairs) {
            if (createdPair.isExistingPairs(course, level, mission)) {
                return createdPair;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NO_PAIR_ERROR.getErrorMessage());
    }

    public void initializePairs() {
        pairs = new ArrayList<>();
    }
}