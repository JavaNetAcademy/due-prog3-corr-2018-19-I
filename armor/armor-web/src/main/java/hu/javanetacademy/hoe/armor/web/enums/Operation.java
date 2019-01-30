package hu.javanetacademy.hoe.armor.web.enums;

import java.util.stream.Stream;

public enum Operation {
	ARMOR_CREATE("aNew"), //
	ARMOR_UPDATE("aUp"), //
	ARMOR_DELETE("aDel"), //
	ARMOR_GET_BY_ID("aById"), //
	ARMOR_GET_ALL("aAll"), //
	//
	ARMOR_HX_CREATE("ahxNew"), //
	ARMOR_HX_DELETE("ahxDel"), //
	ARMOR_HX_DELETE_BY_H("ahxDelH"), //
	ARMOR_HX_DELETE_BY_A("ahxDelA"), //
	ARMOR_HX_GET_BY_H("ahxAllByH"), //
	//
	ARMOR_PCX_CREATE("apcxNew"), //
	ARMOR_PCX_DELETE("apcxDel"), //
	ARMOR_PCX_DELETE_BY_A("apcxDelA"), //
	ARMOR_PCX_DELETE_BY_PC("apcxDelPc"), //
	ARMOR_PCX_GET_BY_A("apcxByA"), //
	;

	private String operationParamName;

	private Operation(String operationParamName) {
		this.operationParamName = operationParamName;
	}

	public String getOperationParamName() {
		return operationParamName;
	}

	public static Operation valueOfOperationParamName(String operationParamName) {
		return Stream.of(Operation.values()).filter(pre -> pre.getOperationParamName().equals(operationParamName))
				.findFirst().orElse(null);
	}
}
