package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Javi on 26/11/2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.pom.pages.impl","com.pom.components"})
public class CucumberConfiguration {
}
