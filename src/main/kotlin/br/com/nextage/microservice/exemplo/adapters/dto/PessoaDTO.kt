package br.com.nextage.microservice.exemplo.adapters.dto

import br.com.nextage.microservice.exemplo.adapters.model.PessoaEntity
import java.util.*

data class PessoaDTO(
        var id: Long? = null,
        var nome: String? = null,
        var nomePai: String? = null,
        var nomeMae: String? = null,
        var cpf: String? = null,
        var dataNascimento: Date? = null,
        var contato: ContatoDTO? = null
) {
    constructor(pessoaEntity: PessoaEntity?) : this() {
        this.id = pessoaEntity?.id
        this.nome = pessoaEntity?.nome
        this.nomePai = pessoaEntity?.nomePai
        this.nomeMae = pessoaEntity?.nomeMae
        this.cpf = pessoaEntity?.cpf
        this.dataNascimento = pessoaEntity?.dataNascimento
        this.contato = ContatoDTO(pessoaEntity?.contato)
    }

    fun toEntity(): PessoaEntity {
        return PessoaEntity(
                this.id,
                this.nome,
                this.nomePai,
                this.nomeMae,
                this.cpf,
                this.dataNascimento,
                this.contato?.toEntity()
        )
    }
}

