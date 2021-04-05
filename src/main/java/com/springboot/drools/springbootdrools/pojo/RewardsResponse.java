package com.springboot.drools.springbootdrools.pojo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
public class RewardsResponse {
    private String userId;
    private String orderId;
    private String userType;
    private String amount;
    private String rewardsPoint;
    private String valueOfRewards;
}
