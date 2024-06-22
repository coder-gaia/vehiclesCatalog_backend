/**
 * @author alexandre.gaia
 */

package com.alexandreG.UserService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean validatorFactory () {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        return bean;
    }
}
