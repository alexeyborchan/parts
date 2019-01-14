package ru.javarush.parts.dao;

import org.springframework.stereotype.Repository;
import ru.javarush.parts.model.Part;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PartDao {
    private final EntityManager em;

    public PartDao(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public Part save(Part part) {
        return em.merge(part);
    }

    public List<Part> findAllPage(Integer page, int count) {
        Query query = em.createQuery("select p from Part p");
        query.setFirstResult(page);
        query.setMaxResults(count);
        return (List<Part>) query.getResultList();
    }

    public int findAll() {
        Query query = em.createQuery("from Part p");
        return query.getResultList().size();
    }

    public void delete(Integer id) {
        Part part = findById(id);
        em.remove(part);
    }

    public Part findById(Integer id) {
        return em.find(Part.class, id);
    }

    public int findCountComputers() {
        List<Integer> list = em.createQuery("select min(amount) from Part p where is_necessary=1").getResultList();
        int result = list.get(0);
        return result;
    }

    public List<Part> search(String partName,int page, int count) {
        Query query = em.createQuery("from Part p where part_name like '%" + partName + "%'");
        query.setFirstResult(page);
        query.setMaxResults(count);
        List<Part> parts = query.getResultList();

        return parts;
    }

    public List<Part> filter(int filter, int page, int count) {
        Query query = em.createQuery("from Part p where is_necessary=" + filter);
        query.setFirstResult(page);
        query.setMaxResults(count);
        return (List<Part>) query.getResultList();
    }
}
