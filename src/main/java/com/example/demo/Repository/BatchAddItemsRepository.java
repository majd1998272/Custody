//package com.example.demo.Repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.demo.Model.BatchAddItems;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;
//
//import javax.persistence.EntityManager;
//import javax.persistence.ParameterMode;
//import javax.persistence.StoredProcedureQuery;
//import javax.transaction.Transactional;
//
//public interface BatchAddItemsRepository extends JpaRepository<BatchAddItems, Long> {
//
////    @Query(value = "EXEC [Custody].[usp_RegisterAddItemsBatch] @ActionBy = :actionBy", nativeQuery = true)
////    int executeRegisterAddItemsBatch(@Param("actionBy") int actionBy);
////    @Query(value = "EXEC [Custody].[usp_RunAddItemsBatch] @ActionBy = :actionBy, @BatchNumber = :batchNumber", nativeQuery = true)
////    int executeRunAddItemsBatch(@Param("actionBy") int actionBy, @Param("batchNumber") int batchNumber);
//
//
//
////    private EntityManager entityManager;
////
////    public int runAddItemsBatch(String actionBy, Long batchNumber) {
////        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Custody.usp_RunAddItemsBatch");
////        query.registerStoredProcedureParameter("ActionBy", Long.class, ParameterMode.IN);
////        query.registerStoredProcedureParameter("BatchNumber", Long.class, ParameterMode.IN);
////
////        query.setParameter("ActionBy", actionBy);
////        query.setParameter("BatchNumber", batchNumber);
////
////        return query.executeUpdate();
////    }
//
//
//
//    @Procedure(name = "Custody.usp_RunAddItemsBatch")
//    @Transactional
//    int runAddItemsBatch(@Param("ActionBy") String actionBy, @Param("BatchNumber") int batchNumber);
//
//
//    @Procedure(name = "Custody.usp_RegisterAddItemsBatch")
//    @Transactional
//    int runAddItemsBatch(@Param("ActionBy") String actionBy);
//}
//
package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.BatchAddItems;

public interface BatchAddItemsRepository extends JpaRepository<BatchAddItems, Long> {


}