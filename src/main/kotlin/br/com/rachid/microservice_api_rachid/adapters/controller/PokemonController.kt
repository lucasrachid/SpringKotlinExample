package br.com.rachid.microservice_api_rachid.adapters.controller

import br.com.rachid.microservice_api_rachid.adapters.dto.PokemonDTO
import br.com.rachid.microservice_api_rachid.adapters.service.PokemonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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

    @DeleteMapping(value = ["/v1/deletePokemonById/{id}"])
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteById(@PathVariable("id") id: Long): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.deleteById(id))
    }

    @GetMapping(value = ["/v1/buscaPaginada"])
    fun list(@RequestParam search: String?, page: Pageable): Page<PokemonDTO> {
       return pokemonService.searchPokemonList(page)
    }
}
