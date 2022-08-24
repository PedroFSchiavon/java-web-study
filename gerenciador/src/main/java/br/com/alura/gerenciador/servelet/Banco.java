package br.com.alura.gerenciador.servelet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
    private static final List<Empresa> lista = new ArrayList<>();
    public void adiciona(Empresa empresa) {
        Banco.lista.add(empresa);
    }

    public List<Empresa> getLista(){
        return Collections.unmodifiableList(lista);
    }
}
