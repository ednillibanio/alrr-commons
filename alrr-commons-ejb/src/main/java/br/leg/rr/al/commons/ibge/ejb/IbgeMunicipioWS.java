/*******************************************************************************
 * ALE-RR Licença
 * Copyright (C) 2018, ALE-RR
 * Boa Vista, RR - Brasil
 * Todos os direitos reservados.
 * 
 * Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e 
 * não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.commons.ibge.ejb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.leg.rr.al.commons.domain.UfType;
import br.leg.rr.al.commons.ibge.jpa.IbgeMunicipio;
import br.leg.rr.al.core.dao.BaseJPADao;

/**
 * @author Ednil Libanio da Costa Junior
 * @date 10-04-2018
 */
@Named
@Stateless
public class IbgeMunicipioWS extends BaseJPADao<IbgeMunicipio, Integer> implements IbgeMunicipioLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7570695428497812951L;

	private static final Logger logger = LoggerFactory.getLogger(IbgeMunicipioWS.class);

	@Override
	public List<IbgeMunicipio> buscarMunicipiosPorUF(UfType uf) {
		return buscarMunicipios(uf);
	}

	private List<IbgeMunicipio> buscarMunicipios(UfType uf) {

		BufferedReader br = null;
		URL url = null;

		try {
			if (uf != null) {
				url = new URL(URL_IBGE_MUNICIPIOS_POR_UFS + uf.getIbgeId() + "/municipios");
			} else {
				url = new URL(URL_IBGE_MUNICIPIOS);
			}

			// 1- busca cep via WS.

			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));

			StringBuilder jsonSb = new StringBuilder();

			br.lines().forEach(l -> jsonSb.append(l.trim()));
			Gson gson = new Gson();

			List<IbgeMunicipio> municipios = gson.fromJson(jsonSb.toString(), new TypeToken<List<IbgeMunicipio>>() {
			}.getType());

			return municipios;

		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
		} catch (ConnectException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}

		return null;
	}

	@Override
	public List<IbgeMunicipio> buscarMunicipios() {
		return buscarMunicipiosPorUF(null);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.leg.rr.al.core.dao.DaoStatus#jaExiste(br.leg.rr.al.core.jpa.EntityStatus)
	 */
	@Override
	public Boolean jaExiste(IbgeMunicipio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
