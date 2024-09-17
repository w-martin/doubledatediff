package com.will_martin.infrastructure;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class DateKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) throws RuntimeException {
        return String.join("_", Arrays.stream(params).map(Object::hashCode)
                .map(String::valueOf).toArray(String[]::new));
    }
}
