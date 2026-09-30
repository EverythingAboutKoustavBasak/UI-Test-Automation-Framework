package com.constants;

public enum Size {

//	S, M, L 
	// Maps the user-friendly size name to the corresponding HTML dropdown value.
	// Example: UI shows "L", but the <option> has value="3".
	// in this website they used - Your page uses Uniform.js, so the real <select
	// id="group_1"> is hidden while the visible dropdown is rendered through the
	// Uniform wrapper.
	// thats why the option is not selectable by its visible text so need to map the
	// dropdown value with the visible text. otherwise we can only use S,M,L

	S("1"), M("2"), L("3");

	private String value;

	Size(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
