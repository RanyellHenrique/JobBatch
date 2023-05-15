package com.springbatch.contasbancarias.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.contasbancarias.dominio.Usuario;
import com.springbatch.contasbancarias.dominio.Conta;

@Configuration
public class GeracaoContaProcessorConfig {
	@Bean
	public ItemProcessor<Usuario, Conta> geracaoContaProcessor() {
		return new ClassifierCompositeItemProcessorBuilder<Usuario, Conta>()
				.classifier(new GeracaoContaClassifier())
				.build();
	}
}
