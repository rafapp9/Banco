package com.banco.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banco.model.ContaAbstrata;
import com.banco.repository.ContaDAO;

public class ContaDAOImpl implements ContaDAO {
    private Map<String, ContaAbstrata> dataBase = new HashMap<>();

    @Override
    public void create(ContaAbstrata conta) {
        dataBase.put(conta.getId(), conta);
    }

    @Override
    //retorna uma lista de todas as contas convertendo os valores do map dataBase em uma lista.
    public List<ContaAbstrata> readAll() {
        return List.copyOf(dataBase.values());
    }

    @Override
    public ContaAbstrata update(String id, ContaAbstrata obj) {
        if (dataBase.containsKey(id)) {
            dataBase.put(id, obj);
        }
        return obj;
    }

    @Override
    public ContaAbstrata read(String id) {
        return dataBase.get(id);
    }

    @Override
    public void delete(String id) {
        dataBase.remove(id);
    }

    @Override
    public List<ContaAbstrata> readValor(double montanteFiltro) {
        List<ContaAbstrata> filtroValor = new ArrayList<>();
        for (ContaAbstrata conta : dataBase.values()) {
            if (conta.getMontanteConta() >= montanteFiltro) {
                filtroValor.add(conta);
            }
        }
        return filtroValor;
    }
}
