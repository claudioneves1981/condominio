package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Morador;
import model.Pessoa;
import model.Visitante;

public class PessoaJpaDAO {

    private static PessoaJpaDAO instance;
    protected EntityManager entityManager;

    public static PessoaJpaDAO getInstance(){
        if (instance == null){
            instance = new PessoaJpaDAO();
        }

        return instance;
    }

    private PessoaJpaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Pessoa getById(final Long id) {

        return entityManager.find(Pessoa.class, id);
    }





    @SuppressWarnings("unchecked")
    public List<Morador> findAllMoradorByNome(final String nome) {
        return entityManager.createQuery(STR."from \{Pessoa.class.getName()} where nome like '%\{nome}%'").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Visitante> findAllVisitanterByNome(final String nome) {
        return entityManager.createQuery(STR."from \{Pessoa.class.getName()} where nome like '%\{nome}%'").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Morador> findAllMoradorOrderBy(final String query) {
        return entityManager.createQuery(STR."from \{Pessoa.class.getName()} order by \{query}").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Visitante> findAllVisitanteOrderBy(final String query) {
        return entityManager.createQuery(STR."from \{Pessoa.class.getName()} order by \{query}").getResultList();
    }


    @SuppressWarnings("unchecked")
    public List<Pessoa> findAll() {
        return entityManager.createQuery(STR."FROM \{Pessoa.class.getName()}").getResultList();
    }

    public void persist(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            pessoa = entityManager.find(Pessoa.class, pessoa.getCodigo());
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Long id) {
        try {
            Pessoa pessoa = getById(id);
            remove(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}