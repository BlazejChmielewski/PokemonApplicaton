package pl.chmielewski.Pokedex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.chmielewski.Pokedex.exception.PokemonNotFoundException;
import pl.chmielewski.Pokedex.model.Pokemon;
import pl.chmielewski.Pokedex.repository.PokemonRepo;

import java.util.List;
import java.util.UUID;

@Service
public class PokemonService {
    private final PokemonRepo pokemonRepo;

    @Autowired
    public PokemonService(PokemonRepo pokemonRepo) {
        this.pokemonRepo = pokemonRepo;
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        pokemon.setPokemonCode(UUID.randomUUID().toString());
        return pokemonRepo.save(pokemon);
    }

    public List<Pokemon> findAllPokemon() {
        return pokemonRepo.findAll();
    }

    public Pokemon updatePokemon(Pokemon pokemon) {
        return pokemonRepo.save(pokemon);
    }

    public Pokemon findPokemonById(Long id) {
        return pokemonRepo.findPokemonById(id).
                orElseThrow(() -> new PokemonNotFoundException("Pokemon by id" + id + " was not found"));
    }

    public void deletePokemon(Long id) {
        pokemonRepo.deletePokemonById(id);
    }
}
