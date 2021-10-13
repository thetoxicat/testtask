package io.github.thetoxicat.testtask.model;

public abstract class BaseBuilder<T> {

	/**
	 * Populates builder with default data for target entity
	 * @return builder instance
	 */
	public abstract T withDefault();
}
