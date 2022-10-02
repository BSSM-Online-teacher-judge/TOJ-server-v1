package com.toj.teacheronlinejudge.domain.ad.domain;

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

    @Builder
    public Ad(String img, String advertiser, String link) {
        this.img = img;
        this.advertiser = advertiser;
        this.link = link;
    }
}
