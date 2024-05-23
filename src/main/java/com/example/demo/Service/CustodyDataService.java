//package com.example.demo.Service;
//import com.example.demo.dto.CustodyDataResponse;
//import com.example.demo.Repository.CustodyDataRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CustodyDataService implements CustodyDataServiceInterface {
//
////    @Autowired
//    private  final  CustodyDataRepository custodyDataRepository;
//
//    public CustodyDataService(CustodyDataRepository custodyDataRepository) {
//        this.custodyDataRepository = custodyDataRepository;
//    }
//
//
//
//    public List<CustodyDataResponse> getCustodyData(String employeeId, String serial, String itemCode,
//                                                    String date, String itemDescription, boolean includeHistory) {
//        return custodyDataRepository.getCustodyData(employeeId, serial, itemCode, date, itemDescription, includeHistory);
//    }
//
//
//
//}
//package com.example.demo.service;
package com.example.demo.Service;

import com.example.demo.dto.CustodyDataInEveryCaseResponse;
import com.example.demo.dto.CustodyDataInEveryCaseResponseTemporary;
import com.example.demo.dto.CustodyDataResponse;
import com.example.demo.dto.CustodyDataResponseTemporary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustodyDataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CustodyDataResponse> getCustodyData(String employeeId, String iteamSerialNumber, String itemCode,
                                                    Date date, String itemDescription, boolean includeHistory) {

        if (employeeId == null || employeeId.isEmpty() || employeeId.equalsIgnoreCase("null")) {
            // Handle the case where employeeId is null or empty
            // For example, throw an IllegalArgumentException
            throw new IllegalArgumentException("employeeId parameter cannot be null or empty");
        }
        // Build the SQL query
        String sql = "SELECT * FROM Custody.utf_GetCustodyData(?, ?, ?, ?, ?, ?)";

        // Execute the query using JdbcTemplate
        return jdbcTemplate.query(sql, new Object[]{employeeId, iteamSerialNumber, itemCode, date, itemDescription, includeHistory},
                new BeanPropertyRowMapper<>(CustodyDataResponse.class));
    }


    public List<CustodyDataResponseTemporary> getCustodyDataTemporary(String employeeId, String iteamSerialNumber, String itemCode,
                                                                      Date date, String itemDescription, boolean includeHistory) {
        if (employeeId == null || employeeId.isEmpty() || employeeId.equalsIgnoreCase("null")) {
            // Handle the case where employeeId is null or empty
            // For example, throw an IllegalArgumentException
            throw new IllegalArgumentException("employeeId parameter cannot be null or empty");
        }
        // Build the SQL query
        String sql = "SELECT * FROM Custody.utf_GetCustodyData_Api(?, ?, ?, ?, ?, ?)";

        // Execute the query using JdbcTemplate
        return jdbcTemplate.query(sql, new Object[]{employeeId, iteamSerialNumber, itemCode, date, itemDescription, includeHistory},
                new BeanPropertyRowMapper<>(CustodyDataResponseTemporary.class));
    }


    public List<CustodyDataInEveryCaseResponse> getCustodyDataInEveryCase(int ItemStatusID, String ItemCode, String BarcodeNumber,
                                                                              String iteamSerialNumber, String BarcodeId , boolean IsDeleted) {
        // Build the SQL query
        String sql = "SELECT * FROM  [Custody].[utf_GetItemsApi] (?, ?, ?, ?, ?, ?)  ";

        return jdbcTemplate.query(sql, new Object[]{ItemStatusID, ItemCode, BarcodeNumber, iteamSerialNumber, BarcodeId,0},
                new BeanPropertyRowMapper<>(CustodyDataInEveryCaseResponse.class));
    }


    public List<CustodyDataInEveryCaseResponseTemporary> getCustodyDataInEveryCaseTemporary(int ItemStatusID, String ItemCode, String BarcodeNumber,
                                                                                            String iteamSerialNumber, String BarcodeId , boolean IsDeleted) {
        // Build the SQL query
        String sql = "SELECT * FROM  [Custody].[utf_GetItemsApiS] (?, ?, ?, ?, ?, ?)  ";

        return jdbcTemplate.query(sql, new Object[]{ItemStatusID, ItemCode, BarcodeNumber, iteamSerialNumber, BarcodeId,0},
                new BeanPropertyRowMapper<>(CustodyDataInEveryCaseResponseTemporary.class));
    }
}

