package br.com.nextage.microservice.exemplo.adapters.controller

import br.com.nextage.microservice.exemplo.adapters.dto.ContatoDTO
import br.com.nextage.microservice.exemplo.adapters.service.ContatoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contato")
class ContatoController {

    @Autowired
    private lateinit var contatoService: ContatoService

    @PostMapping(value = ["/v1/"])
    fun save(@RequestBody contatoDTO: ContatoDTO): ResponseEntity<ContatoDTO?> {
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contatoDTO.toEntity()))
    }

    @GetMapping(value = ["/v1/{id}/"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<ContatoDTO?> {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findById(id))
    }

    @DeleteMapping(value = ["/v1/{id}/"])
    @ResponseStatus(value = HttpStatus.OK)
    fun deleteById(@PathVariable("id") id: Long) {
        contatoService.deleteById(id)
    }

    @GetMapping(value = ["/v1/"])
    fun list(@RequestParam search: String?, page: Pageable?): Page<ContatoDTO> {
        return if (search?.isNotBlank() == true)
            contatoService.findAllFields(search, page)
        else
            contatoService.findAll(page)
    }
}
