package com.example.demo.Service;

import com.example.demo.Model.Items;
import com.example.demo.Repository.EmployeesRepository;
import com.example.demo.Repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class ItemStatusService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private EmployeesRepository employeesRepository;

    public void     changeItemStatus(int itemId, int statusId, String statusBy, Date date, String refNo, String requestType) {
        String sql = "{call Custody.usp_ChangeItemStatus(?, ?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, itemId, statusId, statusBy, date, refNo, requestType);
    }

    public void addCustody(int itemId, String custodyBy, Date custodyOn, String referenceNumber, String requestType) {
        String sql = "{call Custody.usp_AddCustody(?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, itemId, custodyBy, custodyOn, referenceNumber, requestType);
    }

    public boolean itemExists(int itemId) {
        return itemsRepository.existsById(itemId);
    }

    public boolean employeeExists(String employeeId) {
        return  employeesRepository.existsByEmployeeId(employeeId);
    }




    public int getStatusId(int itemId) {
        Optional<Items> optionalItems = itemsRepository.findById(itemId);

        if (optionalItems.isPresent()) {
            Items item = optionalItems.get();
            return item.getItemStatusId();}
        else {

                // Item with the given ID does not exist
                // You can handle this case based on your application logic
                return -1; // Or throw an exception
            }
        }
    public Boolean getIsDeleted(int itemId) {
        Optional<Items> optionalItems = itemsRepository.findById(itemId);

        if (optionalItems.isPresent()) {
            Items item = optionalItems.get();
           boolean IsDeleted=item.isDeleted();
            System.out.println("IsDeleted :"+ IsDeleted);
            return item.isDeleted();}
        else {
            return false;
        }

    }



    public Boolean getIsItemIdFound(int itemId) {
        Optional<Items> optionalItems = itemsRepository.findById(itemId);

        if (optionalItems.isPresent()) {
//            Items item = optionalItems.get();
//            Integer ItemIdFound = item.getItemId();
//            System.out.println("IsDeleted :" + ItemIdFound);
            return true;
        } else {
            return false;
        }}}


