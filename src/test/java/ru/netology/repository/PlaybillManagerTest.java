package ru.netology.repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmsInPlaybill;

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

        Assertions.assertArrayEquals(expected, actual);
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
        repo.findAll();


        FilmsInPlaybill[] expected = {film1, film2, film3, film4, film5, film6, film7};
        FilmsInPlaybill[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals("Бладшот", actual[0].getFilmName());
        Assertions.assertEquals("Вперёд",actual[1].getFilmName());
        Assertions.assertEquals("Отель 'Белград'", actual[2].getFilmName());
        Assertions.assertEquals("Джентельмены", actual[3].getFilmName());
        Assertions.assertEquals("Человек-невидимка", actual[4].getFilmName());
        Assertions.assertEquals("Тролли. Мировой тур", actual[5].getFilmName());
        Assertions.assertEquals("Номер один", actual[6].getFilmName());
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
        repo.findByLast(5);

        FilmsInPlaybill[] expected = {film7, film6, film5, film4, film3};
        FilmsInPlaybill[] actual = repo.findByLast(5);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastShouldReturnLastAddedFilmsInReverseOrderWithSmallerLimit() {
        repo.add(film1);
        repo.add(film2);
        repo.add(film3);
        repo.add(film4);
        repo.add(film5);
        repo.add(film6);
        repo.add(film7);
        repo.findByLast(3);

        FilmsInPlaybill[] expected = {film7, film6, film5};
        FilmsInPlaybill[] actual = repo.findByLast(3);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastShouldReturnLastAddedFilmsInReverseOrderWithLargerLimit() {
        repo.add(film1);
        repo.add(film2);
        repo.add(film3);
        repo.add(film4);
        repo.add(film5);
        repo.add(film6);
        repo.add(film7);
        repo.findByLast(7);

        FilmsInPlaybill[] expected = {film7, film6, film5, film4, film3, film2, film1};
        FilmsInPlaybill[] actual = repo.findByLast(7);

        Assertions.assertArrayEquals(expected, actual);
    }
}
