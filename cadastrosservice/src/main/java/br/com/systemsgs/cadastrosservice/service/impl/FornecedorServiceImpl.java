package br.com.systemsgs.cadastrosservice.service.impl;

import br.com.systemsgs.cadastrosservice.repository.FornecedoresRepository;
import br.com.systemsgs.cadastrosservice.util.UtilFornecedores;
import br.com.systemsgs.cadastrosservice.dto.request.ModelFornecedorDTO;
import br.com.systemsgs.cadastrosservice.exception.erros.FornecedorNaoEncontradoException;
import br.com.systemsgs.cadastrosservice.model.ModelFornecedor;
import br.com.systemsgs.cadastrosservice.service.FornecedorService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    private final FornecedoresRepository fornecedoresRepository;
    private final UtilFornecedores utilFornecedores;
    private final ModelMapper mapper;

    @Autowired
    public FornecedorServiceImpl(FornecedoresRepository fornecedoresRepository,
                                 UtilFornecedores utilFornecedores,
                                 ModelMapper mapper) {
        this.fornecedoresRepository = fornecedoresRepository;
        this.utilFornecedores = utilFornecedores;
        this.mapper = mapper;
    }

    @Override
    public ModelFornecedor pesquisaPorId(Long id) {
        return fornecedoresRepository.findById(id).orElseThrow(() -> new FornecedorNaoEncontradoException());
    }

    @Override
    public List<ModelFornecedor> listarFornecedores() {
        return fornecedoresRepository.findAll();
    }

    @Override
    public Page<ModelFornecedorDTO> listarFornecedoresPaginados(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return fornecedoresRepository.findAll(pageable).map(fornecedores -> mapper.map(fornecedores, ModelFornecedorDTO.class));
    }

    @Transactional
    @Override
    public ModelFornecedor salvarFornecedor(ModelFornecedorDTO modelFornecedorDTO) {
        return fornecedoresRepository.save(mapper.map(modelFornecedorDTO, ModelFornecedor.class));
    }

    @Override
    public void deletarFornecedor(Long id) {
        fornecedoresRepository.deleteById(id);
    }

    @Override
    public ModelFornecedor updateFornecedor(Long id, ModelFornecedorDTO modelFornecedorDTO) {
        ModelFornecedor fornecedorPesquisado = utilFornecedores.pesquisarFornecedorPeloId(id);
        mapper.map(modelFornecedorDTO, ModelFornecedor.class);
        BeanUtils.copyProperties(modelFornecedorDTO, fornecedorPesquisado, "id");

        return fornecedoresRepository.save(fornecedorPesquisado);
    }
}
