package dev.the01guy.keyboard;

public class KeyData {
	int viewId;
	String code;
	String type;
	char primaryChar, secondaryChar;

	KeyData(int viewId, String code, String type, char primaryChar, char secondaryChar) {
		this.viewId = viewId;
		this.code = code;
		this.type = type;
		this.primaryChar = primaryChar;
		this.secondaryChar = secondaryChar;
	}
}