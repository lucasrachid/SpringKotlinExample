package br.com.rachid.microservice_api_rachid.adapters.repository

import br.com.rachid.microservice_api_rachid.adapters.dto.PokemonDTO
import br.com.rachid.microservice_api_rachid.adapters.model.PokemonEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository : JpaRepository<PokemonEntity, Long> {

    fun findAll(spec: Specification<PokemonEntity?>?, page: Pageable?): Page<PokemonEntity>
}
