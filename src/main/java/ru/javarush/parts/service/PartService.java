package ru.javarush.parts.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.parts.dao.PartDao;
import ru.javarush.parts.model.Part;

import java.util.List;

@Service
public class PartService {
    private PartDao partDao;
    private static final int count = 10;

    public PartService(PartDao partDao) {
        this.partDao = partDao;
    }

    @Transactional
    public int findAll() {
        return (int) Math.ceil((double) partDao.findAll()/count);
    }

    @Transactional
    public List<Part> findAllPage(Integer page) {

        return partDao.findAllPage((page -1) * count, count);
    }

    @Transactional
    public Part findById(Integer id) {
        return partDao.findById(id);
    }

    @Transactional
    public void save(Part part) {
        partDao.save(part);
    }

    @Transactional
    public void delete(Integer id) {
        partDao.delete(id);
    }

    @Transactional
    public int findCountComputers() {
        return partDao.findCountComputers();
    }

    @Transactional
    public List<Part> search(Integer page, String partName) {
        return partDao.search(partName, (page - 1) * count, count);
    }


    public List<Part> filter(Integer page, int filter) {
        return partDao.filter(filter, (page -1) * count, count);
    }
}
