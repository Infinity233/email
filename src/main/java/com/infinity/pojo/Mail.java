package com.infinity.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String summary;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;

}
