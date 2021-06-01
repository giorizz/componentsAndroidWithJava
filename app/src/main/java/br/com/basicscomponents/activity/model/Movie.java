package br.com.basicscomponents.activity.model;

public class Movie {

    private String titleMovie;
    private String genereMovie;
    private String yearMovie;

    public Movie(String titleMovie, String genereMovie, String yearMovie) {
        this.titleMovie = titleMovie;
        this.genereMovie = genereMovie;
        this.yearMovie = yearMovie;
    }


    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getGenereMovie() {
        return genereMovie;
    }

    public void setGenereMovie(String genereMovie) {
        this.genereMovie = genereMovie;
    }

    public String getYearMovie() {
        return yearMovie;
    }

    public void setYearMovie(String yearMovie) {
        this.yearMovie = yearMovie;
    }
}
