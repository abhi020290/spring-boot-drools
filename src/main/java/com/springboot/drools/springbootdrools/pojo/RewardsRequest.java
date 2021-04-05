package com.springboot.drools.springbootdrools.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RewardsRequest {
    private String userId;
    private String orderId;
    private String userType;
    private String amount;
}
