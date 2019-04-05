package br.kmdr.financeiro.service;

import javax.ejb.Local;

import br.kmdr.core.dao.JPADao;
import br.kmdr.financeiro.entity.ContaBancaria;

@Local
public interface ContaBancariaLocal extends JPADao<ContaBancaria,Integer> {

}
