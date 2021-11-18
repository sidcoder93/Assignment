package com.nace.controller;

import com.nace.entity.Nace;
import com.nace.service.NaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
@RequestMapping("/details")
public class NaceController {

    @Autowired
    private NaceService naceService;

   @GetMapping("/{id}")
    public ResponseEntity<Nace> getNaceDetails(@PathVariable("id") Long orderNo) {

       log.info("Inside getNaceDetails for Nace Controller");

       try {
           Nace naceDetails = naceService.getNaceDetails(orderNo);
           if (naceDetails!=null) {

               return ResponseEntity.status(HttpStatus.OK).body(naceDetails);
           } else {
               log.info("No Nace Details found for Order ::" + orderNo);
               return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
           }
       }catch (Exception e){
           log.info("Inside catch of getNaceDetails of Nace Controller"+e);
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
       }


   }

    @PostMapping("/")
    public ResponseEntity<Nace> putNaceDetails(@RequestBody Nace nace)
    {
        log.info("Inside putNaceDetails of Nace Controller");
         Nace naceDetails =naceService.saveNaceDetails(nace);

         return new ResponseEntity<>(naceDetails, HttpStatus.CREATED);
    }

}
