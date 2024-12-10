package pairmatching.dto;

import java.util.List;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;

public class PairsDto {

    private final List<Pair> pairs;

    public PairsDto(Pairs pairs) {
        this.pairs = pairs.getPairs();
    }

    public String toString() {
        String output = "";
        for (Pair pair : pairs) {
            output += (pair.toString() + System.lineSeparator());
        }
        return output;
    }
}
