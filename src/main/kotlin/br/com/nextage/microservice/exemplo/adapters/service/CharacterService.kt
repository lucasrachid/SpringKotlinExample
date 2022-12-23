package br.com.nextage.microservice.exemplo.adapters.service

import br.com.nextage.microservice.exemplo.adapters.dto.CharacterDTO

interface CharacterService {

    fun listar(): List<CharacterDTO>
}
