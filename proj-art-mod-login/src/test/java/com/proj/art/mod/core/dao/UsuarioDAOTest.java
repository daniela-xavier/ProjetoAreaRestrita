package com.proj.art.mod.core.dao;

import com.proj.art.interfaces.IDAOTest;
import com.proj.art.mod.model.Usuario;
import com.proj.art.core.config.JPAConfiguration;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @brief Classe UsuarioDAOTest Descripton
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @date 17/12/2018
 * @version %I%, %G%
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JPAConfiguration.class)
@ContextConfiguration(classes = {UsuarioDAO.class, Usuario.class})
@ActiveProfiles("dev")
public class UsuarioDAOTest implements IDAOTest {

    @Autowired
    @Qualifier(value = "usuarioDAO")

    private UsuarioDAO usuarioDAO;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Override
    @Transactional
    public void testSave() {
        Usuario u = new Usuario();
        u.setEmail("teste@fozadvogados.com.br");      
        this.usuarioDAO.save(u);
        Assertions.assertThat(u.getId()).isNotNull();
    }

    @Override
    public void testUpdate() {
        /**
         * Description: O testUpdate ...
         *
         * @param the parameters used by the method
         * @return null
         * @throws what kind of exception does this method throw
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testDelete() {
        /**
         * Description: O testDelete ...
         *
         * @param the parameters used by the method
         * @return null
         * @throws what kind of exception does this method throw
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testDeleteById() {
        /**
         * Description: O testDeleteById ...
         *
         * @param the parameters used by the method
         * @return null
         * @throws what kind of exception does this method throw
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testFindAll() {
        /**
         * Description: O testFindAll ...
         *
         * @param the parameters used by the method
         * @return null
         * @throws what kind of exception does this method throw
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testFindOne() {
        /**
         * Description: O testFindOne ...
         *
         * @param the parameters used by the method
         * @return null
         * @throws what kind of exception does this method throw
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testFindByCriteria() {
        /**
         * Description: O testFindByCriteria ...
         *
         * @param the parameters used by the method
         * @return null
         * @throws what kind of exception does this method throw
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
