package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private AtomicInteger COUNTER2 = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), COUNTER2.incrementAndGet(), TipoEndereco.RESIDENCIAL,"Rua Amazonas ",15 ,"1º andar","417205140","Salvador","BA", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), COUNTER2.incrementAndGet(), TipoEndereco.RESIDENCIAL,"Rua do sossego",11 ,"fundo","41205020","Salvador","BA", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), COUNTER2.incrementAndGet(), TipoEndereco.RESIDENCIAL,"Rua julio cesar",17 ,"terreo","41705240","Salvador","BA", "Brasil"));
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public Endereco create( Integer IdPessoa,Endereco endereco) {
        endereco.setIdPessoa(IdPessoa);
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtual) throws Exception {
        Endereco enderecoSearch = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não  foi encontrado"));
        enderecoSearch.setIdPessoa(enderecoAtual.getIdPessoa());
        enderecoSearch.setTipo(enderecoAtual.getTipo());
        enderecoSearch.setLogradouro(enderecoAtual.getLogradouro());
        enderecoSearch.setNumero(enderecoAtual.getNumero());
        enderecoSearch.setComplemento(enderecoAtual.getComplemento());
        enderecoSearch.setCep(enderecoAtual.getCep());
        enderecoSearch.setCidade(enderecoAtual.getCidade());
        enderecoSearch.setEstado(enderecoAtual.getEstado());
        enderecoSearch.setPais(enderecoAtual.getPais());
        return enderecoSearch;
    }

    public void delete(Integer idEndereco) throws Exception {
        Endereco enderecobackup = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não localizado"));
        listaEnderecos.remove(enderecobackup);
    }

}