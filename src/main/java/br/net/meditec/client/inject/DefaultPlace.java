/*
 * Created by IntelliJ IDEA.
 * User: carlos
 * Date: 18/05/12
 * Time: 20:57
 */
package br.net.meditec.client.inject;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Carlos A Becker
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.METHOD})
@BindingAnnotation
public @interface DefaultPlace {

}
