package br.com.nextage.microservice.exemplo.adapters.model

import org.springframework.data.jpa.repository.Temporal

import java.io.Serializable

import java.util.*

import javax.persistence.*

@Entity
@Table(name = "pessoa")
class PessoaEntity(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "nome")
        var nome: String? = null,

        @Column(name = "nome_pai")
        var nomePai: String? = null,

        @Column(name = "nome_mae")
        var nomeMae: String? = null,

        @Column(name = "cpf")
        var cpf: String? = null,

        @Column(name = "data_nascimento")
        @Temporal(TemporalType.TIMESTAMP)
        var dataNascimento: Date? = null,

        @OneToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name = "contato_id", referencedColumnName = "id")
        var contato: ContatoEntity? = null

): Serializable
