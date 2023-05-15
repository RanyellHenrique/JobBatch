package com.springbatch.contasbancarias.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	private String agencia;
	private String conta;
	private String digito;
}
