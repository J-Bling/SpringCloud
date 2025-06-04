package com.payment.service;

import com.pojo.Good;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory-server")
public interface InventoryService {
    @PostMapping("/server/inventory/insert")
    public String insert(@RequestBody Good good);

    @DeleteMapping("/server/inventory/delete/{id}")
    public String delete(@PathVariable("id") Long id);

    @PutMapping("/server/inventory/update/{id}/{count}")
    public String update(@PathVariable("id") Long id,@PathVariable("count") Integer count);

    @GetMapping("/server/inventory/find/{id}")
    public Good find(@PathVariable("id") Long id);
}
