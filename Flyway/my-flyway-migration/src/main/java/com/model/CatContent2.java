package com.model;

import java.util.List;

public class CatContent2 {

  private String phoneNumber;
  private List<String> descriptions;
  private String type;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<String> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(List<String> descriptions) {
    this.descriptions = descriptions;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "CatContent{" +
        "phoneNumber='" + phoneNumber + '\'' +
        ", descriptions=" + descriptions +
        ", type=" + type +
        '}';
  }
}
