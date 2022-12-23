package br.com.nextage.microservice.exemplo.adapters.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "contato")
class ContatoEntity(

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "numero_telefone")
        var numeroTelefone: String? = null,

        @Column(name = "numero_celular")
        var numeroCelular: String? = null,

        @Column(name = "possui_whats_app")
        var possuiWhatsApp: Boolean? = false,

        @Column(name = "email")
        var email: String? = null,

        ) : Serializable





