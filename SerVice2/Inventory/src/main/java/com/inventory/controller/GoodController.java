package com.inventory.controller;


import com.inventory.service.GoodService;
import com.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server/inventory")
public class GoodController {
    @Autowired private GoodService service;

    @PostMapping("/insert")
    public String insert(@RequestBody Good good){
        try{
            service.insert(good);
            return "ok";
        }catch (Exception e){
            return "error : "+e.getMessage();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        try{
            service.delete(id);
            return "ok";
        }catch (Exception e){
            return "error : "+e.getMessage();
        }
    }

    @PutMapping("/update/{id}/{count}")
    public String update(@PathVariable("id") Long id,@PathVariable("count") Integer count){
        try{
            service.updateRemainder(id,count);
            return "ok";
        }catch (Exception e){
            return "error : "+e.getMessage();
        }
    }

    @GetMapping("/find/{id}")
    public Good find(@PathVariable("id") Long id){
        try{
            return service.find(id);
        }catch (Exception e){
            System.out.println("find good fail : "+e.getMessage());
            return null;
        }
    }
}
