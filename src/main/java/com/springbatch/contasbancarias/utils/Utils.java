package com.springbatch.contasbancarias.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

//    public static void main(String[] args) throws IOException {
//        FileWriter arquivo = new FileWriter("d:\\sql.txt");
//        arquivo.append("INSERT INTO usuario(agencia, conta, digito) VALUES ");
//        for (int i = 0; i < 100000; i++) {
//            arquivo.append(insertConta() +", ");
//        }
//        arquivo.append(insertConta() + ";");
//        arquivo.flush();
//    }
//
//    private static String insertConta() {
//        ThreadLocalRandom current = ThreadLocalRandom.current();
//        return String.format("('%d', '%d', '%d')", current.nextInt(1, 9999), current.nextInt(1, 9999999), current.nextInt(1, 9));
//    }
}
