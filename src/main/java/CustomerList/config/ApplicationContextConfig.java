package CustomerList.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;					//「@Autowired」のクラス
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableTransactionManagement
@PropertySources({ @PropertySource("classpath:ds/datasource-cfg.properties")})
@Configuration
@ComponentScan("CustomerList.*")
public class ApplicationContextConfig {

	@Autowired
	private Environment env;

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
		dataSource.setUrl(env.getProperty("ds.url"));
		dataSource.setUsername(env.getProperty("ds.username"));
		dataSource.setPassword(env.getProperty("ds.password"));

		return dataSource;
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager getTransactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		DataSource dataSource = this.getDataSource();
		txManager.setDataSource(dataSource);

		return txManager;
	}
	
	
}

