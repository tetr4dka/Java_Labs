public class MovieSession {
    private String movieTitle;
    private String startTime;
    private String endTime;
    private int[][] seats;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void displaySeats() {
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

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int[][] getSeats() {
        return seats;
    }

    public void setSeats(int[][] seats) {
        this.seats = seats;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public MovieSession(String movieTitle, String startTime, String endTime, int rows, int seatsPerRow) {
        this.movieTitle = movieTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seats = new int[rows][seatsPerRow];
    }

    public void buyTicket(String movieTitle, int row, int seat) {
        if (!this.movieTitle.equals(movieTitle)) {
            System.out.println("Movie " + movieTitle + " is not playing in this session");
            return;
        }

        if (row < 1 || row > seats.length || seat < 1 || seat > seats[0].length) {
            System.out.println("Invalid seat");
            return;
        }

        if (seats[row-1][seat-1] == 1) {
            System.out.println(seats[row-1][seat-1]);
            System.out.println("Seat at row " + row + ", seat " + seat + " is already bought");
            displaySeats();
        } else {
            seats[row-1][seat-1] = 1;
            System.out.println("Ticket bought for seat at row " + row + " seat " + seat);
            displaySeats();
            System.out.println(this.startTime);
        }
    }

    @Override
    public String toString() {
        return "MovieSession " +
                "movieTitle='" + movieTitle + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime=" + endTime;
    }
}
