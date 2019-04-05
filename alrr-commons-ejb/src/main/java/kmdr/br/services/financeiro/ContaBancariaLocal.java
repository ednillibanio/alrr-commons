package br.kmdr.imobil.service.financeiro;

import javax.ejb.Local;

import br.kmdr.imobil.entity.financeiro.ContaBancaria;
import br.kmdr.util.dao.Dao;

@Local
public interface ContaBancariaLocal extends Dao<ContaBancaria> {

}
