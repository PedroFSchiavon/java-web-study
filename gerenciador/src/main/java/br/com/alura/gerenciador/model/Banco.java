package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Banco {
    private static final List<Empresa> lista = new ArrayList<>();

    static {
        Empresa empresa1 = new Empresa();
        Empresa empresa2 = new Empresa();
        empresa1.setId(Empresa.getIdIncrementavel());
        empresa1.setNome("Meso Telecom");
        empresa2.setId(Empresa.getIdIncrementavel());
        empresa2.setNome("Virtual Sistemas");
        Banco.lista.add(empresa1);
        Banco.lista.add(empresa2);
    }
    public void adiciona(Empresa empresa) {
        Banco.lista.add(empresa);
    }

    public List<Empresa> getLista(){
        return Banco.lista;
    }

    public void removeEmpresa(Integer id){
//        Optional<Empresa> first = Banco.lista.stream()
//                .filter(empresa -> Objects.equals(empresa.getId(), id))
//                .findFirst();
//        Empresa empresaARemover = first.orElse(null);
//        System.out.println("Removendo empresa " + empresaARemover.getNome() + "!");
        //Banco.lista.remove(empresaARemover);

        Banco.lista.removeIf(empresa -> Objects.equals(empresa.getId(), id));
    }

    public void editaEmpresa(Integer id, String nome, Date data){
        Banco.lista.forEach(empresa -> {
            if(Objects.equals(empresa.getId(), id)){
                empresa.setNome(nome);
                empresa.setDataCriacao(data);
            }
        });
    }
}
