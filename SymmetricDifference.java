import java.util.*;

public class SymmetricDifference {

    public static Set computeSymmetricDifference(Set set1, Set set2) {
        Set symmetricDifference = new HashSet(set1);
        symmetricDifference.addAll(set2);
        Set temp = new HashSet(set1);
        temp.retainAll(set2);
        symmetricDifference.removeAll(temp);
        return symmetricDifference;
    }

    public static void main(String[] args) {
        Set set1 = new HashSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set set2 = new HashSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set symmetricDifference = computeSymmetricDifference(set1, set2);
        System.out.println("Symmetric difference of the two sets: " + symmetricDifference);
    }
}