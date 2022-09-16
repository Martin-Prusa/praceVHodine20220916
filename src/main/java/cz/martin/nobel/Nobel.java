package cz.martin.nobel;

public class Nobel {
    private int year;
    private String subject;
    private String winner;

    public Nobel(int year, String subject, String winner) {
        this.year = year;
        this.subject = subject;
        this.winner = winner;
    }

    public int getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    public String getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "Nobel{" +
                "year=" + year +
                ", subject='" + subject + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }
}
