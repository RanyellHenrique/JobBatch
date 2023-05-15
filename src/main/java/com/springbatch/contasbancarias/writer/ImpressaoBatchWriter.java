package com.springbatch.contasbancarias.writer;

import com.springbatch.contasbancarias.dominio.Conta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@Component
@RequiredArgsConstructor
public class ImpressaoBatchWriter implements ItemWriter<Conta> {

    private final AtomicInteger quantidadeDeContasSalvas = new AtomicInteger(0);

    @Override
    public void write(List<? extends Conta> list) throws Exception {
        log.info("quantidade de itens salvos: {}", getQuantidadeDeContasSalvas(list));
    }

    private AtomicInteger getQuantidadeDeContasSalvas(List<? extends Conta> list) {
        quantidadeDeContasSalvas.set(quantidadeDeContasSalvas.get() + list.size());
        return quantidadeDeContasSalvas;
    }
}
