package eu.sige.daterbackend.service;

import eu.sige.daterbackend.statistic.model.AccessData;
import eu.sige.daterbackend.statistic.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class AccessService {

    final AccessRepository accessRepository;

    @Autowired
    public AccessService(AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    @Async
    public void maintainDbAndSaveAccessData() {
        maintainDb();
        saveAccessData();
    }

    private void maintainDb() {
        if (checkDataSize() > 5000) {
            deleteAllData();
        }
    }

    private void deleteAllData() {
        accessRepository.deleteAll();
    }

    private long checkDataSize() {
        Iterable<AccessData> all = accessRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).count();
    }

    private void saveAccessData() {
        accessRepository.save(new AccessData());
    }

}
