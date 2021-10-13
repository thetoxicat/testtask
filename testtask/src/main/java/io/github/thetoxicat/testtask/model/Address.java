package io.github.thetoxicat.testtask.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

	private String street;
	private String suite;
	private String city;
	private String zip;
	private Geocode geo;
	
	public static class AddressBuilder extends BaseBuilder<AddressBuilder> {

		@Override
		public AddressBuilder withDefault() {
			return street("Moskowstr Light")
					.suite("Apt. 556")
					.city("Moskow")
					.zip("92998-3874")
					.geo(Geocode.builder().withDefault().build());
		}

	}
}
