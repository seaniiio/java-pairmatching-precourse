package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pairs {

    private final Course course;
    private final Level level;
    private final Mission mission;
    private List<Pair> pairs;

    public Pairs(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairs = new ArrayList<>();
    }

    public void addPair(Pair pair) {
        this.pairs.add(pair);
    }

    public boolean isLevel(Level level) {
        return this.level.equals(level);
    }

    public boolean isDuplicatedPair(Pairs newPairs) {

        for (Pair newPair : newPairs.pairs) {
            for (Pair pair : this.pairs) {
                if (pair.contains(newPair)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Pair> getPairs() {
        return new ArrayList<>(this.pairs);
    }

    public boolean isExistingPairs(Course course, Level level, Mission mission) {
        return this.course.equals(course) && this.level.equals(level) && this.mission.equals(mission);
    }

    public void swapPairs(Pairs matchedPairs) {
        this.pairs = matchedPairs.getPairs();
    }
}
