package com.wpsnetwork.pcarrier.consola;

import java.lang.reflect.Field;

public interface Indexed {
	default long getId() {
		try {
			Field  f = this.getClass().getDeclaredField("id");
			f.setAccessible(true);
			return f.getLong(this);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
