package editor;

import java.io.File;
import java.util.Scanner;

public class max {
    public static void main(String[] args){
        File file = new File("C:/Users/Javan/Downloads/dataset_91069.txt");
        long previous = 0;
        int year = 0;
        long max = 0;
        try (Scanner sc = new Scanner(file)){
            while (sc.hasNextLine()){
                Scanner scanner = new Scanner(sc.nextLine());
                int num = scanner.nextInt();
                long population = Long.parseLong(scanner.next().replace(",", ""));
                if (previous == 0){
                    previous = population;
                }
                else {
                    long difference = population - previous;
                    if (difference > max){
                        max = difference;
                        year = num;
                        previous = population;
                    }
                    else {
                        previous = population;
                    }
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        System.out.println(year);
    }
}
