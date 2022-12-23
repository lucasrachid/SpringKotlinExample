package br.com.nextage.microservice.exemplo.adapters.service

import br.com.nextage.microservice.exemplo.adapters.dto.ContatoDTO
import br.com.nextage.microservice.exemplo.adapters.model.ContatoEntity
import br.com.nextage.microservice.exemplo.adapters.repository.ContatoRepository
import br.com.nextage.microservice.exemplo.adapters.repository.PessoaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ContatoServiceImpl :ContatoService {

    @Autowired
    private lateinit var contatoRepository: ContatoRepository

    @Autowired
    private lateinit var pessoaRepository: PessoaRepository

    override fun save(contatoEntity: ContatoEntity): ContatoDTO {
        return ContatoDTO((contatoRepository.save(contatoEntity)))
    }

    override fun findById(id: Long?): ContatoDTO? {
        return ContatoDTO((contatoRepository.findByIdOrNull(id)))
    }

    override fun deleteById(id: Long) {
        pessoaRepository.findByContato(ContatoEntity(id)).let {
            if (it !== null && it.id !== null) {
                it.contato = null
                pessoaRepository.save(it)
            }
        }
        contatoRepository.deleteById(id)
    }

    override fun findAllFields(search: String?, page: Pageable?): Page<ContatoDTO> {
        return contatoRepository.findAllFields(search, page).map { ContatoDTO(it) }
    }

    override fun findAll(page: Pageable?): Page<ContatoDTO> {
        return contatoRepository.findAll(null, page).map { ContatoDTO(it) }
    }
}
