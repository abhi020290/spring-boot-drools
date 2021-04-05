package com.springboot.drools.springbootdrools.resource;

import com.springboot.drools.springbootdrools.pojo.RewardsRequest;
import com.springboot.drools.springbootdrools.pojo.RewardsResponse;
import com.springboot.drools.springbootdrools.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards")
public class RewardsResource {

    @Autowired
    public RewardsService rewardsService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RewardsResponse> getRewards(@RequestBody RewardsRequest rewardsRequest) {
        RewardsResponse rewards = rewardsService.getRewards(rewardsRequest);
        return ResponseEntity.status(200).body(rewards);
    }
}
