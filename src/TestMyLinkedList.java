public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(10);
        System.out.println(myLinkedList);
        myLinkedList.remove(1);
        myLinkedList.remove(1);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);

    }
}
