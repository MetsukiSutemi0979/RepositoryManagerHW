package ru.netology.repository;

import ru.netology.domain.FilmsInPlaybill;

public class PlaybillManager {
    private FilmsInPlaybill[] films = new FilmsInPlaybill[0];


    public void add (FilmsInPlaybill film) {
        FilmsInPlaybill[] tmp = new FilmsInPlaybill[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public FilmsInPlaybill[] getFilms() {
        return films;
    }

    public FilmsInPlaybill[] findAll () {
        return films;
    }

    public  FilmsInPlaybill[] findByLast (int limit) {
        int resultLength;

        if (films.length < limit) {
            resultLength = films.length;
        } else {
            resultLength = limit;
        }

        FilmsInPlaybill[] result = new FilmsInPlaybill[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];
        }

        return result;
    }
}
