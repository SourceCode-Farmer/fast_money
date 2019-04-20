package com.fastmoney.fast_money.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfigurer extends WebMvcConfigurerAdapter  {

    // public WebMvcConfigurer corsConfigurer(){
    //     return new WebMvcConfigurerAdapter() {
    //         @Override
    //         public void addCorsMappings(CorsRegistry registry){
    //                 registry.addMapping("/api/**")
    //                     .allowedOrigins("http://192.168.0.103:8082")
    //                     .allowedHeaders("header1", "header2", "header3")
    //                     .exposedHeaders("header1", "header2")
    //                     .allowCredentials(false).maxAge(3600);
    //         }
    //     };
    // }

    @Override  
    public void addCorsMappings(CorsRegistry registry) {  
        registry.addMapping("/api/**")
                .allowedOrigins("http://192.168.0.103:8082")  
                .allowCredentials(true)  
                .allowedMethods("*")  
                .maxAge(3600);  
        registry.addMapping("/login")
            .allowedOrigins("http://192.168.0.103:8082")  
                .allowCredentials(true)  
                .allowedMethods("POST")  
                .maxAge(3600);  
    }  


    // private CorsConfiguration buildConfig() {  
    //     CorsConfiguration corsConfiguration = new CorsConfiguration();  
    //     corsConfiguration.addAllowedOrigin("http://192.168.0.103:8082"); // 1允许任何域名使用
    //     corsConfiguration.addAllowedHeader("*"); // 2允许任何头
    //     corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等） 
    //     return corsConfiguration;  
    // }  
  
    // @Bean
    // public CorsFilter corsFilter() {
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/api/**", buildConfig()); // 4
    //     source.registerCorsConfiguration("/login", buildConfig()); // 4
    //     return new CorsFilter(source);
    // }

    // @Override
    // public void init(FilterConfig filterConfig) throws ServletException {

    // }

    // @Override
    // public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    //         throws IOException, ServletException {
	// 	HttpServletResponse response = (HttpServletResponse) res;

    //     HttpServletRequest reqs = (HttpServletRequest) req;

    //     // response.setHeader("Access-Control-Allow-Origin",reqs.getHeader("Origin"));
    //     response.setHeader("Access-Control-Allow-Origin","http://192.168.0.103:8082");
    //     response.setHeader("Access-Control-Allow-Credentials", "true");
    //     response.setHeader("Access-Control-Allow-Methods", "*");
    //     response.setHeader("Access-Control-Max-Age", "3600");
    //     response.setHeader("Access-Control-Allow-Headers", "*");
    //     chain.doFilter(req, res);
	// }

	// @Override
	// public void destroy() {
		
	// }  
}