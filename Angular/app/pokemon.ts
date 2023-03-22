export interface Pokemon{
  id: number;
  imageUrl: string;
  name: string;

  firstType: string;
  secondType: string;

  hp: number;
  attack: number;
  defence: number;
  spAttack: number;
  spDefense: number;
  speed: number;

  pokemonCode: string;
}
