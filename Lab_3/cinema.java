import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cinema {
    private String name;
    private Map<Integer, Hall> halls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Hall> getHalls() {
        return halls;
    }

    public void setHalls(Map<Integer, Hall> halls) {
        this.halls = halls;
    }

    public Cinema(String name) {
        this.name = name;
        this.halls = new HashMap<>();
    }
    public void addHall(int hallNumber, int rows, int seatsPerRow) {
        Hall hall = new Hall(rows, seatsPerRow);
        halls.put(hallNumber, hall);
    }

    public void configureHallSeats(int hallNumber, int[][] seats) {
        if (halls.containsKey(hallNumber)) {
            halls.get(hallNumber).configureSeats(seats);
        } else {
            System.out.println("Hall with number " + hallNumber + " does not exist");
        }
    }
    public void createSession(int hallNumber, String movieTitle, String startTime, String endTime) {
        if (halls.containsKey(hallNumber)) {
            Hall hall = halls.get(hallNumber);
            for (MovieSession session : hall.getSessions().values()) {
                if (areSessionsIntersect(startTime, endTime, session.getStartTime(), session.getEndTime())) {
                    System.out.println("Session intersects with existing session: " + session.getEndTime());
                }
            }
            hall.createSession(movieTitle, startTime, endTime);
        } else {
            System.out.println("Hall with number " + hallNumber + " does not exist");
        }
    }

    private boolean areSessionsIntersect(String startTime, String endTime, String startTime1, String endTime1) {
        LocalDateTime start1 = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime end1 = LocalDateTime.parse(endTime, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime start2 = LocalDateTime.parse(startTime1, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime end2 = LocalDateTime.parse(endTime1, DateTimeFormatter.ISO_DATE_TIME);
        return (start1.isBefore(end2) && end1.isAfter(start2)) || (start2.isBefore(end1) && end2.isAfter(start1));
    }

    public void printPlan(int hallNumber, String movieTitle, String startTime) {
        if (halls.containsKey(hallNumber)) {
            Hall hall = halls.get(hallNumber);
            Map<String, MovieSession> sessions = hall.getSessions();
            for (Map.Entry<String, MovieSession> entry : sessions.entrySet()) {
                if (entry.getValue().getMovieTitle().equals(movieTitle) &&
                entry.getValue().getStartTime().equals(startTime)) {
                    int[][] seats = entry.getValue().getSeats();
                    System.out.println("Seats in the hall:");
                    for (int i = 0; i < seats.length; i++) {
                        for (int j = 0; j < seats[i].length; j++) {
                            if (seats[i][j] == 0) {
                                System.out.print("X ");
                            } else {
                                System.out.print("O ");
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

    public static List<String> findNearestMovie(List<Cinema> cinemas, String movieTitle) {
        List<String> result = new ArrayList<>();
        MovieSession nearestMovie = null;
        String nearestCinema = "";

        for (Cinema cinema: cinemas) {
            for (Hall hall : cinema.getHalls().values()) {
                for (MovieSession session : hall.getSessions().values()) {
                    if (!session.getMovieTitle().equalsIgnoreCase(movieTitle)) {
                        continue;
                    }
                    nearestMovie = session;
                    nearestCinema = cinema.getName();
                }
            }
        }
        result.add(nearestMovie.getStartTime());
        result.add(nearestCinema);
        return result;
    }

    public void buyTicket(int hallNumber, String movieTitle, String startTime, int row, int seat) {
        if (halls.containsKey(hallNumber)) {
            Hall hall = halls.get(hallNumber);
            hall.buyTicket(movieTitle, startTime, row, seat);
        } else {
            System.out.println("Hall with number " + hallNumber + " does not exist");
        }
    }

    @Override
    public String toString() {
        return "Cinema: " +
                "name='" + name + '\'' +
                ", halls=" + halls.keySet();
    }
}
