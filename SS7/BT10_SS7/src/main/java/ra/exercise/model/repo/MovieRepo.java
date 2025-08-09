package ra.exercise.model.repo;
import ra.exercise.model.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepo {
    List<Movie> findAll();

    boolean save (Movie movie);

    boolean update (Movie movie);

    boolean delete (Integer id);

    Optional<Movie> findById (Integer id);

}
