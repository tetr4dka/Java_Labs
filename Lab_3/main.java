import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    
        List<Cinema> cinemas = new ArrayList<>();

        Cinema cinemaA = new Cinema("cinemaA");
        Cinema cinemaB = new Cinema("cinemaB");
        cinemas.add(cinemaA);
        cinemas.add(cinemaB);

        cinemaA.addHall(1, 15, 15);
        cinemaA.addHall(2, 10, 10);
        cinemaB.addHall(1, 10, 10);
        cinemaB.addHall(2, 10, 10);

        cinemaA.createSession(1, "Avatar", "2023-10-15T12:10:00", "2023-10-15T13:10:00");
        cinemaA.createSession(1, "Star Wars", "2023-10-15T19:01:00", "2023-10-15T21:30:00");

        cinemaB.createSession(1, "Matrix 4", "2023-10-15T15:00:00", "2023-10-15T16:10:00");
        cinemaB.createSession(1, "The Dune", "2023-10-15T18:30:00", "2023-10-15T19:10:00");

        cinemaB.createSession(2, "James Bond", "2023-10-16T14:30:00", "2023-10-15T12:10:00");
        cinemaB.createSession(2, "Cruella", "2023-10-16T17:30:00", "2023-10-15T18:10:00");

        UI ui = new UI(cinemas);
        ui.start();

    }
}
