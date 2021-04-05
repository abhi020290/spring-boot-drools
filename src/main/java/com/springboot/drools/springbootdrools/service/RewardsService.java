package com.springboot.drools.springbootdrools.service;

import com.springboot.drools.springbootdrools.pojo.RewardsRequest;
import com.springboot.drools.springbootdrools.pojo.RewardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class RewardsService {

    @Autowired
    public KieContainer kieContainer;

    public RewardsResponse getRewards(RewardsRequest rewardsRequest) {
        RewardsResponse rewardsResponse = new RewardsResponse();
        rewardsResponse.setOrderId(rewardsRequest.getOrderId());
        rewardsResponse.setUserId(rewardsRequest.getUserId());
        rewardsResponse.setUserType(rewardsRequest.getUserType());
        rewardsResponse.setAmount(rewardsRequest.getAmount());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(rewardsRequest);
        kieSession.fireAllRules();
        kieContainer.dispose();
        return rewardsResponse;
    }

    @Scheduled(fixedDelay = 3000, initialDelay = 500)
    public RewardsResponse scheduledRewards() {
        RewardsRequest rewardsRequest = new RewardsRequest();
        rewardsRequest.setUserType("CORE");

        RewardsResponse rewardsResponse = new RewardsResponse();
        rewardsResponse.setUserType(rewardsRequest.getUserType());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(rewardsRequest);
        kieSession.fireAllRules();
        kieContainer.dispose();
        log.info("RewardsResponse {} ",rewardsRequest,toString() );
        //log.info("RewardsResponse {} ",rewardsResponse,toString() );
        return rewardsResponse;
    }
}
