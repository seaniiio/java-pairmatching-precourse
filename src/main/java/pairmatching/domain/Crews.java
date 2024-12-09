package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Crews {

    private List<String> crews;

    public Crews(List<String> crews) {
        this.crews = crews;
    }

    public void shuffle() {
        this.crews = Randoms.shuffle(crews);
    }

    public List<String> matchCrew(int startIndex, int endIndex) {
        return new ArrayList<>(this.crews.subList(startIndex, endIndex));
    }

    public int getSize() {
        return this.crews.size();
    }
}
