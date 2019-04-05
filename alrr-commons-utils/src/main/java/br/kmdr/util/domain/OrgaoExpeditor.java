package br.kmdr.util.domain;

import br.kmdr.util.entity.BasicEnum;

/**
 * Lista de órgãos emissores de RG retirada do site da FGV.
 * 
 * @author Ednil Libanio.
 * 
 */
// FIXME: Passar para BasicEnumType, pois as siglas podem estar erradas. Ver
// qual o melhor caminho. na dúvida ainda..
public enum OrgaoExpeditor implements BasicEnum {

	SSP("Secretaria de Segurança Pública"), PM("Polícia Militar"), PC(
			"Policia Civil"), CNT("Carteira Nacional de Habilitação"), DIC(
			"Diretoria de Identificação Civil"), CTPS(
			"Carteira de Trabaho e Previdência Social"), FGTS(
			"Fundo de Garantia do Tempo de Serviço"), IFP(
			"Instituto Félix Pacheco"), IPF("Instituto Pereira Faustino"), IML(
			"Instituto Médico-Legal"), MTE("Ministério do Trabalho e Emprego"), MMA(
			"Ministério da Marinha"), MAE("Ministério da Aeronáutica"), MEX(
			"Ministério do Exército"), POF("Polícia Federal"), POM(
			"Polícia Militar"), SES("Carteira de Estrangeiro"), SJS(
			"Secretaria da Justiça e Segurança"), SJTS(
			"Secretaria da Justiça do Trabalho e Segurança"), ZZZ(
			"Outros (inclusive exterior)");

	private OrgaoExpeditor(String label) {
		this.label = label;

	}

	private String label;

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return label;
	}

}
