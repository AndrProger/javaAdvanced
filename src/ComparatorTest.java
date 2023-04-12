import java.util.*;

public class ComparatorTest {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("catdx");
        animals.add("frog");
        animals.add("bird");


        Collections.sort(animals,new StringLengthComparator());
        System.out.println(animals);

        List<Integer> numbers=new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

        Collections.sort(numbers, (o1, o2) -> {
            if(o1>o2) return -1;
            if(o1<o2) return 1;
            return 0;
        });
        System.out.println(numbers);

        List<Person> people =new ArrayList<>();
        people.add(new Person(3, "John"));
        people.add(new Person(2, "Bob"));
        people.add(new Person(1, "Mike"));
        Collections.sort(people, (o1, o2) -> {
            if(o1.getId()>o2.getId()) return 1;
            if(o1.getId()<o2.getId()) return -1;
            return 0;
        });
        System.out.println(people);

        List<Person> peopleList =new ArrayList<>();
        Set<Person> peopleSet =new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        System.out.println(peopleList);
        System.out.println(peopleSet);
   }
   private static void addElements(Collection collection){
        collection.add(new Person(4,"George"));
        collection.add(new Person(1,"Bob"));
        collection.add(new Person(2,"Tom"));
        collection.add(new Person(3,"Katy"));
   }

}
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length()>o2.length()) return 1;
        if(o1.length()<o2.length()) return -1;
        return 0;
    }
}

