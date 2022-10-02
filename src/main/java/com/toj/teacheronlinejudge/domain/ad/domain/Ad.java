package com.toj.teacheronlinejudge.domain.ad.domain;

import com.toj.teacheronlinejudge.domain.ad.domain.type.Status;
import com.toj.teacheronlinejudge.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ad_tbl")
public class Ad extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_id")
    private Long id;

    @Column(name = "img", nullable = false)
    private String img;

    @Column(name = "advertiser", nullable = false)
    private String advertiser;

    @Column(name = "link")
    private String link;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Ad(String img, String advertiser, String link, Status status) {
        this.img = img;
        this.advertiser = advertiser;
        this.link = link;
        this.status = status;
    }

    public void updateStatus() {
        if(this.status.equals(Status.OPEN)) {
            this.status = Status.CLOSE;
        }
        else {
            this.status = Status.OPEN;
        }
    }
}
