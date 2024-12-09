package pairmatching.domain;

import java.util.List;

public class Pair {

    private final List<String> pairMembers;

    public Pair(List<String> pairMembers) {
        this.pairMembers = pairMembers;
    }

    public boolean contains(Pair newPair) {
        return this.pairMembers.contains(newPair.getPairMembers());
    }

    public String toString() {
        String crewInformation = "";
        for (String pairMember : pairMembers) {
            crewInformation += (pairMember + " : ");
        }
        return crewInformation.substring(0, crewInformation.length()-3);
    }

    private List<String> getPairMembers() {
        return this.pairMembers;
    }
}
