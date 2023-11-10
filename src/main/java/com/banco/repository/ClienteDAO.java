package com.banco.repository;

import java.util.List;

import com.banco.model.ClienteAbstrato;
import com.banco.model.FuncionarioAbstrato;

public interface ClienteDAO extends GenericCRUD<ClienteAbstrato, String> {

	List<ClienteAbstrato> filterCltByAge(int age);

}