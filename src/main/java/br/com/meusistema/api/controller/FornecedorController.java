package br.com.meusistema.api.controller;

import br.com.meusistema.api.model.Fornecedor;
import br.com.meusistema.api.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @PostMapping // Fazendo o POST (REQUISIÇÃO - REQUEST)
    @ResponseStatus(HttpStatus.CREATED) // Toda REQUEST tem sua RESPONSE (Retorna 201 Created)
    public void criarFornecedor(@RequestBody Fornecedor fornecedor) {
        fornecedorService.criarFornecedor(fornecedor);
    }
}