package com.nace.service;
import com.nace.entity.Nace;
import com.nace.repository.NaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
@Slf4j
public class NaceService {

    @Autowired
    private NaceRepository naceRepository;

    public Nace getNaceDetails(Long orderNo) {

        log.info("Inside getNaceDetails for Nace Service");
        try {
            return naceRepository.findById(orderNo).get();
        }
        catch (NoSuchElementException e){

            log.info("Inside catch of getNaceDetails of Nace service" +e);
            return null;
        }

    }

    public Nace saveNaceDetails(Nace nace)   {

        log.info("Inside SaveNceDetails of Nace service for order no::"+nace.getOrderNo());


        return naceRepository.save(nace);

    }
}
