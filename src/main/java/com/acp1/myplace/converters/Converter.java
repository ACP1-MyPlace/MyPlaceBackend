package com.acp1.myplace.converters;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This interface represents de Converter Layer.
 *
 * It's responsible  to convert the 'From Type' (F) to the 'To Type' (T).
 * Implementation will receive F and convert to T
 *
 * The conventional naming for implementations is using 'From Type' to describe class name.
 * An example can be
 *      <code> 'FromTypeConverter implements Converter < FromType, ToType>' </code>
 * @param <F> Layer to convert
 * @param <T> Layer which you want to convert
 */
public interface Converter <F, T>{

    T apply(F from);

    F revert(T to);

    default List<T> apply(List<F> from){
        return from.stream().map(this::apply).collect(Collectors.toList());
    }

    default List<F> revert(List<T> to) {
        return to.stream().map(this::revert).collect(Collectors.toList());
    }
}
