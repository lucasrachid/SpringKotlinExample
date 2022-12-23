package br.com.nextage.microservice.exemplo.adapters.repository

import br.com.nextage.microservice.exemplo.adapters.model.ContatoEntity
import br.com.nextage.microservice.exemplo.adapters.model.PessoaEntity
import br.com.nextage.microservice.exemplo.adapters.model.PokemonEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository : JpaRepository<PokemonEntity, Long> {

    fun findAll(spec: Specification<PokemonEntity?>?, page: Pageable?): Page<PokemonEntity>


}