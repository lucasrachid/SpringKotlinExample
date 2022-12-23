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

    @GetMapping(value = ["/v1/{idPokemon}/"])
    fun searchPokemonById(@PathVariable("idPokemon") id: Long): ResponseEntity<PokemonDTO?> {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.searchPokemonById(id))
    }
}