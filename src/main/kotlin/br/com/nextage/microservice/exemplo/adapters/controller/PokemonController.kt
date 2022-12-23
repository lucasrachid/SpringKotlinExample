package br.com.nextage.microservice.exemplo.adapters.controller

import br.com.nextage.microservice.exemplo.adapters.dto.PokemonDTO
import br.com.nextage.microservice.exemplo.adapters.service.PokemonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pokemon")
class PokemonController {

    @Autowired
    private lateinit var pokemonService: PokemonService

    @GetMapping(value = ["/v1/{idPokemon}"])
    fun searchPokemonById(@PathVariable("idPokemon") id: Long): ResponseEntity<PokemonDTO?> {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.searchPokemonById(id))
    }

    @PostMapping(value = ["/v1/insertPokemon"])
    fun insertPokemonById(@RequestBody id: Long): ResponseEntity<PokemonDTO?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.insertPokemonById(id))
    }

//    @DeleteMapping(value = ["/v1/{id}/"])
//    @ResponseStatus(value = HttpStatus.OK)
//    fun deleteById(@PathVariable("id") id: Long) {
//        pessoaService.deleteById(id)
//    }
}
