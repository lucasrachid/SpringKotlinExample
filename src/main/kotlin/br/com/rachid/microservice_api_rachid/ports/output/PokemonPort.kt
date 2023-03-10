package br.com.rachid.microservice_api_rachid.ports.output

import br.com.rachid.microservice_api_rachid.adapters.dto.PokemonDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PokemonPort {

    fun searchPokemonById(id: Long): PokemonDTO?

    fun insertPokemonById(id: Long): PokemonDTO?

    fun deleteById(id: Long): String

    fun searchPokemonList(pageable: Pageable): Page<PokemonDTO>

    fun searchAndSavePokeImg(): String
}
