package com.springbatch.contasbancarias.processor;

import com.springbatch.contasbancarias.dominio.Conta;
import com.springbatch.contasbancarias.dominio.Usuario;
import org.springframework.batch.item.ItemProcessor;

public class ContaPlatinaItemProcessor implements ItemProcessor<Usuario, Conta> {

	@Override
	public Conta process(Usuario usuario) throws Exception {
		return new Conta(usuario.getAgencia(), usuario.getConta(), usuario.getDigito());
	}
}
