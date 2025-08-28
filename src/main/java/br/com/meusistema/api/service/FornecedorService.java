package br.com.meusistema.api.service;

import br.com.meusistema.api.model.Fornecedor;
import br.com.meusistema.api.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FornecedorService {
    // Injeção de Dependencia do Repository no Service
    private final FornecedorRepository fornecedorRepository;

    public void criarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }
}
