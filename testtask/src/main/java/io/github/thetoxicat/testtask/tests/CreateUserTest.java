package io.github.thetoxicat.testtask.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import io.github.thetoxicat.testtask.model.User;
import io.github.thetoxicat.testtask.service.UserService;
import retrofit2.Response;

public class CreateUserTest {

	private User userToCreate = User.builder().withDefault().build();
	private Response<User> userResponse;

	@BeforeClass
	public void createUser() {
		userResponse = UserService.getInstance().create(userToCreate);
	}

	@Test(description = "Check response code is 201")
	public void responseCodeTest() {
		Assert.assertEquals(userResponse.code(), 201);
	}

	@Test(description = "Check that response entity contains all expected data")
	public void responseBodyTest() {
		ReflectionAssert.assertReflectionEquals(userToCreate, userResponse.body(),
				ReflectionComparatorMode.IGNORE_DEFAULTS);
	}
}
