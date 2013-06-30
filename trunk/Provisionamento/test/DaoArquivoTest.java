
import MyExceptions.DaoException;
import Resources.Resources;
import Sistema.Dao;
import Sistema.FacadeCarregaArquivos;
import Sistema.Factoring;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import provisionamento.model.Categoria;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.GrupoUnitario;
import provisionamento.model.Participante;
import provisionamento.model.Usuario;

public class DaoArquivoTest {

    public DaoArquivoTest() {
    }

    private void clearBase() {
        try {
            File file = new File("\\TestesJUnit\\");
            if (file.isDirectory()) {
                File[] sun = file.listFiles();
                for (File toDelete : sun) {
                    toDelete.delete();
                }
            }
            file.mkdirs();
            Resources.CAMINHO_ARQUIVOS = "\\TestesJUnit\\";
        } catch (Exception ex) {
            fail("Erro ao inicializar os testes. " + ex.getMessage());
        }
    }

    @Before
    public void setUp() {
        clearBase();
    }

    @Test()
    public void usuarioTest() {
        try {
            Dao<Usuario> daoUsuario = Factoring.getDaoUsuario();

            Usuario u = new Usuario();
            assertEquals(-1, u.getId());
            u.setNome("Teste teste");
            u.setEmail("Teste_teste@");
            u.setSenha(new char[]{'a'});
            daoUsuario.grava(u);
            assertNotSame(-1, u.getId());
            assertEquals(u, daoUsuario.busca("Teste teste"));
            
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test()
    public void participanteTest() {
        try {

            Dao<Usuario> daoUsuario = Factoring.getDaoUsuario();
            Dao<Participante> daoParticipante = Factoring.getDaoParticipante();

            Usuario u = new Usuario();
            u.setNome("Teste teste1");
            u.setEmail("teste@teste");
            u.setSenha(new char[]{'a'});
            daoUsuario.grava(u);

            Participante p = new Participante();
            assertEquals(-1, p.getId());
            p.setUsuario(u);
            daoParticipante.grava(p);
            assertNotSame(-1, p.getId());

            assertEquals(p, daoParticipante.busca("Teste teste1"));
            assertEquals(u, daoParticipante.busca("Teste teste1").getUsuario());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test()
    public void categoriaTest() {
        try {
            clearBase();
            Dao<Categoria> daoCategoria = Factoring.getDaoCategoria();

            Categoria cat = new Categoria();
            assertEquals(-1, cat.getId());
            cat.setDescricao("Teste");
            daoCategoria.grava(cat);
            assertNotSame(-1, cat.getId());
            
            assertEquals(cat, daoCategoria.busca("Teste"));
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test()
    public void grupoComunitarioTest() {
        try {
            clearBase();
            Dao<Usuario> daoUsuario = Factoring.getDaoUsuario();
            Dao<Participante> daoParticipante = Factoring.getDaoParticipante();
            Dao<GrupoComunitario> daoGrupoCom = Factoring.getDaoGrupoComunitario();

            GrupoComunitario grupo = new GrupoComunitario();
            assertEquals(-1, grupo.getId());
            grupo.setDescricao("Grupo Teste");

            Usuario u = new Usuario();
            u.setNome("Teste");
            u.setEmail("teste@teste.teste");
            u.setSenha(new char[]{'t', 'e', 's', 't', 'e'});
            daoUsuario.grava(u);

            grupo.setCriador(u);

            Usuario uParticipante = new Usuario();
            uParticipante.setNome("Teste Participante");
            uParticipante.setEmail("teste@teste.teste");
            uParticipante.setSenha(new char[]{'t', 'e', 's', 't', 'e'});
            daoUsuario.grava(uParticipante);

            Participante p = new Participante();
            p.setUsuario(uParticipante);
            daoParticipante.grava(p);

            grupo.addParticipante(p);

            daoGrupoCom.grava(grupo);
            assertNotSame(-1, grupo.getId());
            
            
            assertEquals(grupo, daoGrupoCom.busca(grupo.getId()));
            assertEquals(grupo.getCriador(), daoUsuario.busca("Teste"));
            assertEquals(grupo.getParticipantes().get(0), daoParticipante.busca("Teste Participante"));
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test()
    public void grupoUnitarioTest() {
        try {
            clearBase();
            Dao<Usuario> daoUsuario = Factoring.getDaoUsuario();
            Dao<GrupoUnitario> daoGrupoUni = Factoring.getDaoGrupoUnitario();

            GrupoUnitario grupo = new GrupoUnitario();
            assertEquals(-1, grupo.getId());
            grupo.setDescricao("dsaj sajdkshfgfaskfsafsdfsdçfdsaj sajdkshfgfask");

            Usuario u = new Usuario();
            u.setNome("Teste");
            u.setEmail("teste@teste.teste");
            u.setSenha(new char[]{'t', 'e', 's', 't', 'e'});
        
            daoUsuario.grava(u);

            grupo.setCriador(u);

            daoGrupoUni.grava(grupo);
            assertNotSame(-1, grupo.getId());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}