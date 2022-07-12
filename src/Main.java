import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<event> events = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("____Personal Calendar____");
            System.out.println("      Chose option ");
            System.out.println("------------------------");
            System.out.println("|1 - Create an event   |");
            System.out.println("|2 - Daily schedule    |");
            System.out.println("|3 - Search event      |");
            System.out.println("|4 - Find availability |");
            System.out.println("|5 - Exit program      |");
            System.out.println("________________________");
            System.out.print("Enter option: ");

            int option = scan.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Enter event name: ");
                    String EventName = scan.next();
                    System.out.println("Enter event date (dd/mm/yy): ");
                    String date = scan.next();
                    System.out.println("Enter event start time: ");
                    String start = scan.next();
                    System.out.println("Enter event end time: ");
                    String finish = scan.next();
                    System.out.println("Enter notes to the event: ");
                    String trash = scan.nextLine();
                    String text = scan.nextLine();
                    System.out.println();
                    System.out.println("Event was created successfully!");
                    event Event = new event(EventName, date, start, finish, text);
                    events.add(Event);
                }
            }
        }
    }
}
