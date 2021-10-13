package io.github.thetoxicat.testtask.service;

import io.github.thetoxicat.testtask.model.User;
import io.github.thetoxicat.testtask.utils.RetrofitUtils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import retrofit2.Response;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

	private IUserService serviceImpl;
	private static ThreadLocal<UserService> threadLocalInstance = new ThreadLocal<>();

	public static UserService getInstance() {
		IUserService serviceImpl = RetrofitUtils.getInstance().create(IUserService.class);
		if(threadLocalInstance.get() == null) {			
			threadLocalInstance.set(new UserService(serviceImpl));
		}
		return threadLocalInstance.get();
	}
	
	@SneakyThrows
	public Response<User> create(User gist){
		return serviceImpl.create(gist).execute();
	}
	
}