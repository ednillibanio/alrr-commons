package br.kmdr.util.domain;

public enum ActionStatusType {

	SUCCESS("success"), FAILURE("failure"), NEW("new"), SAVE("save"), UPDATE(
			"update"), REMOVE("remove"), CANCEL("cancel"), SEARCH("search"), EDIT(
			"edit"), NO_RESULTS("no_results"), HOME("home");

	private ActionStatusType(String label) {
		this.label = label;
	}

	private String label;

	@Override
	public String toString() {
		return label;
	}
}
