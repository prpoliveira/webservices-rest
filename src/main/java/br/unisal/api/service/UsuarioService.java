package br.unisal.api.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.unisal.api.dao.UsuarioDAO;
import br.unisal.api.model.TipoUsuario;
import br.unisal.api.model.Usuario;

@Component
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO db;

	public List<Usuario> getUsuario() {
		return db.getUsuario();
	}
	
	public List<Usuario> getUsuarioByTipoUsuario(TipoUsuario tipoUsuario) {
		return db.getUsuarioByTipoUsuario(tipoUsuario);
	}

	public Usuario getUsuarioById(Long id) {
		return db.getUsuarioById(id);
	}
	
	public Usuario getUsuarioByUsernameAndActive(String username) {
		return db.getUsuarioByUsernameAndActive(username);
	}
	
	public Usuario getUsuarioByUsername(String username) {
		return db.getUsuarioByUsername(username);
	}
	
	public Usuario getUsuarioByHashcodeAndActive(String hashcode) {
		return db.getUsuarioByHashcodeAndActive(hashcode);
	}
	
	public boolean isExistUsuarioByHashcodeAndActive(String hashcode){
		boolean existe = false;
		if(db.getUsuarioByHashcodeAndActive(hashcode) != null){
			existe = true;
		}
		return existe;
	}
	
	public boolean isExistUsuarioByHashcodeAndIsActive(String hashcode){
		return db.getUsuarioByHashcodeAndIsActive(hashcode);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Long id) {
		return db.delete(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean save(Usuario usuario) throws ConstraintViolationException{
		db.saveOrUpdate(usuario);
		return true;
	}
	
	@Transactional(rollbackFor = Exception.class)
    public boolean update(Usuario usuario) throws ConstraintViolationException {
        db.update(usuario);
        return true;
    }

}
