package com.fastmoney.fast_money.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="code")
public class CodeEntity{
    private String _id;
    private String url;
    private String symbol;
    private String status;

    /**
     * @return the _id
     */
    public String get_id() {
        return _id;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param _id the _id to set
     */
    public void set_id(String _id) {
        this._id = _id;
    }



}