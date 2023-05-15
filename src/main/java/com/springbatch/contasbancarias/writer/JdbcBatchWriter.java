package com.springbatch.contasbancarias.writer;

import com.springbatch.contasbancarias.dominio.Conta;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcBatchWriter {
    public static String SQL = "INSERT INTO usuario(agencia, conta, digito) VALUES (?, ?, ?)";

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcBatchItemWriter<Conta> salvarConta(@Qualifier("springDataSource") DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Conta>()
                .sql(SQL)
                .dataSource(dataSource)
                .itemPreparedStatementSetter(itemPreparedStatementSetter())
                .build();
    }

    private ItemPreparedStatementSetter<Conta> itemPreparedStatementSetter() {
        return (conta, ps) -> {
            ps.setString(1, conta.getAgencia());
            ps.setString(2, conta.getConta());
            ps.setString(3, conta.getDigito());
        };
    }
}
