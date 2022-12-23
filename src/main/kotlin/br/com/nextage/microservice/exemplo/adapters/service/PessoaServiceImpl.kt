package br.com.nextage.microservice.exemplo.adapters.service

import br.com.nextage.microservice.exemplo.adapters.dto.PessoaDTO
import br.com.nextage.microservice.exemplo.adapters.model.PessoaEntity
import br.com.nextage.microservice.exemplo.adapters.repository.ContatoRepository
import br.com.nextage.microservice.exemplo.adapters.repository.PessoaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PessoaServiceImpl: PessoaService {

    @Autowired
    private lateinit var pessoaRepository: PessoaRepository

    @Autowired
    private lateinit var contatoRepository: ContatoRepository

    override fun save(pessoaEntity: PessoaEntity): PessoaDTO? {
        contatoRepository.findByIdOrNull(pessoaEntity.contato?.id).let {
            if (it !== null && it.id != null) {
                pessoaEntity.contato = it
            }
        }
        return PessoaDTO(pessoaRepository.save(pessoaEntity))
    }

    override fun findById(id: Long): PessoaDTO? {
        return PessoaDTO(pessoaRepository.findByIdOrNull(id))
    }

    override fun deleteById(id: Long) {
        pessoaRepository.deleteById(id)
    }

    override fun findAllFields(search: String?, page: Pageable?): Page<PessoaDTO> {
        return pessoaRepository.findAllFields(search, page).map { PessoaDTO(it) }
    }

    override fun findAll(page: Pageable?): Page<PessoaDTO> {
        return pessoaRepository.findAll(null, page).map { PessoaDTO(it) }
    }
}
