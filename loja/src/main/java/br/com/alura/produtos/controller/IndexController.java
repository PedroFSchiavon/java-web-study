package br.com.alura.produtos.controller;

import br.com.alura.produtos.dao.ProdutoDao;
import br.com.alura.vraptor.Path;
import br.com.alura.vraptor.Resource;

@Resource
public class IndexController {

	@Path("/")
	public void index() {
		new ProdutoDao().lista();
	}

}
