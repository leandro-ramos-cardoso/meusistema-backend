package br.com.meusistema.api.service;

import br.com.meusistema.api.model.Fornecedor;
import br.com.meusistema.api.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FornecedorService {
    // Injeção de Dependencia do Repository no Service
    private final FornecedorRepository fornecedorRepository;

    public void criarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarTodosFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void deletarFornecedorPorId(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public void atualizarFornecedorPorId(Long id, Fornecedor fornecedor) {
        Optional<Fornecedor> fornecedorDoBancoDeDados = buscarFornecedorPorId(id);

        if(fornecedorDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado!");
        }

        Fornecedor fornecedorSobrescrito = fornecedorDoBancoDeDados.get();

        fornecedorSobrescrito.setNomeFantasia(fornecedor.getNomeFantasia());
        fornecedorSobrescrito.setEmail(fornecedor.getEmail());
        fornecedorSobrescrito.setTipoFornecedor(fornecedor.getTipoFornecedor());

        fornecedorRepository.save(fornecedorSobrescrito);
    }
}
