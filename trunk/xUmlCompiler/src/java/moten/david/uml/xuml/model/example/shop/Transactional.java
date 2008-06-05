package moten.david.uml.xuml.model.example.shop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.ScopeAnnotation;

/**
 * Scopes bindings to the current transaction.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD })
@ScopeAnnotation
public @interface Transactional {
}