import { Component, OnInit } from '@angular/core';
import { Pokemon } from './pokemon';
import { PokemonService } from './pokemon.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public pokemons: Pokemon[] | any;

  constructor(private pokemonService: PokemonService) {}

  ngOnInit(){
      this.getPokemon();
  }
  public getPokemon():void{
    this.pokemonService.getPokemon().subscribe(
      (response: Pokemon[]) =>{
        this.pokemons = response;
      },
      (error:HttpErrorResponse) => {
        alert(error.message);
      }
      );
  }
}
