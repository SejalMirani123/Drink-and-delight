package com.inventorysupplier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class DistributorDto {

	private Long distributorId;


	@NotBlank
	@Size(min = 5, max = 50)
	private String name;
	@NotBlank
	@Size(min = 5, max = 50)
	private String location;
	@NotBlank
	@Size(min = 10, max = 10, message = "Length of phone number must be 10")
	private String phoneNo;

}
