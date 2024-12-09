package pairmatching.domain;

import java.util.List;

public class Pair {

    private final List<Crew> pairMembers;

    public Pair(List<Crew> pairMembers) {
        this.pairMembers = pairMembers;
    }

    public boolean contains(Pair newPair) {
        return this.pairMembers.contains(newPair.pairMembers);
    }

    public String toString() {
        String crewInformation = "";
        for (Crew pairMember : pairMembers) {
            crewInformation += (pairMember.getName() + " : ");
        }
        return crewInformation.substring(0, crewInformation.length()-3);
    }
}
