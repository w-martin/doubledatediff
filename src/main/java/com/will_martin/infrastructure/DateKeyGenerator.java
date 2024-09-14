package com.will_martin.infrastructure;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component
public class DateKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) throws RuntimeException {
        if (params.length == 2 && params[0] instanceof Date && params[1] instanceof java.util.Date) {
            return params[0].hashCode() + "_" + params[1].hashCode();
        } else {
            throw new RuntimeException("Invalid key arguments for method: " + method.getName() + " expected: Date, Date");
        }
    }
}
