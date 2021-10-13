package io.github.thetoxicat.testtask.utils.testng;

import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggingTestNGListener implements IResultListener {
	@Override
	public void onTestStart(ITestResult result) {
		log.info(String.format("[TEST START] %1$s (%2$s)", result.getName(),
				!StringUtils.isBlank(result.getMethod().getDescription()) ? result.getMethod().getDescription()
						: StringUtils.EMPTY));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info(String.format("[TEST SUCCESS] %1$s (%2$s)", result.getName(),
				!StringUtils.isBlank(result.getMethod().getDescription()) ? result.getMethod().getDescription()
						: StringUtils.EMPTY));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.warn(String.format("[TEST FAILURE] %1$s (%2$s)", result.getName(),
				!StringUtils.isBlank(result.getMethod().getDescription()) ? result.getMethod().getDescription()
						: StringUtils.EMPTY));
		log.warn("Stacktrace: ", result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.warn(String.format("[TEST SKIPPED] %1$s (%2$s)", result.getName(),
				!StringUtils.isBlank(result.getMethod().getDescription()) ? result.getMethod().getDescription()
						: StringUtils.EMPTY));
	}

	@Override
	public void onStart(ITestContext context) {
		log.info("[TESTS START] " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("[TESTS FINISH] " + context.getName());
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		log.info(String.format("[CONFIG SUCCESS] %1$s (%2$s)", itr.getName(),
				!StringUtils.isBlank(itr.getMethod().getDescription()) ? itr.getMethod().getDescription()
						: StringUtils.EMPTY));
	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		log.warn(String.format("[CONFIG FAILURE] %1$s (%2$s)", itr.getName(),
				!StringUtils.isBlank(itr.getMethod().getDescription()) ? itr.getMethod().getDescription()
						: StringUtils.EMPTY));
		log.warn("Stacktrace: ", itr.getThrowable());
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		log.warn(String.format("[CONFIG SKIP] %1$s (%2$s)", itr.getName(),
				!StringUtils.isBlank(itr.getMethod().getDescription()) ? itr.getMethod().getDescription()
						: StringUtils.EMPTY));
	}

	@Override
	public void beforeConfiguration(ITestResult tr) {
		log.info(String.format("[CONFIG START] %1$s (%2$s)", tr.getName(),
				!StringUtils.isBlank(tr.getMethod().getDescription()) ? tr.getMethod().getDescription()
						: StringUtils.EMPTY));
	}
}

