package cn.bdqfork.rpc.config.annotation;

import cn.bdqfork.rpc.config.context.RpcComponentScanRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author bdq
 * @since 2019-02-28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RpcComponentScanRegistrar.class)
public @interface RpcComponentScan {

    String[] value() default {};

    String[] basePackages() default {};

}
