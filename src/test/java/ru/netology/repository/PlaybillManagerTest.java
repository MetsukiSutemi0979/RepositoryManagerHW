package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmsInPlaybill;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaybillManagerTest {

    FilmsInPlaybill film1 = new FilmsInPlaybill("Бладшот");
    FilmsInPlaybill film2 = new FilmsInPlaybill("Вперёд");
    FilmsInPlaybill film3 = new FilmsInPlaybill("Отель 'Белград'");
    FilmsInPlaybill film4 = new FilmsInPlaybill("Джентельмены");
    FilmsInPlaybill film5 = new FilmsInPlaybill("Человек-невидимка");
    FilmsInPlaybill film6 = new FilmsInPlaybill("Тролли. Мировой тур");
    FilmsInPlaybill film7 = new FilmsInPlaybill("Номер один");

    PlaybillManager repo = new PlaybillManager();


    @Test
    public void shouldAddFilms() {
        repo.add(film1);
        repo.add(film2);
        repo.add(film3);
        repo.add(film4);
        repo.add(film5);
        repo.add(film6);
        repo.add(film7);

        FilmsInPlaybill[] expected = {film1, film2, film3, film4, film5, film6, film7};
        FilmsInPlaybill[] actual = repo.getFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void displayAllFilmsInTheOrderInWhichTheyWereAdded() {
        repo.add(film1);
        repo.add(film2);
        repo.add(film3);
        repo.add(film4);
        repo.add(film5);
        repo.add(film6);
        repo.add(film7);
        FilmsInPlaybill[] all = repo.findAll();


        FilmsInPlaybill[] expected = {film1, film2, film3, film4, film5, film6, film7};
        FilmsInPlaybill[] actual = all;

        assertArrayEquals(expected, actual);
        assertEquals("Бладшот", actual[0].getFilmName());
        assertEquals("Вперёд", actual[1].getFilmName());
        assertEquals("Отель 'Белград'", actual[2].getFilmName());
        assertEquals("Джентельмены", actual[3].getFilmName());
        assertEquals("Человек-невидимка", actual[4].getFilmName());
        assertEquals("Тролли. Мировой тур", actual[5].getFilmName());
        assertEquals("Номер один", actual[6].getFilmName());
    }

    @Test
    public void findLastShouldReturnLastAddedFilmsInReverseOrder() {
        repo.add(film1);
        repo.add(film2);
        repo.add(film3);
        repo.add(film4);
        repo.add(film5);
        repo.add(film6);
        repo.add(film7);
        repo.findLast();

        FilmsInPlaybill[] expected = {film7, film6, film5, film4, film3};
        FilmsInPlaybill[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastShouldReturnLastAddedFilmsInReverseOrderWithSmallerLimit() {
        PlaybillManager repo = new PlaybillManager(3);
        repo.add(film1);
        repo.add(film2);
        repo.add(film3);
        repo.add(film4);
        repo.add(film5);
        repo.add(film6);
        repo.add(film7);
        repo.findLast();

        FilmsInPlaybill[] expected = {film7, film6, film5};
        FilmsInPlaybill[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastShouldReturnLastAddedFilmsInReverseOrderWithLargerLimit() {
        PlaybillManager repo = new PlaybillManager(7);
        repo.add(film1);
        repo.add(film2);
        repo.add(film3);
        repo.add(film4);
        repo.add(film5);
        repo.add(film6);
        repo.add(film7);
        repo.findLast();

        FilmsInPlaybill[] expected = {film7, film6, film5, film4, film3, film2, film1};
        FilmsInPlaybill[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldReturnLastWithDefaultLimit() {
        PlaybillManager manager = new PlaybillManager();
        FilmsInPlaybill[] addedFilms = new FilmsInPlaybill[6];

        for (int i = 0; i < 6; i++) {
            FilmsInPlaybill film = new FilmsInPlaybill("Film " + (i + 1));
            manager.add(film);
            addedFilms[i] = film;
        }

        FilmsInPlaybill[] expected = {
                addedFilms[5],
                addedFilms[4],
                addedFilms[3],
                addedFilms[2],
                addedFilms[1]
        };

        FilmsInPlaybill[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnLastWithCustomLimit() {
        PlaybillManager manager = new PlaybillManager(3);
        FilmsInPlaybill[] addedFilms = new FilmsInPlaybill[5];

        for (int i = 0; i < 5; i++) {
            FilmsInPlaybill film = new FilmsInPlaybill("Film " + (i + 1));
            manager.add(film);
            addedFilms[i] = film;
        }

        FilmsInPlaybill[] expected = {
                addedFilms[4], 
                addedFilms[3],
                addedFilms[2]
        };

        FilmsInPlaybill[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }
}

