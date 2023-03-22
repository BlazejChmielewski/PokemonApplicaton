package pl.chmielewski.Pokedex;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.chmielewski.Pokedex.model.Pokemon;
import pl.chmielewski.Pokedex.service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonResource {
    private final PokemonService pokemonService;

    public PokemonResource(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        List<Pokemon> pokemonList = pokemonService.findAllPokemon();
        return new ResponseEntity<>(pokemonList, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") Long id) {
        Pokemon pokemon = pokemonService.findPokemonById(id);
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon pokemon) {
        Pokemon newPokemon = pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(newPokemon, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon) {
        Pokemon updatePokemon = pokemonService.updatePokemon(pokemon);
        return new ResponseEntity<>(updatePokemon, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePokemon(@PathVariable("id") Long id) {
        pokemonService.deletePokemon(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
