package annotationAndReflection;

import java.lang.annotation.*;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-14 21:01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface FlightQuery {
    String desc() default "";
    String url() default "";
}

