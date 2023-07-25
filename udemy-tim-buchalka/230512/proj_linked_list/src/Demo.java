import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");

        printList(placesToVisit);

        placesToVisit.add(1, "Alice Springs");
        printList(placesToVisit);

        placesToVisit.remove(4);
        printList(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> myIterator = linkedList.iterator();
        while (myIterator.hasNext()) {
            System.out.println("Now visiting " + myIterator.next());
        }
        System.out.println("==============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newEntry){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        // what is the difference between ListIterator and Iterator
        // with the ListIterator we can go back end forth using: next() and previous()
        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newEntry);
            if (comparison == 0){
                // words are equal, do not add
                System.out.println("Item already included.");
                return false;
            }
            else if (comparison < 0){
                // the left comes before the right
                // we move to the next item in the linked list
            } else {
                // the right comes before the left
                // new element should be before this one
                stringListIterator.previous();
                stringListIterator.add(newEntry);
                return true;
            }
        }
        // at this point we've gone through the entire list and didn't find a value that comes after
        // the new entry, we can add the new entry at the end of the linked list
        stringListIterator.add(newEntry);
        return true;
    }

}
