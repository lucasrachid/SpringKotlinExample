package br.com.rachid.microservice_api_rachid.adapters.outbound

import br.com.rachid.microservice_api_rachid.adapters.dto.PokemonDTO
import br.com.rachid.microservice_api_rachid.adapters.model.PokemonEntity
import br.com.rachid.microservice_api_rachid.adapters.repository.PokemonRepository
import br.com.rachid.microservice_api_rachid.ports.output.PokemonPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.io.*
import java.net.URL
import java.util.*
import javax.imageio.ImageIO


@Service
class PokemonAdapter(
    val webClient: WebClient
) : PokemonPort {

    @Autowired
    private lateinit var pokemonRepository: PokemonRepository

    @Value("\${micro-service.pokemon.url}")
    private val urlApi: String? = null

    @Value("\${micro-service.pokemon.urlImgStart}")
    private val urlImgStart: String? = null

    @Value("\${micro-service.pokemon.urlImgFinal}")
    private val urlImgFinal: String? = null

    override fun searchPokemonById(id: Long): PokemonDTO? {
        val result = webClient
            .get()
            .uri(
                UriComponentsBuilder
                    .fromHttpUrl(urlApi + "$id")
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
        val pokemonEntityList: ArrayList<PokemonEntity> = arrayListOf()
        var pokemonDTO: PokemonDTO?
        for (i in 1..905) {
            try {
                pokemonRepository.findById(i.toLong()).let {
                    pokemonDTO = searchPokemonById(i.toLong())
                    val pokemonEntity = PokemonEntity()
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
                e.stackTrace
            }
        }

        pokemonRepository.saveAll(pokemonEntityList)
        return null
    }

    override fun deleteById(id: Long): String {
        try {
            val pokemonToDelete = pokemonRepository.findById(id)
            if (!pokemonToDelete.isEmpty) {
                pokemonRepository.deleteById(id)
            }
        } catch (e: Exception) {
            e.stackTrace
            return "Pokemon não foi excluído, processo com erro!"
        }
        return "Pokemon excluído com sucesso!"
    }

    override fun searchPokemonList(pageable: Pageable) = pokemonRepository.findAll(null, pageable).map { PokemonDTO(it) }

    override fun searchAndSavePokeImg(): String {
        val pokemonEntityList: ArrayList<PokemonEntity>
        try {
            pokemonEntityList = pokemonRepository.findAll() as ArrayList<PokemonEntity>
            for (pokemon in pokemonEntityList) {
                val buscaPokemonDTO = pokemon.id?.let { pokemonRepository.findById(it) }
                if (buscaPokemonDTO != null && buscaPokemonDTO.isPresent) {
                    val numerousFormatted = "%03d".format(pokemon.id)
                    val imagemApi = getPokeImgApi(numerousFormatted)
                    buscaPokemonDTO.get().imagem_pokemon = imagemApi

                }
            }
            pokemonRepository.saveAll(pokemonEntityList)

        } catch (e: Exception) {
            e.stackTrace
            return "Processo com erro!"
        }
        return "Imagens salvas com sucesso!"
    }

    fun getPokeImgApi(numeroPoke: String): String {
        val url = URL(urlImgStart + numeroPoke + urlImgFinal)
        val bImage = ImageIO.read(url)
        val bos = ByteArrayOutputStream()
        ImageIO.write(bImage, "png", bos)
        val data = bos.toByteArray()
        return Base64.getEncoder().encodeToString(data)
    }

}
