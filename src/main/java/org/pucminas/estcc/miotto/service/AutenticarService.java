package org.pucminas.estcc.miotto.service;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.pucminas.estcc.miotto.hibernate.Main;
import org.pucminas.estcc.miotto.model.Cliente;
/*
 ** Classe Service que fara a consulta no banco de dados
 ** utilizando o Hibernate
 */
public class AutenticarService {


    /*
    ** Metodo autenticarCliente recebe um objeto cliente
    ** Faz a autenticacao no banco de dados com os atributos email e senha
    ** Se um registro for retornado entao o usuario existe e esta autenticado retornando o proprio objeto cliente
    ** Caso nao encontre retorna um objeto cliente com o Id setado para -1
     */
    public Cliente autenticarCliente(Cliente cliente) {

        Session session = Main.getSession();
        Cliente clienteResult = new Cliente();


        try {
            String hql = "FROM Cliente  where email = :email and senha = :senha";
            Query query = session.createQuery(hql);
            query.setParameter("email", cliente.getEmail());
            query.setParameter("senha", cliente.getSenha());
            clienteResult = (Cliente) query.uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro: " + e.getMessage());
            clienteResult = null;

        } finally {
            session.close();
        }

        if(clienteResult != null){
            return clienteResult;
        }

        clienteResult = new Cliente();
        clienteResult.setId(-1);
        return clienteResult;


    }


}
