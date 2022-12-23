package br.com.nextage.microservice.exemplo.adapters.service

import br.com.nextage.microservice.exemplo.adapters.dto.CharacterDTO
import br.com.nextage.microservice.exemplo.adapters.dto.PokemonDTO
import br.com.nextage.microservice.exemplo.adapters.repository.PokemonRepository
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.io.IOException

@Service
class PokemonServiceImpl(
    val webClient: WebClient
    ): PokemonService {

    @Autowired
    private lateinit var pokemonRepository: PokemonRepository;

    @Value("\${micro-service.pokemon.url}")
    private val url: String? = null

    private val pathTest: String = "posts"

    private val client = OkHttpClient();

    override fun searchPokemonById(id: Long): PokemonDTO? {
        val result = webClient
            .get()
            .uri(
                UriComponentsBuilder
                    .fromHttpUrl("https://pokeapi.co/api/v2/pokemon/${id}")
                    .build()
                    .toUri())
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
            .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
            .toEntity<PokemonDTO>()
            .block()
        return result?.body!!

    }

}
