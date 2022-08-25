package br.com.alura.gerenciador.servelet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
    private static final List<Empresa> lista = new ArrayList<>();

    static {
        Empresa empresa1 = new Empresa();
        Empresa empresa2 = new Empresa();
        empresa1.setNome("Meso Telecom");
        empresa2.setNome("Virtual Sistemas");
        Banco.lista.add(empresa1);
        Banco.lista.add(empresa2);
    }
    public void adiciona(Empresa empresa) {
        Banco.lista.add(empresa);
    }

    public List<Empresa> getLista(){
        return Collections.unmodifiableList(lista);
    }
}
