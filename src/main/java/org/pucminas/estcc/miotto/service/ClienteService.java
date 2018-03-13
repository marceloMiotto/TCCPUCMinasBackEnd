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
public class ClienteService {


    /*
    ** Metodo getCliente recebe o Id do cliente e retorna um objeto cliente caso encontre
    ** senao encontrar o cliente retorna um objeto cliente com o id setado para -93 (estes codigos de retorno serao usados
    ** no Android para mostrar as mensagens de acordo com o tipo de erro)
     */
    public Cliente getCliente(long id) {


        Session session = Main.getSession();
        Cliente clienteResult = new Cliente();

        try {
            String hql = "FROM Cliente  where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            clienteResult = (Cliente) query.uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro: " + e.getMessage());
            clienteResult = null;

        } finally {
            session.close();
        }

        if(clienteResult != null){
            return clienteResult;
        }else{
            clienteResult = new Cliente();
            clienteResult.setId(-93);
            return clienteResult;
        }

    }

    /*
    ** Metodo createCliente recebe um objeto cliente e cria o registro no banco de dados com o hibernate
    ** Caso ocorra erro no insert o objeto tem o id setado para zero
     */
    public Cliente createCliente(Cliente cliente) {

        Session session =  Main.getSession();
        long id = 0;
        try{
            session.beginTransaction();
            id= (long) session.save(cliente);
            session.getTransaction().commit();
			cliente.setId(id);

        }catch (HibernateException e){
            session.getTransaction().rollback();
            System.out.println( "Erro: "+ e.getMessage());
			cliente.setId(0);

        } finally {
            session.close();
        }

		
        return cliente;
    }

    /*
     ** Metodo updateCliente recebe um objeto cliente e altera o registro no banco de dados com o hibernate
     ** Caso ocorra erro no update o objeto tem o id setado para -92
     */
    public Cliente updateCliente(Cliente cliente) {


        Session session =  Main.getSession();
        try{
            session.beginTransaction();
            session.update(cliente);
            session.getTransaction().commit();

        }catch (HibernateException e){
            session.getTransaction().rollback();
            System.out.println("API Erro: " + e.getMessage());
            cliente = new Cliente();
            cliente.setId(-92);

        } finally {
            session.close();
        }
        return cliente;
    }

    /*
     ** Metodo deleteCliente recebe um objeto cliente e altera o registro no banco de dados com o hibernate
     ** Caso ocorra erro no delete do hibernate o objeto tem o id setado para -94 caso tenha sido excluido
     ** o id eh setado para -99
     */
    public Cliente deleteCliente(Cliente cliente) {

        
        Session session = Main.getSession();

        try {
            session.beginTransaction();
            session.delete(cliente);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            Cliente clienteResult = new Cliente();
            clienteResult.setId(-94);
            return clienteResult;

        } finally {
            session.close();
        }

        Cliente clienteResult = new Cliente();
        clienteResult.setId(-99);
        return clienteResult;
    }


}


