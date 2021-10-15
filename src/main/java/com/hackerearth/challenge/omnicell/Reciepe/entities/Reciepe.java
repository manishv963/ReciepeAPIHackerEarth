package com.hackerearth.challenge.omnicell.Reciepe.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reciepe {

	@Id
	@NotNull
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String image;
	@NotNull
	private String category;
	@NotNull
	private String label;
	@NotNull
	private String price;
	@NotNull
	private String description;
	
	
}
