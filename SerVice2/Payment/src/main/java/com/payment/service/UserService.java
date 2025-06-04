package com.payment.service;

import com.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-server")
public interface UserService {
    @PostMapping("/server/user/insert")
    public String insert(@RequestBody User user);

    @PutMapping("/server/user/update/{id}/{count}")
    public String update(@PathVariable("id") Integer id, @PathVariable("count") Integer count);
}
