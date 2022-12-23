package br.com.nextage.microservice.exemplo.adapters.dto

import org.springframework.http.HttpHeaders

open class ClientHeader(
    var codigoUsuario: String? = null,
    var nomeUsuario: String? = null,
    var nomeEmpresa: String? = null,
    var codigoEmpresa: Int? = null,
    var permissoes: List<Long> = listOf(),
    var token: String? = null
) {
    fun getCodigoEmpresaAsPermissoes(): List<Long> {
        return listOf((this.codigoEmpresa ?: 0).toLong())
    }

    fun toHeadersMap(): HashMap<String, String> {
        val map = HashMap<String, String>()
        map["codigo_usuario"] = this.codigoUsuario.toString()
        map[HttpHeaders.AUTHORIZATION] = this.token.toString()
        return map
    }
}

