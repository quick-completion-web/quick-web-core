package tech.guyi.web.quick.core.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface Converter {
    Object convert(String origin);
}

public class TypeConverterUtils {

    public static Map<Class<?>, Converter> converters;

    static {
        converters = new HashMap<>();
        converters.put(int.class, Integer::valueOf);
        converters.put(Integer.class, Integer::valueOf);
        converters.put(long.class, Long::valueOf);
        converters.put(Long.class, Long::valueOf);
        converters.put(double.class, Double::valueOf);
        converters.put(Double.class, Double::valueOf);
        converters.put(float.class, Float::valueOf);
        converters.put(Float.class, Float::valueOf);
        converters.put(boolean.class, Boolean::valueOf);
        converters.put(Boolean.class, Boolean::valueOf);
        converters.put(String.class, origin -> origin);

        converters.put(Date.class, DateUtils::parse);
    }

    public static Object convert(Class<?> type, String origin){
        try{
            return type.cast(converters.getOrDefault(type,o -> o).convert(origin));
        }catch (Exception e){
            return origin;
        }
    }

}
