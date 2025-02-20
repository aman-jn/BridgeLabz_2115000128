import java.util.*;

public class ListOperations1 {

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }

    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;
        if (positions < 0) {
            positions += size;
        }
        List<T> rotated = new ArrayList<>(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));
        list.clear();
        list.addAll(rotated);
    }

    public static <T> List<T> removeDuplicatesPreserveOrder(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (seen.add(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequency = countFrequency(inputList);
        System.out.println("Frequency of elements: " + frequency);

        List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original list: " + numberList);
        rotateList(numberList, 2);
        System.out.println("Rotated list by 2 positions: " + numberList);

        List<Integer> duplicateList = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> uniqueList = removeDuplicatesPreserveOrder(duplicateList);
        System.out.println("List after removing duplicates while preserving order: " + uniqueList);
    }
}