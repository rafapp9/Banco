package com.banco.service;

import java.util.List;

import com.banco.model.ClienteAbstrato;
import com.banco.repository.GenericCRUD;

public interface ClienteService extends GenericCRUD<ClienteAbstrato, String> {

	List<ClienteAbstrato> filterCltByAge(int age);
 
}
