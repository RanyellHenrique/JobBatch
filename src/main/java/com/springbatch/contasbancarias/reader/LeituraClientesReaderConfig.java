package com.springbatch.contasbancarias.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.springbatch.contasbancarias.dominio.Usuario;

@Configuration
public class LeituraClientesReaderConfig {
	@Bean
	public JdbcPagingItemReader<Usuario> leituraClientesReader(
			@Qualifier("appDataSource") DataSource dataSource,
			PagingQueryProvider queryProvider
			) {
		return new JdbcPagingItemReaderBuilder<Usuario>()
				.name("leituraClientesReader")
				.dataSource(dataSource)
				.queryProvider(queryProvider)
				.rowMapper(new BeanPropertyRowMapper<Usuario>(Usuario.class))
				.build();
	}

	@Bean
	public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("appDataSource") DataSource dataSource) {
		SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
		queryProvider.setDataSource(dataSource);
		queryProvider.setSelectClause("select *");
		queryProvider.setFromClause("from usuario");
		queryProvider.setSortKey("conta");
		return queryProvider;
	}
}
