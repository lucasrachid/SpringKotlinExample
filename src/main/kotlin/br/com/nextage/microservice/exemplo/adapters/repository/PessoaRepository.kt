package br.com.nextage.microservice.exemplo.adapters.repository

import br.com.nextage.microservice.exemplo.adapters.model.ContatoEntity
import br.com.nextage.microservice.exemplo.adapters.model.PessoaEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository : JpaRepository<PessoaEntity, Long> {

    fun findAll(spec: Specification<PessoaEntity?>?, page: Pageable?): Page<PessoaEntity>

    @Query(
            """
            SELECT u FROM PessoaEntity u WHERE
            (CAST(u.id as text) like upper(CONCAT('%',:search,'%')) 
            or upper(u.nome) like upper(CONCAT('%',:search,'%'))
            or upper(u.nomeMae) like upper(CONCAT('%',:search,'%'))
            or upper(u.cpf) like upper(CONCAT('%',:search,'%'))
            or upper(CAST(u.dataNascimento as text)) like upper(CONCAT('%',:search,'%')))
        """
    )
    fun findAllFields(@Param("search") search: String?, page: Pageable?): Page<PessoaEntity>

    fun findByContato(contato: ContatoEntity): PessoaEntity?

}
