package com.nace.test;

import com.nace.entity.Nace;
import com.nace.repository.NaceRepository;
import com.nace.service.NaceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NaceServiceTest {


    @Mock
    private NaceRepository naceRepository;

    @Autowired
    @InjectMocks
    private NaceService naceService;
    private Nace nace1;


    @BeforeEach
    public  void setUp()
    {
        nace1 = Nace.builder()
                .orderNo(398481L)
                .level(1)
                .code("A")
                .description("AGRICULTURE, FORESTRY AND FISHING")
                .thisItemIncludes("This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.")
                .ref("A").build();
    }

    @AfterEach
    public void tearDown()
    {
       // nace1 = null;
    }



    @Test
    public void givenOrderThenReturnDetailsOfOrder()
    {

        when(naceRepository.findById(398481L)).thenReturn(Optional.ofNullable(nace1));
        assert(naceService.getNaceDetails(nace1.getOrderNo())).equals(nace1);

    }

    @Test
    void givenOrderToSaveDetails() {

        when(naceRepository.save(any())).thenReturn(nace1);
        naceService.saveNaceDetails(nace1);
        verify(naceRepository,times(1)).save(any());
    }




}
