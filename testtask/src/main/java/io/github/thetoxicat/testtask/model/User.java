package io.github.thetoxicat.testtask.model;

import io.github.thetoxicat.testtask.utils.RandomUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

	private Integer id;
	private String username;
	private String email;
	private Address address;
	private String website;
	private String phone;
	private Company company;

	public static class UserBuilder extends BaseBuilder<UserBuilder> {

		@Override
		public UserBuilder withDefault() {
			return username(RandomUtils.randomText())
					.email(RandomUtils.randomEmail())
					.username(RandomUtils.randomText())
					.address(Address.builder().withDefault().build())
					.website(RandomUtils.randomLink())
					.phone("1-770-736-8031 x56442")
					.company(Company.builder().withDefault().build());
		}

	}

}
