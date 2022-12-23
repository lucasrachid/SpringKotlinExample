package br.com.nextage.microservice.exemplo.adapters.dto

import br.com.nextage.microservice.exemplo.adapters.model.ContatoEntity

data class ContatoDTO(
        var id: Long? = null,
        var numeroTelefone: String? = null,
        var numeroCelular: String? = null,
        var possuiWhatsApp: Boolean? = false,
        var email: String? = null
) {
    constructor(contatoEntity: ContatoEntity?): this() {
        this.id = contatoEntity?.id
        this.numeroTelefone = contatoEntity?.numeroTelefone
        this.numeroCelular = contatoEntity?.numeroCelular
        this.possuiWhatsApp = contatoEntity?.possuiWhatsApp
        this.email = contatoEntity?.email

    }

    fun toEntity(): ContatoEntity {
        return ContatoEntity(
                this.id,
                this.numeroTelefone,
                this.numeroCelular,
                this.possuiWhatsApp,
                this.email

        )
    }
}
