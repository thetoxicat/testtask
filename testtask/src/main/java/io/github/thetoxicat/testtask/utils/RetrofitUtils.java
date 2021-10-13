package io.github.thetoxicat.testtask.utils;
import com.google.gson.GsonBuilder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RetrofitUtils {

	public static Retrofit getInstance() {

		return new Retrofit.Builder()
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.addConverterFactory(
						GsonConverterFactory
						.create(new GsonBuilder()
								.create()))
				.client(OkHttpUtils.getOkHttpClient()).build();
	}
}
