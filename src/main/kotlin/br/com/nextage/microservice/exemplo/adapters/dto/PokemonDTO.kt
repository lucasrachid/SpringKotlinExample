package br.com.nextage.microservice.exemplo.adapters.dto

import br.com.nextage.microservice.exemplo.adapters.model.PokemonEntity
import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonDTO(
        var id: Long? = null,
        var name: String? = null,
        @field:JsonProperty(value = "is_default")
        var is_default: Boolean? = null,
        var order: Int? = null,
        var base_experience: Int? = null,
        var height: Double? = null,
        var weight: Double? = null,
        var location_area_encounters: String? = null,
        var types: List<TypesDTO>? = null,
        var abilities: List<AbilitiesDTO>? = null,
        var forms: List<FormsDTO>? = null,
        var game_indices: List<GameIndicesDTO>? = null
) {

}

data class TypesDTO(
    var slot: Int? = null,
    var type: TypeDTO? = null
){

}

data class TypeDTO(
    var name: String? = null,
    var url: String? = null
    ){

}

data class AbilitiesDTO(
    var ability: AbilityDTO? = null,
    @field:JsonProperty(value = "is_hidden")
    var is_hidden: Boolean? = null,
    var slot: Int? = null
){

}

data class AbilityDTO(
    var name: String? = null,
    var url: String? = null
){

}

data class FormsDTO(
    var name: String? = null,
    var url: String? = null
){

}

data class GameIndicesDTO(
    var game_index: Int? = null,
    var version: VersionDTO? = null
){

}

data class VersionDTO(
    var name: String? = null,
    var url: String? = null
){

}

