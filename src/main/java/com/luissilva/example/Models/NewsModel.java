package com.luissilva.example.Models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="news")
@Entity
@Getter
@Setter
public class NewsModel implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.UUID)
  @Column(name="news_id")
  UUID newsId;

  @Column(name="publisher_id")
  UUID publisherId;

  @Column
  String content;
  @Column
  String title;
}
