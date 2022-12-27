package br.com.rachid.microservice_api_rachid.adapters.service

import br.com.rachid.microservice_api_rachid.adapters.dto.PokemonDTO
import br.com.rachid.microservice_api_rachid.adapters.model.PokemonEntity
import br.com.rachid.microservice_api_rachid.adapters.repository.PokemonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono

@Service
class PokemonServiceImpl(
    val webClient: WebClient
) : PokemonService {

    @Autowired
    private lateinit var pokemonRepository: PokemonRepository;

    override fun searchPokemonById(id: Long): PokemonDTO? {
        val result = webClient
            .get()
            .uri(
                UriComponentsBuilder
                    .fromHttpUrl("https://pokeapi.co/api/v2/pokemon/${id}")
                    .build()
                    .toUri()
            )
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
            .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
            .toEntity<PokemonDTO>()
            .block()
        return result?.body!!
    }

    override fun insertPokemonById(id: Long): PokemonDTO? {
        var pokemonEntityList: ArrayList<PokemonEntity> = arrayListOf()
        var pokemonDTO: PokemonDTO? = null
        for (i in 1..905) {
            try {
                var buscaPokemonDTO = pokemonRepository.findById(i.toLong());
                if (buscaPokemonDTO.isEmpty) {
                    pokemonDTO = searchPokemonById(i.toLong());
                    var pokemonEntity = PokemonEntity();
                    pokemonEntity.id = pokemonDTO?.id
                    pokemonEntity.nome = pokemonDTO?.name
                    pokemonEntity.ordem = pokemonDTO?.order
                    pokemonEntity.altura = pokemonDTO?.height
                    pokemonEntity.peso = pokemonDTO?.weight
                    pokemonEntity.experiencia_base = pokemonDTO?.base_experience
                    pokemonEntity.local_para_encontrar = pokemonDTO?.location_area_encounters
                    pokemonEntity.padrao = pokemonDTO?.is_default
                    pokemonEntityList.add(pokemonEntity)
                }
            } catch (e: Exception) {
                e.stackTrace;
            }
        }

        pokemonRepository.saveAll(pokemonEntityList);
        return null;
    }

    override fun deleteById(id: Long): String {
        try {
            var pokemonToDelete = pokemonRepository.findById(id)
            if (!pokemonToDelete.isEmpty) {
                pokemonRepository.deleteById(id)
            }
        } catch (e: Exception) {
            e.stackTrace
            return "Pokemon não foi excluído, processo com erro!"
        }
        return "Pokemon excluído com sucesso!"
    }

    override fun searchPokemonList(pageable: Pageable): Page<PokemonDTO> {
        return pokemonRepository.findAll(null, pageable).map { PokemonDTO(it) };
    }

}
