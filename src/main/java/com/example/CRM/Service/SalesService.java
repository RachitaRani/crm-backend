package com.example.CRM.Service;

import com.example.CRM.Model.Sales;
import com.example.CRM.Repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales getSalesById(Long id) {
        return salesRepository.findById(id).orElse(null);
    }

    public Sales createSales(Sales sales) {
        return salesRepository.save(sales);
    }

    public Sales updateSales(Long id, Sales salesDetails) {
        Sales sales = salesRepository.findById(id).orElse(null);
        if (sales != null) {
            sales.setDealName(salesDetails.getDealName());
            sales.setStage(salesDetails.getStage());
            sales.setAmount(salesDetails.getAmount());
            return salesRepository.save(sales);
        }
        return null;
    }

    public void deleteSales(Long id) {
        salesRepository.deleteById(id);
    }
}
