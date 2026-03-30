// this class stores all the info about a movie
// like title genre rating and show times

import java.util.ArrayList;

public class Movie {

    private String movieId;
    private String title;
    private String genre;
    private double rating;
    private int durationInMins;
    private ArrayList<String> showTimes;

    public Movie(String movieId, String title, String genre, double rating, int durationInMins) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.durationInMins = durationInMins;
        this.showTimes = new ArrayList<String>();
    }

    // add a show time to this movie
    public void addShowTime(String time) {
        showTimes.add(time);
    }

    // check if a show time exists
    public boolean hasShowTime(String time) {
        return showTimes.contains(time);
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getDurationInMins() {
        return durationInMins;
    }

    public ArrayList<String> getShowTimes() {
        return showTimes;
    }

    // print movie details
    public void showMovieInfo() {
        System.out.println("Movie ID  : " + movieId);
        System.out.println("Title     : " + title);
        System.out.println("Genre     : " + genre);
        System.out.println("Rating    : " + rating + " / 10");
        System.out.println("Duration  : " + durationInMins + " mins");
        System.out.println("Show Times: " + showTimes);
        System.out.println("----------------------------");
    }
}
