package com.matchgetit.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matchgetit.backend.constant.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "member")
@Data
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long userId;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "PARTY_ID", nullable=true)
    private PartyEntity party;
    @Column(name = "BANK_ID")
    private String bankId;
    @Column(name = "PN")
    private String pn;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PW")
    private String pw;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NAMEEDIT")
    private String nameEdit;
    @Column(name = "B_DAY")
    @Temporal(TemporalType.DATE)
    private Date bDay;
    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "PRFCN")
    private Proficiency prfcn;
    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_TYPE")
    private AccountType accountType;
    @Column(name = "REG_DATE")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "LOGIN_TYPE")
    private LogInType loginType;
    @Column(name = "ACCOUNT_STATE")
    @Enumerated(EnumType.STRING) //로그인 상태 변경
    private AccountState accountState;
    @Column(name = "CHARGE_ID")
    private Long chargeId;
    @Column(name = "OWNED_CRD")
    private Long ownedCrd;
    @Column(name = "OWNED_POINT")
    private Long ownedPoint;
    @Column(name = "WIN")
    private Long win;
    @Column(name = "LOSE")
    private Long lose;
    @Column(name = "RATING")
    private Long rating;
    @Column(name = "BAN_DATE_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date banDateStart;
    @Column(name = "BAN_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date banDateEnd;
    @Column(name="BAN_REASON")
    private String banReason;
    @Column(name = "RECOMMEND_COUNT")
    private String recommendCount;
    @Column(name = "LAST_CONNECTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastConnectionDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "PAY_STATE")
    private PayState payState;
    public void updateProficiencyBasedOnRating() {
        if (rating >= 0 && rating <= 400) {
            prfcn = Proficiency.BEGINNER;
        } else if (rating >= 401 && rating <= 700) {
            prfcn = Proficiency.MIDDLE;
        } else if (rating >= 701 && rating <= 1100) {
            prfcn = Proficiency.ADVANCED;
        } else {
            prfcn = Proficiency.PROFESSIONAL;
        }
    }
}

