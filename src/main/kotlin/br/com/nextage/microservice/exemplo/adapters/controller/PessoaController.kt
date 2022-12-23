package br.com.nextage.microservice.exemplo.adapters.controller

import br.com.nextage.microservice.exemplo.adapters.dto.PessoaDTO
import br.com.nextage.microservice.exemplo.adapters.service.PessoaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoa")
class PessoaController {

    @Autowired
    private lateinit var pessoaService: PessoaService

    @PostMapping(value = ["/v1/"])
    fun save(@RequestBody pessoaDTO: PessoaDTO): ResponseEntity<PessoaDTO?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaDTO.toEntity()))
    }

    @GetMapping(value = ["/v1/{id}/"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<PessoaDTO?> {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findById(id))
    }

    @DeleteMapping(value = ["/v1/{id}/"])
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteById(@PathVariable("id") id: Long) {
        pessoaService.deleteById(id)
    }

    @GetMapping(value = ["/v1/"])
    fun list(@RequestParam search: String?, page: Pageable?): Page<PessoaDTO> {
        return if (search?.isNotBlank() == true)
            pessoaService.findAllFields(search, page)
        else
            pessoaService.findAll(page)
    }
}
