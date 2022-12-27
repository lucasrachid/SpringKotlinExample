package br.com.nextage.microservice.exemplo.adapters.service

import br.com.nextage.microservice.exemplo.adapters.dto.PokemonDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PokemonService {

    fun searchPokemonById(id: Long): PokemonDTO?

    fun insertPokemonById(id: Long): PokemonDTO?

    fun deleteById(id: Long): String

    fun searchPokemonList(pageable: Pageable): Page<PokemonDTO>

}
