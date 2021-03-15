package com.edu.neu.studyapp.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Goods {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer goodsId;
  private String goodsName;
  private String goodsPrice;
  private String goodsDescription;
  private Integer goodsStock;
  private String goodsIcon;
  private Integer goodsType;
  private String goodsTag;

}
