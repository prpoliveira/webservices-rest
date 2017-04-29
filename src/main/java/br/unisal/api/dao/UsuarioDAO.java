package br.unisal.api.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import br.unisal.api.model.TipoUsuario;
import br.unisal.api.model.Usuario;

@Component
@SuppressWarnings("unchecked")
public class UsuarioDAO extends HibernateDAO<Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);
	}

	public Usuario getUsuarioById(Long id) {
		Usuario usuario = null;
		try {
			usuario = super.get(id);
			if (usuario != null) {
				TipoUsuario tipoUsuario = usuario.getTipoUsuario();
				usuario.setTipoUsuario(HibernateUtil.initializeAndUnproxy(tipoUsuario));
			}
		} catch (NoResultException e) {
		}
		return usuario;
	}

	public List<Usuario> getUsuario() {
		List<Usuario> usuarios = null;
		Query q = getSession().createQuery("from Usuario where enable=true order by id desc");
		try {
			usuarios = q.list();
			if (usuarios != null) {
				for (Usuario usuario : usuarios) {
					TipoUsuario tipoUsuario = usuario.getTipoUsuario();
					usuario.setTipoUsuario(HibernateUtil.initializeAndUnproxy(tipoUsuario));
				}
			}
		} catch (NoResultException e) {
			usuarios = new ArrayList<>();
		}
		return usuarios;
	}
	
	public List<Usuario> getUsuarioByTipoUsuario(TipoUsuario tipoUsuario) {
		List<Usuario> usuarios = null;
		Query q = getSession().createQuery("from Usuario where tipoUsuario= :tipoUsuario and enable=true order by id desc");
		q.setParameter("tipoUsuario", tipoUsuario);
		try {
			usuarios = q.list();
			if (usuarios != null) {
				for (Usuario usuario : usuarios) {
					TipoUsuario tpUsuario = usuario.getTipoUsuario();
					usuario.setTipoUsuario(HibernateUtil.initializeAndUnproxy(tpUsuario));
				}
			}
		} catch (NoResultException e) {
			usuarios = new ArrayList<>();
		}
		return usuarios;
	}

	public Usuario getUsuarioByUsername(String username) {
		Usuario usuario = null;
		Query q = getSession().createQuery("from Usuario where username= :username");
		q.setParameter("username", username);
		try {
			usuario = (Usuario) q.uniqueResult();
			if (usuario != null) {
				TipoUsuario tpUsuario = usuario.getTipoUsuario();
				usuario.setTipoUsuario(HibernateUtil.initializeAndUnproxy(tpUsuario));
			}
		} catch (NoResultException e) {

		}
		return usuario;
	}

	public Usuario getUsuarioByUsernameAndActive(String username) {
		Usuario usuario = null;
		Query q = getSession().createQuery("from Usuario where username= :username and enable=true");
		q.setParameter("username", username);
		try {
			usuario = (Usuario) q.uniqueResult();
			if (usuario != null) {
				TipoUsuario tpUsuario = usuario.getTipoUsuario();
				usuario.setTipoUsuario(HibernateUtil.initializeAndUnproxy(tpUsuario));
			}
		} catch (NoResultException e) {

		}
		return usuario;
	}
	
	public Usuario getUsuarioByHashcodeAndActive(String hashcode) {
		Usuario usuario = null;
		Query q = getSession().createQuery("from Usuario where hashcode= :hashcode and enable=true");
		q.setParameter("hashcode", hashcode);
		try {
			usuario = (Usuario) q.uniqueResult();
			if (usuario != null) {
				Usuario u = new Usuario();
				TipoUsuario tpUsuario = usuario.getTipoUsuario();
				u.setTipoUsuario(HibernateUtil.initializeAndUnproxy(tpUsuario));
				usuario.setTipoUsuario(u.getTipoUsuario());
			}
		} catch (NoResultException e) {

		}
		return usuario;
	}
	
	public boolean getUsuarioByHashcodeAndIsActive(String hashcode) {
		String sql = "select username from usuario where hashcode = :hashcode and enable=true";
		boolean usuario = false;
		Query q = getSession().createSQLQuery(sql);
		q.setParameter("hashcode", hashcode);
		try {
			String u = (String) q.uniqueResult();
			if (u != null) {
				usuario = true;
			}
		} catch (NoResultException e) {

		}
		return usuario;
	}

	public void salvar(Usuario t) throws ConstraintViolationException{
		super.save(t);
	}

	public boolean delete(Long id) {
		Usuario t = get(id);
		delete(t);
		return true;
	}
}
