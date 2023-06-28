package com.matchgetit.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matchgetit.backend.constant.*;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberDTO {
        private Long userId;
        @JsonIgnore
        @JsonIgnoreProperties
        private PartyDTO party;
        private String bankId;
        private String pn;
        private String email;
        private String pw;
        private String name;
        private String nameEdit;
        private Date bDay;
        private Gender gender;
        private Proficiency prfcn;
        private AccountType accountType;
        private Date regDate;
        private LogInType loginType;
        private AccountState accountState; //로그인 상태 변경
        private Long chargeId;
        private Long ownedCrd;
        private Long ownedPoint;
        private Long win;
        private Long lose;
        private Long rating;
        private Date banDateStart;
        private Date banDateEnd;
        private String banReason;
        private String recommendCount;
        private Date lastConnectionDate;
        private PayState payState;
}