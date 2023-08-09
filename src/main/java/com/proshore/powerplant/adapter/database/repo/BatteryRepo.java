package com.proshore.powerplant.adapter.database.repo;

import com.proshore.powerplant.adapter.database.entity.BatteryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BatteryRepo extends JpaRepository<BatteryEntity, String> {

    @Query("SELECT b FROM BatteryEntity b WHERE CAST(b.postcode AS integer) BETWEEN :from AND :to ORDER BY b.name ASC")
    Optional<List<BatteryEntity>> findAllByPostcodeRange(int from, int to, Pageable pageable);
}
