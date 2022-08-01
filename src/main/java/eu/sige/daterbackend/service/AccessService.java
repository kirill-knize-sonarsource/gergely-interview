package eu.sige.daterbackend.service;

import eu.sige.daterbackend.statistic.model.AccessData;
import eu.sige.daterbackend.statistic.repository.AccessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
@Lazy
public class AccessService {

    private final Logger log = LoggerFactory.getLogger(AccessService.class);

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
        long dataSize = checkDataSize();
        log.info("MaintainDB called. Size: {}", dataSize);
        if (dataSize > 5000) {
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
