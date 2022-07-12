import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<event> events = new ArrayList<>();

    public static void availableEvent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter date: ");
        String date = scan.next();
        System.out.println("From time: ");
        String fromTime = scan.next();
        int test = Integer.parseInt(fromTime.split(":")[0]);
        System.out.println("Enter duration: ");
        String duration = scan.next();
        ArrayList<event> Events = searchByDate(date);
        if (Events != null) {
            int test3 = 0;
            event Event = null;
            for (int i = 0; i < Events.size(); i++) {
                if (Integer.parseInt(Events.get(i).startTime.split(":")[0]) > test3 || Integer.parseInt(Events.get(i).startTime.split(":")[0]) >= test) {
                    Event = Events.get(i);
                    test3 = Integer.parseInt(Events.get(i).startTime.split(":")[0]);
                }
            }
            if (Event == null) {
                System.out.println("Available slot for the event: " + date + " " + fromTime);
            } else {
                System.out.println("Available slot for the event: " + date + " From: " + Event.endTime);
            }
        } else {
            System.out.println("The whole day: " + date + " is free !");
        }
    }

    public static event searchByName(String name) {
        for (int i = 0; i < events.size(); i++) {
            if (name.equals(events.get(i).name)) {
                return events.get(i);
            }
        }
        return null;
    }

    public static void searchEvent() {
        System.out.println("Enter event title: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        event Event = searchByName(name);
        if (Event != null) {
            System.out.println(Event.name + " " + Event.date + " " + Event.startTime + " " + Event.endTime + " " + Event.notes + " ");
            System.out.println("Do you want to cancel or edit event (1 - Cancel | 2 - Edit | press any key to continue)");
            String option = scan.nextLine();
            switch (option) {
                case "1" -> {
                    System.out.println("Are you sure you want to cancel the event ? (Yes/No)");
                    String checking = scan.nextLine();
                    String checking1 = scan.nextLine();
                    if (checking1.equals("Yes") || checking1.equals("yes")) {
                        events.remove(Event);
                    }
                    if (checking1.equals("No") || checking1.equals("no")) {
                        System.out.println();
                    }
                }
                case "2" -> {
                    System.out.println("Enter new start time: ");
                    Event.startTime = scan.next();
                    System.out.println("Enter new end time: ");
                    Event.endTime = scan.next();
                    System.out.println("Successfully updated the event !");
                }
                default -> System.out.println();
            }
        } else {
            System.out.println("There's no such event");
        }

    }

    public static ArrayList<event> searchByDate(String date) {
        ArrayList<event> result = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            if (date.equals(events.get(i).date)) {
                result.add(events.get(i));
            }
        }
        if (result.size() > 0) {
            return result;
        }
        return null;
    }

    public static void schedule() {
        System.out.println("Enter date(dd/mm/yy): ");
        Scanner scan = new Scanner(System.in);
        String date = scan.nextLine();
        ArrayList<event> events1 = searchByDate(date);
        if (events1 != null) {
            System.out.println("__Daily schedule__");

            for (int i = 0; i < events1.size(); i++) {
                System.out.println("-Name: " + events1.get(i).name);
                System.out.println("-Date: " + events1.get(i).date);
                System.out.println("-Start: " + events1.get(i).startTime);
                System.out.println("-End: " + events1.get(i).endTime);
                System.out.println("-Notes: " + events1.get(i).notes);
            }
        } else {
            System.out.println("There are no saved events for the day.");
        }
    }

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
                case 2 -> {
                    System.out.println();
                    schedule();
                }
                case 3 -> {
                    System.out.println();
                    searchEvent();
                }
                case 4 -> {
                    System.out.println();
                    availableEvent();
                }
                case 5 -> {
                    System.out.println("Exiting program..");
                    System.exit(0);
                }
            }
        }
    }
}
