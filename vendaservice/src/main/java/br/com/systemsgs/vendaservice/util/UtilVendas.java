package br.com.systemsgs.vendaservice.util;

import br.com.systemsgs.vendaservice.exception.errors.VendaNaoEncontradaException;
import br.com.systemsgs.vendaservice.model.ModelVendas;
import br.com.systemsgs.vendaservice.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class UtilVendas {

    private final VendasRepository vendasRepository;

    @Autowired
    public UtilVendas(VendasRepository vendasRepository) {
        this.vendasRepository = vendasRepository;
    }

    public ModelVendas pesquisarVendaPeloId(Long id){
        return vendasRepository.findById(id).orElseThrow(() -> new VendaNaoEncontradaException());
    }

    public Optional<BigDecimal> calculaTotalVendas(){
       return vendasRepository.calculaTotalVendasTodoPeriodo();
    }

    public Optional<Integer> somaTotalItensVendidosTodoPeriodo(){
        return vendasRepository.calculaTotalItensVendidosTodoPeriodo();
    }
}
