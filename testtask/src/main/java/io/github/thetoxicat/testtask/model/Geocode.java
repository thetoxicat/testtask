package io.github.thetoxicat.testtask.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Geocode {

	private String lat;
	private String lng;
	
	public static class GeocodeBuilder extends BaseBuilder<GeocodeBuilder> {

		@Override
		public GeocodeBuilder withDefault() {
			return lat("-37.3159")
					.lng("81.1496");
		}

	}
}
