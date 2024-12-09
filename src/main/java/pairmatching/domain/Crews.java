package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Crews {

    private List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public void shuffle() {
        this.crews = Randoms.shuffle(crews);
    }

    public List<Crew> matchCrew(int startIndex, int endIndex) {
        return new ArrayList<>(this.crews.subList(startIndex, endIndex));
    }

    public int getSize() {
        return this.crews.size();
    }
}
