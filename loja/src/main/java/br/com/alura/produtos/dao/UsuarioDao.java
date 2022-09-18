package br.com.alura.produtos.dao;

import br.com.alura.produtos.modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDao {
	private final Session session;

	public UsuarioDao() {
		session = new HibernateUtil().openSession();
	}

	public Usuario buscaUsuarioPorLoginESenha(Usuario usuario) {
		Query query = this.session.createQuery("from Usuario where login = :pLogin and senha = :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		return (Usuario) query.uniqueResult();
	}
}
