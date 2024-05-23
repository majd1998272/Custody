package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Map;

@Service
public class NewSingleItemService {


    @Autowired
    private DataSource dataSource;
        @Autowired
        private JdbcTemplate jdbcTemplate;

    public int addItem(String itemCode, String itemSerial, int itemStatusID, String itemStatusBy,
                       String barcodeID, String reference, String locationCode, int categoryId,
                       int itemTypeId, String barcodeNumber, String itemSerialNumber) {


        String procedureCall = "{CALL Custody.usp_AddItem(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        SqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("itemCode", itemCode)
                .addValue("itemSerial", itemSerial)
                .addValue("itemStatusID", (short)itemStatusID)
                .addValue("itemStatusBy", itemStatusBy)
                .addValue("barcodeID", barcodeID)
                .addValue("reference", reference)
                .addValue("locationCode", locationCode)
                .addValue("categoryId", categoryId)
                .addValue("itemTypeId", itemTypeId)
                .addValue("barcodeNumber", barcodeNumber)
                .addValue("itemSerialNumber", itemSerialNumber);

        // Execute the stored procedure and retrieve the returned value
        Integer returnValue = jdbcTemplate.queryForObject(procedureCall, inParams.getParameterNames(), Integer.class); // Change the return type according to the expected result type

        // Return the value returned by the stored procedure
        return returnValue;
    }
}

