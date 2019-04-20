package com.fastmoney.fast_money.entity;

public class CompanyCodeEntity{
    /**
     * 主键
     */
    private Long id;
    /***
     * 公司名称
     */
    private String name; 
    /**
     * 股票代码
     */
    private String symbol;
    /***
     * 代码状态
     */
    private String status;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }


}