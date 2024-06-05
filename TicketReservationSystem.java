import java.util.ArrayList;
import java.util.Scanner;

public class TicketReservationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ticket> tickets = new ArrayList<>();

        int choice;

        do {
            System.out.println("\nTicket Reservation System");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Available Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookTicket(tickets, scanner);
                    break;
                case 2:
                    viewTickets(tickets);
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void bookTicket(ArrayList<Ticket> tickets, Scanner scanner) {
        System.out.print("Enter passenger name: ");
        String name = scanner.next();

        int availableSeats = tickets.isEmpty() ? 100 :  // Assuming 100 seats initially
                             tickets.get(tickets.size() - 1).getId() + 1;

        Ticket ticket = new Ticket(availableSeats, name);
        tickets.add(ticket);

        System.out.println("Ticket Booked! Your ticket ID is: " + ticket.getId());
    }

    public static void viewTickets(ArrayList<Ticket> tickets) {
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked yet.");
        } else {
            System.out.println("Booked Tickets:");
            for (Ticket ticket : tickets) {
                System.out.println("ID: " + ticket.getId() + ", Name: " + ticket.getName());
            }
        }
    }
}

class Ticket {
    private int id;
    private String name;

    public Ticket(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
