package br.com.nextage.microservice.exemplo.adapters.service

import br.com.nextage.microservice.exemplo.adapters.dto.PokemonDTO

interface PokemonService {

    fun searchPokemonById(id: Long): PokemonDTO?;

}
