package com.example.demo.Repository;

import com.example.demo.Model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.Date;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
  Items findByItemId(Integer itemId);


//    @Query(value = "SELECT * FROM [Custody].[Custody].[Items] where ItemID = :itemId ", nativeQuery = true)
//    public Items findByItemId(Integer itemId);

}


