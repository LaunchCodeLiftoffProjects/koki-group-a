package com.example.BillTracker.services;

import com.example.BillTracker.data.BillRepository;
import com.example.BillTracker.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;

    public void saveBill(Bill newBill) {
        billRepository.save(newBill);
    }

    public void deleteById(int id) {
        billRepository.deleteById(id);
    }
}
