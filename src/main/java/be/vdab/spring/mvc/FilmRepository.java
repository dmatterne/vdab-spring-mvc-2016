package be.vdab.spring.mvc;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stannisbaratheon on 02/09/16.
 */
public interface FilmRepository  extends JpaRepository<Film, Integer> {
}
