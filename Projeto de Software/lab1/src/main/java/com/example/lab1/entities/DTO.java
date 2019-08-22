package com.example.lab1.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DTO {
	
	private String dto;
	
	@JsonCreator
	public DTO(String dto) {
		super();
		this.dto = dto;
	}

	public String getDto() {
		return dto;
	}

	public void setDto(String dto) {
		this.dto = dto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dto == null) ? 0 : dto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTO other = (DTO) obj;
		if (dto == null) {
			if (other.dto != null)
				return false;
		} else if (!dto.equals(other.dto))
			return false;
		return true;
	}
	

}
