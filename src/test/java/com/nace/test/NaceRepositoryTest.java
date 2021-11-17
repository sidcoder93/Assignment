package com.nace.test;

import com.nace.entity.Nace;
import com.nace.repository.NaceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest

public class NaceRepositoryTest {

    @Autowired
    private NaceRepository naceRepository;
    private Nace nace;

    @BeforeEach
    public  void setUp()
    {
        nace = Nace.builder()
                .orderNo(398481L)
                .level(1)
                .code("A")
                .description("AGRICULTURE, FORESTRY AND FISHING")
                .thisItemIncludes("This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.")
                .ref("A").build();
    }

    @AfterEach
    public void tearDown() {
        //naceRepository.deleteAll();
        nace = null;
    }

    @Test
    public void saveNaceDetailsToTestSaveMethod()
    {
        naceRepository.save(nace);
        Nace getNaceObj = naceRepository.findById(nace.getOrderNo()).get();

        Assertions.assertEquals(getNaceObj.getOrderNo(), nace.getOrderNo());
    }




}
