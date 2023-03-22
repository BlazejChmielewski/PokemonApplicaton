package pl.chmielewski.Pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chmielewski.Pokedex.model.Pokemon;

import java.util.Optional;

public interface PokemonRepo extends JpaRepository<Pokemon, Long> {


    void deletePokemonById(Long id);

    Optional<Pokemon> findPokemonById(Long id);
}
