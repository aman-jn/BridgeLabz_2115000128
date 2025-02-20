import java.util.*;

public class VotingSystem {

    Map<String, Integer> votesHashMap = new HashMap<>();
    LinkedHashMap<String, Integer> votesLinkedHashMap = new LinkedHashMap<>();
    TreeMap<String, Integer> votesTreeMap = new TreeMap<>();

    public void castVote(String candidate) {
        votesHashMap.merge(candidate, 1, Integer::sum);
        votesLinkedHashMap.merge(candidate, 1, Integer::sum);
        votesTreeMap.merge(candidate, 1, Integer::sum);
    }

    public Map<String, Integer> getVotesHashMap() {
        return votesHashMap;
    }

    public LinkedHashMap<String, Integer> getVotesLinkedHashMap() {
        return votesLinkedHashMap;
    }

    public TreeMap<String, Integer> getVotesTreeMap() {
        return votesTreeMap;
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Carol");
        system.castVote("Bob");
        system.castVote("Alice");

        System.out.println("Votes (HashMap): " + system.getVotesHashMap());
        System.out.println("Votes (LinkedHashMap - Insertion Order): " + system.getVotesLinkedHashMap());
        System.out.println("Votes (TreeMap - Sorted Order): " + system.getVotesTreeMap());
    }
}
