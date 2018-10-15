package Films.component;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan(basePackages = {"Films"})
@EnableTransactionManagement
@EnableWebMvc
// klasa konfiguracyjna. Odpowiada za dostęp do Hibernate'a
public class Config extends WebMvcConfigurerAdapter/* implements WebApplicationInitializer*/ {

    @Bean
    public DataSource source() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/legalfriend");
        source.setUsername("root");
        source.setPassword("root");
        return source;
    }

   /* @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        Properties properties = new Properties();

        entityManagerFactoryBean.setPersistenceUnitName("legalfriend");
        entityManagerFactoryBean.setDataSource(source());
        entityManagerFactoryBean.setPackagesToScan("Films");

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(true);
        adapter.setShowSql(true);

        entityManagerFactoryBean.setJpaVendorAdapter(adapter);
        entityManagerFactoryBean.setJpaProperties(properties);

        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
        properties.put("hibernate.connection.useUnicode", "true");
        properties.put("hibernate.connection.characterEncoding", "UTF-8");
        properties.put("hibernate.connection.charSet", "UTF-8");
        properties.put("hibernate.hbm2ddl.auto", "validate");
        return entityManagerFactoryBean;
    }

    @Bean
    public SharedEntityManagerBean entityManagerBean() {
        SharedEntityManagerBean managerBean = new SharedEntityManagerBean();
        managerBean.setPersistenceUnitName("legalfriend");
        managerBean.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return managerBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/baza/", ".jsp");
        registry.enableContentNegotiation(true);
        registry.viewResolver(new InternalResourceViewResolver());
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/baza/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/baza/js/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(Config.class);
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
        servletContext.addListener(contextLoaderListener);
        servletContext.setInitParameter("contextInitializerClasses", "Films.component.Config");
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(Config.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.addMapping("/");
    }

    @Bean
    public RequestMappingHandlerMapping mappingHandlerMapping() {
        RequestMappingHandlerMapping mappingHandlerMapping = new RequestMappingHandlerMapping();
        mappingHandlerMapping.setDefaultHandler(requestMappingHandlerAdapter());
        mappingHandlerMapping.getDefaultHandler();
        mappingHandlerMapping.setUseTrailingSlashMatch(false);
        mappingHandlerMapping.setAlwaysUseFullPath(false);
        return mappingHandlerMapping;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true);
        configurer.favorPathExtension(false);
        configurer.ignoreAcceptHeader(false);
    }*/
}