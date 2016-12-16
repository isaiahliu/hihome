package org.trinity.hihome.common.accessright;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.trinity.hihome.common.message.lookup.AccessRight;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authorize {
    boolean checkAncestors() default true;

    AccessRight value();
}
