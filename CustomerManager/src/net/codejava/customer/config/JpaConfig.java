package net.codejava.customer.config;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/* Lire cette article :
 * https://stackoverflow.com/questions/45261791/enablejparepositories-looking-for-which-package
 */
@Configuration
/*@EnableJpaRepositories(basePackages= {"net.codejava.dao"} )*/
@EnableJpaRepositories({"net.codejava.dao","net.codejava.controller","net.codejava.service","net.codejava.model"})
public class JpaConfig {
	
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean() ;
		//Le nom de la base de donnée dans persistence.xml
		factoryBean.setPersistenceUnitName("SalesDB");
		
		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager ;
	}

}
