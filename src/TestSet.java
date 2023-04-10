import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {


    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("Mike");
        hashSet.add("Katy");
        hashSet.add("Tom");
        hashSet.add("George");
        hashSet.add("Donald");

        System.out.println(hashSet.contains("Tom"));
        System.out.println(hashSet.contains("Tim"));
        System.out.println(hashSet.isEmpty());

        System.out.println("-------------------------");
        testSet(hashSet);
        System.out.println("-------------------------");
        testSet(linkedHashSet);
        System.out.println("-------------------------");
        testSet(treeSet);


        Set<Integer> set1  = new HashSet<>();
        Set<Integer> set2  = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);


        //объядинение - union
        Set<Integer> setUnion=new HashSet<>(set1);
        setUnion.addAll(set2);
        System.out.println(setUnion);
        //пересечения - intersection
        Set<Integer> setIntesection=new HashSet<>(set1);
        setIntesection.retainAll(set2);
        System.out.println(setIntesection);
        //разность - difference
        Set<Integer> setDifference=new HashSet<>(set1);
        setDifference.removeAll(set2);
        System.out.println(setDifference);
    }
    public static void testSet(Set<String> set) {
        set.add("Mike");
        set.add("Katy");
        set.add("Tom");
        set.add("George");
        set.add("Donald");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
