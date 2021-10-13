package io.github.thetoxicat.testtask.service;

import io.github.thetoxicat.testtask.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUserService {
	
	@POST("/users")
	Call<User> create(@Body User gist);

}
