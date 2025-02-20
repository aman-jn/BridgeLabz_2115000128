import java.util.*;

public class SetOperations {

    public static boolean areSetsEqual(Set set1, Set set2) {
        return set1.equals(set2);
    }

    public static Set computeUnion(Set set1, Set set2) {
        Set union = new HashSet(set1);
        union.addAll(set2);
        return union;
    }

    public static Set computeIntersection(Set set1, Set set2) {
        Set intersection = new HashSet(set1);
        intersection.retainAll(set2);
        return intersection;
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

        boolean result = areSetsEqual(set1, set2);
        System.out.println("Are the two sets equal? " + result);

        Set union = computeUnion(set1, set2);
        System.out.println("Union of the two sets: " + union);

        Set intersection = computeIntersection(set1, set2);
        System.out.println("Intersection of the two sets: " + intersection);
    }
}