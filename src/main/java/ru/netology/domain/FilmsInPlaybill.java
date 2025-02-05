package ru.netology.domain;
public class FilmsInPlaybill {
    private String filmName;
    private int limit;

    public FilmsInPlaybill(String filmName) {
        this.filmName = filmName;
        this.limit = 5;
    }

    public String getFilmName() {
        return filmName;
    }


}
