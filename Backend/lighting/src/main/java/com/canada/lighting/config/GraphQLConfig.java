package com.canada.lighting.config;

import com.canada.lighting.model.Category;
import com.canada.lighting.repository.CategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {

    private final CategoryRepository repository;

    public GraphQLConfig(CategoryRepository repository) {
        this.repository = repository;
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .type("Query", typeBuilder -> typeBuilder
                        .dataFetcher("categories", env -> repository.findAll()));
    }
}
