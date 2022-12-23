package br.com.nextage.microservice.exemplo.adapters.repository

import br.com.nextage.microservice.exemplo.adapters.model.ContatoEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ContatoRepository : JpaRepository<ContatoEntity, Long> {

    fun findAll(spec: Specification<ContatoEntity?>?, page: Pageable?): Page<ContatoEntity>

    @Query(
            """
            SELECT u FROM ContatoEntity u WHERE
            (CAST(u.id as text) like upper(CONCAT('%',:search,'%')) 
            or upper(u.numeroTelefone) like upper(CONCAT('%',:search,'%'))
            or upper(u.numeroCelular) like upper(CONCAT('%',:search,'%'))
            or upper(CAST(u.possuiWhatsApp as text)) like upper(CONCAT('%',:search,'%'))
            or upper(u.email) like upper(CONCAT('%',:search,'%')))
        """
    )
    fun findAllFields(@Param("search") search: String?, page: Pageable?): Page<ContatoEntity>

}
