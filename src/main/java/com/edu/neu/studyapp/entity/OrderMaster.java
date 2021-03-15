package com.edu.neu.studyapp.entity;

import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
public class OrderMaster {


  private String orderId;
  private Integer userId;
  private String buyerName;
  private String buyerPhone;
  private String buyerAddress;
  private Integer goodsId;
  private String goodsName;
  private Integer goodsQuantity;
  private String goodsIcon;
  private String goodsPrice;
  private String payStatus;
  private String createTime;
  private String updateTime;

}
