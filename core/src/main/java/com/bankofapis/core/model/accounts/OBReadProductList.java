package com.bankofapis.core.model.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OBReadProductList {

    @JsonProperty("Product")
    private List<OBReadProduct> productList = null;

    public List<OBReadProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<OBReadProduct> productList) {
        this.productList = productList;
    }
}