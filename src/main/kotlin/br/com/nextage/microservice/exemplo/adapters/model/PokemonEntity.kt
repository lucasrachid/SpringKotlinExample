package br.com.nextage.microservice.exemplo.adapters.model

import org.springframework.data.jpa.repository.Temporal

import java.io.Serializable

import java.util.*

import javax.persistence.*

@Entity
@Table(name = "pokemon")
class PokemonEntity(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "nome")
        var nome: String? = null,

        @Column(name = "padrao")
        var padrao: Boolean? = null,

        @Column(name = "ordem")
        var ordem: Int? = null,

        @Column(name = "experiencia_base")
        var experiencia_base: Int? = null,

        @Column(name = "altura")
        var altura: Double? = null,

        @Column(name = "peso")
        var peso: Double? = null,

        @Column(name = "local_para_encontrar")
        var local_para_encontrar: String? = null,

        ): Serializable