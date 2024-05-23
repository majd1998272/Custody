package com.example.demo.Repository;

import com.example.demo.Model.ItemsCustody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

public interface ItemsCustodyRepository extends JpaRepository<ItemsCustody,Long> {

//    @Query("SELECT COUNT(ic) FROM ItemsCustody ic WHERE ic.itemId = :itemId AND (:activeOnly = 0 OR (:activeOnly = 1 AND ic.endedOn IS NULL))")
//    int getItemCountByItemIdAndActiveStatus(@Param("itemId") int itemId, @Param("activeOnly") int activeOnly);


    @Modifying
    @Transactional
    @Query("UPDATE ItemsCustody ic SET ic.endedOn = :endDate WHERE ic.itemId = :itemId")
    void updateItemCustodyEndOn(@Param("itemId") Long itemId, @Param("endDate") Date endDate);
}
