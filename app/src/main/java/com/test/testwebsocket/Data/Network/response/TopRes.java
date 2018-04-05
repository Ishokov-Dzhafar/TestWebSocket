package com.test.testwebsocket.Data.Network.response;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dzhafar on 05.04.18.
 */

public class TopRes implements Serializable {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("marketPercent")
    @Expose
    private String marketPercent;
    @SerializedName("bidSize")
    @Expose
    private String bidSize;
    @SerializedName("bidPrice")
    @Expose
    private String bidPrice;
    @SerializedName("askSize")
    @Expose
    private String askSize;
    @SerializedName("askPrice")
    @Expose
    private String askPrice;
    @SerializedName("volume")
    @Expose
    private String volume;
    @SerializedName("lastSalePrice")
    @Expose
    private String lastSalePrice;
    @SerializedName("lastSaleSize")
    @Expose
    private String lastSaleSize;
    @SerializedName("lastSaleTime")
    @Expose
    private String lastSaleTime;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("sector")
    @Expose
    private String sector;
    @SerializedName("securityType")
    @Expose
    private String securityType;
    private final static long serialVersionUID = -6158487119648956898L;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMarketPercent() {
        return marketPercent;
    }

    public void setMarketPercent(String marketPercent) {
        this.marketPercent = marketPercent;
    }

    public String getBidSize() {
        return bidSize;
    }

    public void setBidSize(String bidSize) {
        this.bidSize = bidSize;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getAskSize() {
        return askSize;
    }

    public void setAskSize(String askSize) {
        this.askSize = askSize;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLastSalePrice() {
        return lastSalePrice;
    }

    public void setLastSalePrice(String lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
    }

    public String getLastSaleSize() {
        return lastSaleSize;
    }

    public void setLastSaleSize(String lastSaleSize) {
        this.lastSaleSize = lastSaleSize;
    }

    public String getLastSaleTime() {
        return lastSaleTime;
    }

    public void setLastSaleTime(String lastSaleTime) {
        this.lastSaleTime = lastSaleTime;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }
}
