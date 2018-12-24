package com.infinity.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    // 收件
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "mail_receiver"
            , joinColumns = @JoinColumn(name = "mail_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<Mail> receivers;

    // 发件
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;
}
