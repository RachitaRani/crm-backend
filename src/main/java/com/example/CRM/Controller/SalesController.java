package com.example.CRM.Controller;

import com.example.CRM.Model.Sales;
import com.example.CRM.Service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/sales")
@CrossOrigin(origins = "http://localhost:4200")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesById(@PathVariable Long id) {
        Sales sales = salesService.getSalesById(id);
        if (sales == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sales);
    }

    @PostMapping
    public Sales createSales(@RequestBody Sales sales) {
        return salesService.createSales(sales);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSales(@PathVariable Long id, @RequestBody Sales salesDetails) {
        Sales sales = salesService.updateSales(id, salesDetails);
        if (sales == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sales);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSales(@PathVariable Long id) {
        salesService.deleteSales(id);
        return ResponseEntity.noContent().build();
    }
}
