package br.com.builder.apicliente.controller;

import br.com.builder.apicliente.dto.ClienteRequest;
import br.com.builder.apicliente.dto.ClienteResponse;
import br.com.builder.apicliente.exception.NegocioException;
import br.com.builder.apicliente.service.ClienteService;
import br.com.builder.apicliente.util.PageableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponse> save(@Valid @RequestBody ClienteRequest clienteRequest) {
        Optional<ClienteResponse> response = service.save(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ClienteRequest clienteRequest) {
        Optional<ClienteResponse> response = service.update(id, clienteRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ClienteResponse>> findAllPageable(
            @RequestParam Integer page,
            @RequestParam Integer size) throws NegocioException {
        Pageable pageable = PageableUtil.getPageableParams(page, size);
        Page response = service.findAllPageable(pageable);
        return response != null && response.getTotalElements() > 0 ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(response)
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/ByParameter")
    public ResponseEntity<List<ClienteResponse>> findWithParams(
            @RequestParam(required=false) String nome,
            @RequestParam(required=false) String cpfCnpj,
            @RequestParam(required=false) String dataNascimento,
            @RequestParam(required=false) Boolean ativo) throws NegocioException {
        List<ClienteResponse> clienteResponses = service.findWithParams(nome, cpfCnpj, dataNascimento, ativo);
        return !clienteResponses.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(clienteResponses)
                : ResponseEntity.noContent().build();
    }
}
