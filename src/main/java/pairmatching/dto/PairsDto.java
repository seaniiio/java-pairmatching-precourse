package pairmatching.dto;

import java.util.List;
import pairmatching.domain.Pair;

public class PairsDto {

    private final List<Pair> pairs;

    public PairsDto(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public String toString() {
        String output = "";
        for (Pair pair : pairs) {
            output += (pair.toString() + System.lineSeparator());
        }
        return output;
    }
}
