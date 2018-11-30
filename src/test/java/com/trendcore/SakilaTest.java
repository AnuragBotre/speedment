package com.trendcore;

import com.company.sakila.SakilaApplication;
import com.company.sakila.SakilaApplicationBuilder;
import com.company.sakila.sakila.sakila.actor.Actor;
import com.company.sakila.sakila.sakila.actor.ActorManager;
import com.company.sakila.sakila.sakila.actor.ActorManagerImpl;
import com.company.sakila.sakila.sakila.film.Film;
import com.company.sakila.sakila.sakila.film.FilmManager;
import com.company.sakila.sakila.sakila.film_actor.FilmActor;
import com.company.sakila.sakila.sakila.film_actor.FilmActorImpl;
import com.company.sakila.sakila.sakila.film_actor.FilmActorManager;
import com.company.sakila.sakila.sakila.film_actor.FilmActorManagerImpl;
import com.speedment.runtime.core.ApplicationBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class SakilaTest {

    SakilaApplication app;

    @Before
    public void setUp() throws Exception {
        app = new SakilaApplicationBuilder()
                .withLogging(ApplicationBuilder.LogType.STREAM)
                .withUsername("anurag")
                .withPassword("anurag")
                .build();
    }

    @Test
    public void countingNoOfItemsInAStream() {
        FilmManager films = app.getOrThrow(FilmManager.class);

        long count = films.stream()
                .filter(Film.RATING.equal("PG-13"))
                .count();

        System.out.println(count);
    }

    @Test
    public void basicFilmLookUpViaPrimaryKey() {
        final int id = 1;

        FilmManager films = app.getOrThrow(FilmManager.class);

        final Optional<String> title = films.stream()
                .filter(Film.FILM_ID.equal(id))      // find the films we are looking for
                .map(Film.TITLE)                     // switch from a stream of films to one of titles
                .findAny();                          // we want the first and only match for this unique key

        if (title.isPresent()) {
            System.out.format("Film ID %d has title %s.", id, title.get());
        } else {
            System.out.format("Film ID not found.", id);
        }
    }

    @Test
    public void understandingStreamOptimization() {
        FilmManager films = app.getOrThrow(FilmManager.class);
        long count = films.stream()
                .filter(Film.RATING.equal("PG-13"))
                .filter(Film.LENGTH.greaterOrEqual(75))
                .map(Film.TITLE)
                .sorted()
                .count();

        System.out.printf("Found %d films", count);
    }

    @Test
    public void classifyingFilms() {
        FilmManager films = app.getOrThrow(FilmManager.class);
        films.stream()
                .collect(Collectors.groupingBy(Film.RATING,
                        Collectors.counting())).forEach(
                (rating, count) -> System.out.printf("There are %d %s rated films.%n", count, rating));
    }

    @Test
    public void filmLookUpViaActorName() {
        ActorManager actors = app.getOrThrow(ActorManagerImpl.class);
        FilmManager films = app.getOrThrow(FilmManager.class);
        FilmActorManager filmActors = app.getOrThrow(FilmActorManagerImpl.class);

        final String actorName = "CHASE";
        Set<Integer> selectedActorIds = actors.stream()
                .filter(Actor.LAST_NAME.equalIgnoreCase(actorName))
                .mapToInt(Actor.ACTOR_ID)                             // turning the stream into a stream of actor IDs
                .boxed()                                              // turning IntStream into Stream<Integer>
                .collect(toSet());

        if (selectedActorIds.isEmpty()) {
            System.out.println("No actor with last name " + actorName + " found.");
        } else {
            System.out.println("Films with actor with last name " + actorName + ":");
            filmActors.stream()
                    .filter(FilmActor.ACTOR_ID.in(selectedActorIds))
                    .map(films.finderBy(FilmActor.FILM_ID))  // the stream of films we are looking for
                    .map(Film.TITLE.getter())                // the stream of film titles
                    .sorted()
                    .forEach(title -> System.out.println(" " + title));
        }
    }
}
