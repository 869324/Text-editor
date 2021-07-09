import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        // write your code here
        List<String> list = new ArrayList<>(Arrays.asList(array));
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (!next.startsWith("J")){
                iterator.remove();
            }
            else {
                iterator.set(next.substring(1));
            }
        }

        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}