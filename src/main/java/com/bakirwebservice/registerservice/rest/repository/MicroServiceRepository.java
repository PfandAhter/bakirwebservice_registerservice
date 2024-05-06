package com.bakirwebservice.registerservice.rest.repository;

import com.bakirwebservice.registerservice.model.entity.MicroService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface MicroServiceRepository extends JpaRepository<MicroService,String> {

    @Query ("select mc from MicroService mc where mc.microServiceName = ?1")
    MicroService findMicroServiceByMicroServiceName (String microServiceName);

    @Query("select mc from MicroService mc where mc.microServiceReadyDate <= ?1 AND mc.microServiceStatus = 'UP' ")
    List<MicroService> findMicroServicesByCurrentTimestampBetweenMicroServiceReadyDateAndMicroServiceStoppedDate(Timestamp timestamp);

    @Query("select mc from MicroService mc where mc.microServiceCode= ?1")
    MicroService findMicroServiceByMicroServiceCode (String microServiceCode);

}
