package hello.core.scan.filter;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfigTest.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();
    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type= FilterType.ANNOTATION,classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type= FilterType.ANNOTATION,classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }
}
