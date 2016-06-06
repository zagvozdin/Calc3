package calculation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zag on 29.05.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationPack {
    String desc();
}
