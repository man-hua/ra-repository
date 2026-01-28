package com.common

import java.util.concurrent.ConcurrentHashMap

import com.kms.katalon.core.util.KeywordUtil

public class Context {
	private static final Context INSTANCE = new Context()
    private final Map<Class<?>, Object> registry = new ConcurrentHashMap<>()

    private Context() {}

    static <T> T get(Class<T> clazz) {
        return (T) INSTANCE.registry.computeIfAbsent(clazz) {
            clazz.getDeclaredConstructor().newInstance()
        }
    }

    static void reset() {
        INSTANCE.registry.clear()
    }
}
