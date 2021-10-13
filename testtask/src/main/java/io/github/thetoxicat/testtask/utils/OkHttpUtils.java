package io.github.thetoxicat.testtask.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import lombok.extern.log4j.Log4j2;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

@Log4j2
public class OkHttpUtils {
	
	private static final long MAX_PRINTABLE_CONTENT_LENGTH = 5000; 

	public static String requestBodyToString(RequestBody body) {
        if (body != null) {
            Buffer buffer = new Buffer(); 
            try {
				body.writeTo(buffer);
				return buffer.readUtf8();
			} catch (IOException e) {
				log.error(e);
			}
        }
		return "";
    }

    public static String responseBodyToString(ResponseBody body) {
    	if(body == null) {
    		return "";
    	}
        try {
        	BufferedSource source = body.source();
			source.request(Long.MAX_VALUE);
			Buffer buffer = source.buffer();
			return buffer.clone().readUtf8();
		} catch (IOException e) {
			log.error(e);
			return "";
		}
    }

    public static boolean isReadableBody(MediaType type, long length) {
    	if(type == null) {
    		return false;
    	}
    	return length < MAX_PRINTABLE_CONTENT_LENGTH && 
    			(type.toString().contains("application/json"));
    }

	public static OkHttpClient getOkHttpClient() {
    	
		return new OkHttpClient.Builder()
    			.connectTimeout(30, TimeUnit.SECONDS)
    			.readTimeout(30, TimeUnit.SECONDS)
    			.connectTimeout(5, TimeUnit.SECONDS)
    			.readTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
			
				    @Override
				    public Response intercept(Interceptor.Chain chain) throws IOException {
				    	Request request = chain.request();
				    	logRequest(request);
				    	Response response = chain.proceed(request);
				    	logResponse(response);
				    	return response;
				    }
				    
				    private void logResponse(Response response) {
				    	log.debug(String.format(" -- %1$d %2$s", response.code(), response.request().url()));
				    	log.debug("-- headers --");
				    	response.headers().toMultimap().entrySet().forEach((e) ->{
				    		log.debug(String.format("-- %1$s:%2$s", e.getKey(), e.getValue()));
				    	});
				    	long contentLength = response.body().contentLength();
				    	log.debug("-- body --");
				    	if(response.body() != null && isReadableBody(response.body().contentType(), contentLength)) {
				    		log.debug("-- " + responseBodyToString(response.body()));
				    	} else {
				    		log.debug("-- <too large or cannot be represented as a sting>");
				    	}
				    }
				    
				    private void logRequest(Request request) {
				    	log.debug(String.format(" ++ %1$s %2$s", request.method(), request.url()));
				    	log.debug("++ headers ++");
				    	request.headers().toMultimap().entrySet().forEach((e) ->{
				    		log.debug(String.format("++ %1$s:%2$s", e.getKey(), e.getValue()));
				    	});
				    	long contentLength = 0;
				    	try {
				    		if(request.body() != null) {
				    			contentLength  = request.body().contentLength();
				    		}
						} catch (IOException ignored) {
							log.warn("",ignored);
						}
				    	log.debug("++ body ++");
				    	if(request.body() != null && isReadableBody(request.body().contentType(), contentLength)) {
				    		log.debug("++ " + requestBodyToString(request.body()));
				    	} else {
				    		log.debug("++ <too large or cannot be represented as a sting>");
				    	}
				    }
				    
				})
                .build();
    }
}