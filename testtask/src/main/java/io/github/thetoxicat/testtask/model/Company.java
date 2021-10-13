package io.github.thetoxicat.testtask.model;

import io.github.thetoxicat.testtask.utils.RandomUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

	private String name;
	private String catchPhrase;
	private String bs;
	
	public static class CompanyBuilder extends BaseBuilder<CompanyBuilder> {

		@Override
		public CompanyBuilder withDefault() {
			return name("SomeCompany")
					.catchPhrase("Multi-layered " + RandomUtils.randomText())
					.bs("harness real-time e-markets " + RandomUtils.randomText());
		}

	}
}
