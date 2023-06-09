package com.springbatch.contasbancarias.step;

import com.springbatch.contasbancarias.dominio.Conta;
import com.springbatch.contasbancarias.dominio.Usuario;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CriacaoContasStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step criacaoContasStep(
			ItemReader<Usuario> leituraClientesReader,
			ItemProcessor<Usuario, Conta> geracaoContaProcessor,
			CompositeItemWriter<Conta> compositeContaWriter) {
		return stepBuilderFactory
				.get("criacaoContasStep")
				.<Usuario, Conta>chunk(5000)
				.reader(leituraClientesReader)
				.processor(geracaoContaProcessor)
				.writer(compositeContaWriter)
				.build();
	}
}
