package annotationAndReflection;

import java.lang.annotation.*;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-14 21:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface FlightQueryField {
    String name() default "";
    int order() default -1;
}
