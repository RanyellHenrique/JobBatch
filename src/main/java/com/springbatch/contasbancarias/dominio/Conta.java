package com.springbatch.contasbancarias.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
	private String agencia;
	private String conta;
	private String digito;
}
