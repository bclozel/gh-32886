package org.example.validation;

import jakarta.validation.constraints.NotEmpty;

public class VocabularyRequest {

	@NotEmpty(groups = MyGroup.class)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}