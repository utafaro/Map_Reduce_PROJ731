import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReducerExample {

    public static void main(String[] args) {
        List<Map<String, Integer>> list = new ArrayList<>();
        list.add(createMap("Apple", 1));
        list.add(createMap("Apple", 1));
        list.add(createMap("Apple", 1));

        Map<String, Integer> result = reduce(list);

        System.out.println(list); // Output: {Apple=3}
    }

    public static Map<String, Integer> reduce(List<Map<String, Integer>> list) {
        Map<String, Integer> result = new HashMap<>();

        for (Map<String, Integer> map : list) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                result.merge(key, value, Integer::sum); // Merge with sum
            }
        }

        return result;
    }

    public static Map<String, Integer> createMap(String key, int value) {
        Map<String, Integer> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
