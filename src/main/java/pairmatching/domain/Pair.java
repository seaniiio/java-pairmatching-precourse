package pairmatching.domain;

import java.util.List;

public class Pair {

    private final List<String> pairMembers;

    public Pair(List<String> pairMembers) {
        this.pairMembers = pairMembers;
    }

    public boolean contains(Pair newPair) {
        boolean isContaining = true;
        for (String pairMember : newPair.getPairMembers()) {
            if (!this.pairMembers.contains(pairMember)) {
                isContaining = false;
            }
        }
        return isContaining;
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
