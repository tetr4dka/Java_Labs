import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static labs.lab3.Cinema.findNearestMovie;

public class UI {
    private Scanner scanner;
    private List<Cinema> cinemas;
    public UI(List<Cinema> cinemas) {
        scanner = new Scanner(System.in);
        this.cinemas = cinemas;
    }
    public void start() {
        boolean running = true;
        boolean adminFlag = isAdmin();
        while (running) {
            if (adminFlag) {
                printAdminMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> createCinema();
                    case 2 -> createHall();
                    case 3 -> createMovieSession();
                    case 4 -> showCinemas();
                    case 5 -> showCinemaInfo();
                    case 6 -> running = false;
                    default -> System.out.println("Wrong operation");
                }
            } else {
                printUserMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> buyTicket();
                    case 2 -> findNearestMovieSession();
                    case 3 -> showCinemas();
                    case 4 -> showCinemaInfo();
                    case 5 -> running = false;
                    default -> System.out.println("Wrong operation");
                }
            }
        }

    }

    private void printAdminMenu() {
        System.out.println("\n-- Admin Operations --");
        System.out.println("1. Create cinema");
        System.out.println("2. Create hall");
        System.out.println("3. Create movie session");
        System.out.println("4. Show cinemas");
        System.out.println("5. Show cinema info");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
    }

    private void printUserMenu() {
        System.out.println("\n-- User Operations --");
        System.out.println("1. Buy ticket");
        System.out.println("2. Find nearest movie session");
        System.out.println("3. Show cinemas");
        System.out.println("4. Show cinema info");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
    }

    public boolean isAdmin () {
        System.out.println("Hello, enter your login and password. (P.S. L: admin P: admin for admin and every another chars for another user)");
        System.out.println("Enter your login");
        String login = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        if (login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            return true;
        } else {
            return false;
        }
    }

    public void createCinema() {
        System.out.println("Enter name of the cinema");
        String name = scanner.nextLine();
        Cinema cinema = new Cinema(name);
        cinemas.add(cinema);
        System.out.println("Cinema was created: ");
    }

    public void createHall() {
        System.out.println("Enter name of the cinema where u want to create hall");
        String cinemaName = scanner.nextLine();
        System.out.println("Enter id of the hall");
        int id = scanner.nextInt();
        System.out.println("Enter number of rows");
        int rows = scanner.nextInt();
        System.out.println("Enter number of seats per row");
        int seatsPerRow = scanner.nextInt();
        scanner.nextLine();
        boolean flag = false;
        for (Cinema cinema : cinemas) {
            if (cinema.getName().equals(cinemaName)) {
                cinema.addHall(id, rows, seatsPerRow);
                flag = true;
                System.out.println("Hall " + id + " created");
            }
        }
        if (!flag) {
            System.out.println("Cinema " + cinemaName + " does not exist");
        }
    }

    public void createMovieSession() {
        System.out.println("Enter name of the cinema, where u want to create this movie session");
        String cinemaName = scanner.nextLine();
        System.out.println("Enter number of hall, where u want to create movie session");
        int id = scanner.nextInt();
        System.out.println("Enter movie title");
        String title = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter time where movie starts (pattern - <yyyy-mm-ddThh:mm:ss>)");
        String startTime = scanner.nextLine();
        System.out.println("Enter time where movie starts (pattern - <yyyy-mm-ddThh:mm:ss>)");
        String endTime = scanner.nextLine();
        for (Cinema cinema : cinemas) {
            if (cinema.getName().equals(cinemaName)) {
                cinema.createSession(id, title, startTime, endTime);
            }
        }
    }

    public void showCinemas() {
        System.out.println("Here list of cinemas: ");
        for (Cinema cinema : cinemas) {
            System.out.println(cinema.toString());
        }
    }

    public void showCinemaInfo() {
        System.out.println("Enter name of cinema that u want to see: ");
        String cinemaName = scanner.nextLine();
        boolean cinemaExists = false;

        for (Cinema cinema : cinemas) {
            if (cinema.getName().equals(cinemaName)) {
                cinemaExists = true;
                System.out.println("Here is the list of movie sessions: ");
                for (Map.Entry<Integer, Hall> entry: cinema.getHalls().entrySet()) {
                    for (MovieSession movieSession : entry.getValue().getSessions().values()) {
                        System.out.println("---------------------------");
                        System.out.println(movieSession.toString());
                        movieSession.displaySeats();
                    }
                }
            }
        }

        if (!cinemaExists) {
            System.out.println("Cinema " + cinemaName + " does not exist");
        }
    }

    public void buyTicket() {
        System.out.println("Here list of cinemas, where u can buy a ticket");
        for (Cinema cinema : cinemas) {
            System.out.println(cinema.toString());
        }
        System.out.println("Enter name of cinema where u want to buy a ticket");
        String cinemaName = scanner.nextLine();
        for (Cinema cinema : cinemas) {
            if (cinema.getName().equals(cinemaName)) {
                System.out.println("Here list of movie sessions today: ");
                for (Map.Entry<Integer, Hall> entry: cinema.getHalls().entrySet()) {
                    for (MovieSession movieSession : entry.getValue().getSessions().values()) {
                        System.out.println("---------------------------");
                        System.out.println("Number of hall: " + entry.getKey());
                        System.out.println(movieSession.toString());
                        movieSession.displaySeats();
                    }
                }

                System.out.println("Enter hall number, where u want to buy a ticket");
                int hallNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter movie title");
                String title = scanner.nextLine();
                System.out.println("Enter date (pattern - <yyyy-mm-ddThh:mm:ss>)");
                String date = scanner.nextLine();
                System.out.println("Enter row");
                int row = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter seat");
                int seat = scanner.nextInt();
                scanner.nextLine();
                cinema.buyTicket(hallNumber, title, date, row, seat);
            }
        }
    }

    public void findNearestMovieSession() {
        System.out.println("Enter title of movie: ");
        String title = scanner.nextLine();
        try {
            List<String> result = findNearestMovie(cinemas, title);
            System.out.println("Clothest cinema where u can watch " + title + " is " + result.get(1) + ". Start time: " + result.get(0));
        } catch (NullPointerException e) {
            System.out.println("There are no nearest movie");
        }
    }
}
