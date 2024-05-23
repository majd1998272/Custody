package com.example.demo.dto;

import lombok.Data;

@Data
public class UpadateTemporary {
   private Boolean temporary;
   private Integer itemId;

    public UpadateTemporary() {
    }

    public UpadateTemporary(Boolean temporary, Integer itemId) {
        this.temporary = temporary;
        this.itemId = itemId;
    }

    public Boolean getTemporary() {
        return temporary;
    }

    public void setTemporary(Boolean temporary) {
        this.temporary = temporary;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
