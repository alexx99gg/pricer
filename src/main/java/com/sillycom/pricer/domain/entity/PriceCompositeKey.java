package com.sillycom.pricer.domain.entity;

import java.io.Serializable;
import java.util.Date;


public class PriceCompositeKey implements Serializable {
  private Integer brandId;
  private Integer productId;
  private Date startDate;
  private Date endDate;
  private Integer priority;
  private String curr; // Abbreviate currency to curr is a terrible idea. Doing this for naming consistency with the problem statement.
}
