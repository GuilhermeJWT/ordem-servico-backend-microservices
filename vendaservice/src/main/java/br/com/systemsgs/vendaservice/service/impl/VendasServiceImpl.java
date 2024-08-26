package br.com.systemsgs.vendaservice.service.impl;

import br.com.systemsgs.vendaservice.dto.request.ModelVendasDTO;
import br.com.systemsgs.vendaservice.dto.response.VendasResponse;
import br.com.systemsgs.vendaservice.model.*;
import br.com.systemsgs.vendaservice.repository.VendasRepository;
import br.com.systemsgs.vendaservice.service.VendaService;
import br.com.systemsgs.vendaservice.util.UtilClientes;
import br.com.systemsgs.vendaservice.util.UtilProdutos;
import br.com.systemsgs.vendaservice.util.UtilTecnicoResponsavel;
import br.com.systemsgs.vendaservice.util.UtilVendas;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendasServiceImpl implements VendaService {

    private final VendasRepository vendasRepository;
    private final UtilVendas utilVendas;
    private final UtilTecnicoResponsavel utilTecnicoResponsavel;
    private final UtilClientes utilClientes;
    private final UtilProdutos utilProdutos;

    @Autowired
    public VendasServiceImpl(VendasRepository vendasRepository, UtilVendas utilVendas, UtilTecnicoResponsavel utilTecnicoResponsavel,
                             UtilClientes utilClientes,
                             UtilProdutos utilProdutos) {
        this.vendasRepository = vendasRepository;
        this.utilVendas = utilVendas;
        this.utilTecnicoResponsavel = utilTecnicoResponsavel;
        this.utilClientes = utilClientes;
        this.utilProdutos = utilProdutos;
    }

    @Transactional
    @Override
    public ModelVendas salvarVenda(ModelVendasDTO modelVendasDTO) {
        ModelVendas modelVendas = new ModelVendas();
        ModelItensVendas modelItensVendas = new ModelItensVendas();

        var cliente = utilClientes.pesquisarClientePeloId(modelVendasDTO.getIdCliente());
        var tecnico = utilTecnicoResponsavel.pesquisarTecnicoPeloId(modelVendasDTO.getIdTecnicoResponsavel());
        var ids = modelVendasDTO.getItens().stream().map(p -> p.getId_produto()).collect(Collectors.toList());
        var produtos = utilProdutos.pesquisaListaProdutosPorIds(ids);

        setDadosVendas(modelVendasDTO, modelVendas, cliente, tecnico, modelItensVendas, produtos);

        var vendaSalva = vendasRepository.save(modelVendas);
        utilProdutos.baixaEstoqueProdutos(modelVendasDTO);

        return vendaSalva;
    }

    @Override
    public VendasResponse pesquisaVendaPorId(Long id) {
        VendasResponse vendasResponse = new VendasResponse();

        var pesquisaVenda = utilVendas.pesquisarVendaPeloId(id);

        vendasResponse.setIdVenda(pesquisaVenda.getIdVenda());
        vendasResponse.setTotalItens(pesquisaVenda.getTotalItens());
        vendasResponse.setTotalVenda(pesquisaVenda.getTotalVenda());
        vendasResponse.setDataVenda(pesquisaVenda.getDataVenda());
        vendasResponse.setDesconto(pesquisaVenda.getDesconto());
        vendasResponse.setNomeCliente(pesquisaVenda.getCliente().getNome());
        vendasResponse.setNomeTecnicoResponsavel(pesquisaVenda.getTecnicoResponsavel().getNome());
        vendasResponse.setDescricaoProdutos(pegaDescricaoPedidos(pesquisaVenda));

        return vendasResponse;
    }

    private void setDadosVendas(ModelVendasDTO modelVendasDTO, ModelVendas modelVendas, ModelClientes cliente, ModelTecnicoResponsavel tecnico,
                                ModelItensVendas modelItensVendas, List<ModelProdutos> produtos) {
        modelVendas.setCliente(cliente);
        modelVendas.setTecnicoResponsavel(tecnico);
        modelVendas.setDesconto(modelVendasDTO.getDesconto());
        modelVendas.setTotalVenda(calculaTotalVenda(modelVendasDTO));
        modelVendas.setTotalItens(calculaTotalItens(modelVendasDTO));
        modelVendas.setItens(itensVenda(modelVendasDTO));
        modelItensVendas.setProduto(produtos.stream().map(p -> p.getId()).collect(Collectors.toList()));
        modelItensVendas.setQuantidade(produtos.stream().map(p -> p.getQuantidade()).collect(Collectors.toList()));
        modelItensVendas.setValorProduto(produtos.stream().map(p -> p.getPreco_venda()).collect(Collectors.toList()));
    }

    private BigDecimal calculaTotalVenda(ModelVendasDTO modelVendasDTO) {
        return modelVendasDTO.getItens().stream().
                map(itens -> itens.getValorProduto().multiply(BigDecimal.valueOf(itens.getQuantidade())))
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    private Integer calculaTotalItens(ModelVendasDTO modelVendasDTO) {
        return modelVendasDTO.getItens().stream().mapToInt(p -> p.getQuantidade()).sum();
    }

    private List<ModelItensVendas> itensVenda(ModelVendasDTO modelVendasDTO){
        var quantidade = modelVendasDTO.getItens().stream().map(q -> q.getQuantidade()).collect(Collectors.toList());
        var valorProduto = modelVendasDTO.getItens().stream().map(v -> v.getValorProduto()).collect(Collectors.toList());
        var produto = modelVendasDTO.getItens().stream().map(p -> p.getId_produto()).collect(Collectors.toList());

        List<Long> listaIds = produto;
        List<ModelItensVendas> itensVendas = Arrays.asList(new ModelItensVendas(quantidade, valorProduto, listaIds));

        return itensVendas;
    }

    private List<String> pegaDescricaoPedidos(ModelVendas modelVendas){
        var idsProdutos = modelVendas.getItens().stream().map(p -> p.getProduto());
        List<Long> listIds = idsProdutos.reduce(new ArrayList<>() , (integer, longs) -> longs);

        return utilProdutos.pesquisaDescricaoProdutosPorIds(listIds);
    }
}
