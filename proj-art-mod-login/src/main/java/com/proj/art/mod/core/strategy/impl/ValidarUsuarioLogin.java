/*
 * ValidarUsuarioLogin.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.mod.core.strategy.impl;

import com.proj.art.core.IStrategy;
import com.proj.art.mod.core.dao.HistoricoDAO;
import com.proj.art.mod.core.dao.LoginDAO;
import com.proj.art.mod.core.dao.UsuarioDAO;
import com.proj.art.mod.model.Historico;
import com.proj.art.mod.model.Login;
import com.proj.art.mod.model.Usuario;
import com.proj.art.model.DomainEntity;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description the class  ValidarUsuarioLogin - Classe que implementa IStrategy e
 * realiza regra de negócio que valida se usuario existe.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
public class ValidarUsuarioLogin implements IStrategy {

    @Autowired
    LoginDAO loginDAO;
    
    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    HistoricoDAO historicoDAO;
    
    /**
     * Método que processar da classe.
     *
     * @param entidade
     * @return String
     */
    @Override
    public String process(DomainEntity entidade) {

        if (entidade instanceof Login) {
            Login login = (Login) entidade;
            Usuario usuario = login.getUsuario();
            Date dtUltimoAcesso = Calendar.getInstance().getTime();
            Integer contVerificador;

            Login log = new Login();
            log.setNavegador(login.getNavegador());
            log.setIp(login.getIp());
            log.setDtAcesso(dtUltimoAcesso);
            log.setActive("S");

            
            Usuario usuarioEmail = new Usuario();
            usuarioEmail.setEmail(usuario.getEmail());
            List<Usuario> listUsuarioEmail = usuarioDAO.findByCriteria(usuarioEmail);

            if (listUsuarioEmail.isEmpty()) {
                return "<1447>";
            }

            //Verifica se existe usuario com este email
            if (listUsuarioEmail.size() == 1) {
                //Verificação de usuario bloqueado. Caso null usuario bloqueado.
                contVerificador = VerificarLogsAcesso(usuarioEmail);
                if (contVerificador == null) {
                    return "<1446>";
                }

                //Usuario não bloqueado.
                //Criptografo a senha para realizar comparação com o banco de dados
                String senhahex = Criptografar.criptografar(usuario.getSenha());
                //Caso criptografia der erro, voltar com o erro.
                if (senhahex.contains("<5900>")) {
                    return senhahex;
                }

                usuario.setSenha(senhahex);
                //Faz a busca novamente com login e senha
                List<Usuario> listEndt = usuarioDAO.findByCriteria(usuario);
                if (listEndt.size() == 1) {
                    Usuario u = listEndt.get(0);
                    u.setLogins(null);
                    Historico historico = new Historico();
                    historico.setIp(log.getIp());
                    historico.setNavegador(log.getNavegador());
                    historico.setDtUltimoAcesso(dtUltimoAcesso);
                    historico.setDispositivo(log.getDispositivo());
                    historico.setActive("S");
                    historico.setUsuario(u);                    
                    historicoDAO.save(historico);

                    u.setDtUtimoAcesso(dtUltimoAcesso);
                    usuarioDAO.update(u);
                    log.setUsuario(u);
                    log.setEstado("OK");
                    loginDAO.save(log);
                    return null;

                } else if (listEndt.size() > 1) {
                    //Existe mais de um usuario                  
                    return "<1443>";
                } else {

                    Usuario usu = listUsuarioEmail.get(0);
                    usu.setDtUtimoAcesso(dtUltimoAcesso);
                    usuarioDAO.update(usu);
                    log.setUsuario(usu);
                    log.setEstado("FALHA");
                    loginDAO.save(log);

                    return "<1440> {Restão " + contVerificador + " tentativa(s) antes que usuário seja bloqueado.}";
                }
            } else {
                return "<1447>";
            }

        } else {
            return "<5603> Não foi possivel validar a usuario, pois entidade nao é um usuario!";
        }

    }

    public Integer VerificarLogsAcesso(Usuario usuario) {
        Login findLogin = new Login();
        Integer contagem = null;
        findLogin.setEstado("FALHA");
        findLogin.setUsuario(usuario);
        findLogin.setActive("S");
        List<Login> findAcessos = loginDAO.findByCriteria(findLogin);

        //Contador para verificar quantidade de acessos com erros.
        int contErros = 0;
        DateTime hoje = new DateTime();

        //Laço de verificação de acessos e seus intervalos.
        for (Login acesso : findAcessos) {
            DateTime ultimoAcesso = new DateTime(acesso.getDtAcesso());
            Minutes min = Minutes.minutesBetween(ultimoAcesso, hoje);

            //Se valor for menor que 180 minutos, ou seja 3 horas, soma ao contador. 
            if (min.getMinutes() < 180) {
                contErros += 1;
            }
        }

        //Se contador for maior que 4 volta a mensagem de bloqueio.
        if (contErros > 4) {
            return null;
        } else {
            contagem = (4 - contErros);
            return contagem;
        }

    }

}

