import br.com.schiavon.dao.CategoriaDao;
import br.com.schiavon.factory.ConnectionFactory;
import br.com.schiavon.model.Categoria;
import br.com.schiavon.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoriaTest {
    public static void main(String[] args) {
        try(Connection connection = new ConnectionFactory().criaConexao()){
            List<Categoria> categorias = new CategoriaDao(connection).listarComProduto();
            categorias.stream().forEach(categoria -> {
                System.out.println(categoria.getNome());
                categoria.getProdutos().stream().forEach(System.out::println);
            });
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
