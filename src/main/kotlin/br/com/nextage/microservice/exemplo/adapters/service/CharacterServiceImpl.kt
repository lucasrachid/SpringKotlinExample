package br.com.nextage.microservice.exemplo.adapters.service

import br.com.nextage.microservice.exemplo.adapters.dto.CharacterDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono

@Service
class CharacterServiceImpl (
        val webClient: WebClient
        ): CharacterService {

    @Value("\${micro-service.ms-character.url}")
    private val url: String? = null

    @Value("\${micro-service.ms-character.list}")
    private val metodList: String? = null

    private val urlTest: String = "https://jsonplaceholder.typicode.com/"
    private val pathTest: String = "posts"

    override fun listar(): List<CharacterDTO> {
       val result = webClient
                .get()
                .uri(
                        UriComponentsBuilder
                                .fromHttpUrl(urlTest)
                                .path(pathTest)
                                .build()
                                .toUri())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
                .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
                .toEntity<List<CharacterDTO>>()
                .block()
        return result?.body!!
    }
}
