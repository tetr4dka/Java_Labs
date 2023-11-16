import java.util.HashMap;
import java.util.Map;

public class Hall {
    private int rows;
    private int seatsPerRow;
    private Map<String, MovieSession> sessions;

    public Hall(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.sessions = new HashMap<>();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public Map<String, MovieSession> getSessions() {
        return sessions;
    }

    public void setSessions(Map<String, MovieSession> sessions) {
        this.sessions = sessions;
    }

    public void configureSeats(int[][] seats) {
        if (seats.length != rows || seats[0].length != seatsPerRow) {
            System.out.println("Invalid seats config");
        }
    }

    public void createSession(String movieTitle, String startTime, String endTime) {
        if (sessions.containsKey(startTime)) {
            System.out.println("Session at " + startTime + " already exists");
            return;
        }
        MovieSession session = new MovieSession(movieTitle, startTime, endTime, rows, seatsPerRow);
        sessions.put(startTime, session);
    }


    public void buyTicket(String movieTitle, String startTime, int row, int seat) {
        if (sessions.containsKey(startTime)) {
            MovieSession session = sessions.get(startTime);
            session.buyTicket(movieTitle, row, seat);
        } else {
            System.out.println("Movie session at " + startTime + " does not exist");
        }
    }
}
