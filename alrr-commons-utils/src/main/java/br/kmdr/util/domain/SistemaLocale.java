package br.kmdr.util.domain;

public enum SistemaLocale {

	pt_BR("pt", "BR", "enum.idioma.portugues"), en("en", "US",
			"enum.idioma.ingles"), es("es", "ES", "enum.idioma.espanhol");

	private String label;
	private String language;
	private String country;

	private SistemaLocale(String language, String country, String label) {
		this.label = label;
		this.language = language;
		this.country = country;

	}

	public String getLabel() {
		return label;
	}

	public String getLanguage() {
		return language;
	}

	public String getCountry() {
		return country;
	}

}
