package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.UsuarioDAO;
import dao.UsuarioDAOI;
import model.Usuario;

class UsuarioDAOJunit {

	@Test
	void testUsuarioDAO() {
		fail("Not yet implemented");
	}

	@Test
	void testInserir() {
		UsuarioDAOI daoi = new UsuarioDAO();
		Usuario user = new Usuario();
		
//		user.setNome("Olando Marinho Pinto");
//		user.setMatricula("2017");
//		user.setCurso("Ecologia");
//		user.setSenha("1234");
		user.setNome("Maria Antonieta");
		user.setMatricula("2010");
		user.setCurso("Ecologia");
		user.setSenha("maria123");
		
		
		// esperado - atual
		assertEquals(true, daoi.inserir(user));
		
	}

	@Test
	void testAlterar() {
		UsuarioDAOI daoi = new UsuarioDAO();
		Usuario user = new Usuario();

		user.setId(4);
		user.setNome("Maria Antonia");
		user.setMatricula("2010");
		user.setCurso("Ecologia");
		user.setSenha("maria123");
		
		// esperado - atual
		assertEquals(true, daoi.alterar(user));
	}

	@Test
	void testRemover() {
		/* id
		UsuarioDAOI daoi = new UsuarioDAO();
		Usuario user = new Usuario();
		user.setId(4);
		// esperado - atual
		assertEquals(true, daoi.remover(user));
		*/
		
		UsuarioDAOI daoi = new UsuarioDAO();
		Usuario user = new Usuario();
		user.setMatricula("2017");
		user.setId(0);
		// esperado - atual
		assertEquals(true, daoi.remover(user));
		
	}

	@Test
	void testLista() {
		fail("Not yet implemented");
	}

	@Test
	void testUsuarioString() {
		fail("Not yet implemented");
	}

	@Test
	void testUsuarioInt() {
		fail("Not yet implemented");
	}

}
