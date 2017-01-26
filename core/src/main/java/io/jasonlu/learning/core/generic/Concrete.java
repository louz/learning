package io.jasonlu.learning.core.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by jiehenglu on 17/01/25.
 */
public class Concrete extends Generic<String> {

    public String getClazzName() {
        ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
        Type trueType = pt.getActualTypeArguments()[0];
        return trueType.getTypeName();
    }

}
