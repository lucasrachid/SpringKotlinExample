package br.com.nextage.microservice.exemplo.adapters.dto

data class CharacterDTO(
        var userId: Long? = null,
        var id: Long? = null,
        var title: String? = null,
        var body: String? = null
)
