package pairmatching.domain;

import java.util.List;

public class Pair {

    private final List<Crew> pairMembers;

    public Pair(List<Crew> pairMembers) {
        this.pairMembers = pairMembers;
    }

    public boolean contains(Pair newPair) {
        boolean isContaining = true;
        for (Crew pairMember : newPair.getPairMembers()) {
            if (!this.pairMembers.contains(pairMember)) {
                isContaining = false;
            }
        }
        return isContaining;
    }

    public String toString() {
        String crewInformation = "";
        for (Object pairMember : pairMembers) {
            crewInformation += (pairMember + " : ");
        }
        return crewInformation.substring(0, crewInformation.length()-3);
    }

    private List<Crew> getPairMembers() {
        return this.pairMembers;
    }
}
