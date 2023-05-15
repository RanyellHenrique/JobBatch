package com.springbatch.contasbancarias.processor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import com.springbatch.contasbancarias.dominio.Usuario;
import com.springbatch.contasbancarias.dominio.Conta;
import com.springbatch.contasbancarias.dominio.TipoConta;

@SuppressWarnings("serial")
public class GeracaoContaClassifier implements Classifier<Usuario, ItemProcessor<?, ? extends Conta>> {
	private static final Map<TipoConta, ItemProcessor<Usuario, Conta>> processadores = new HashMap<TipoConta, ItemProcessor<Usuario, Conta>>() {{
		put(TipoConta.PRATA, new ContaPrataItemProcessor());
	}};

	@Override
	public ItemProcessor<Usuario, Conta> classify(Usuario cliente) {
		return processadores.get(TipoConta.PRATA);
	}

}
