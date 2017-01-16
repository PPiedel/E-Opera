package hello;

/**
 * Created by Pawel_Piedel on 2017-01-15.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Pawel on 2016-12-24.
 *
 *
 * Klasa konfiguracyjna
 * @author PawełPiędel
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * @param registry asystuje przy dodawaniu kontrolerow widokow
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("repertuar");
    }

    /**
     * @param registry asystuje przy dodawaniu przechwytywania sciezek do zasobow
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
    }

}
