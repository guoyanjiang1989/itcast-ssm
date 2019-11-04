package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Order {

    private Integer id;
    private String orderNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date orderTime;
    private String orderTimeStr;
    private Integer peopleCount;
    private String orderDesc;
    private Integer payType;//支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;
    private Integer orderStatus;//订单状态(0 未支付 1 已支付)
    private String orderStatusStr;
    private Integer productID;
    private Integer memberID;
    private Product product;
    private List<Traveller> traveller;
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Order() {
    }

    public Order(Integer id, String orderNum, Date orderTime, String orderTimeStr, Integer peopleCount, String orderDesc, Integer payType, String payTypeStr, Integer orderStatus, String orderStatusStr, Integer productID, Integer memberID, Product product, List<Traveller> traveller, Member member) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderTime = orderTime;
        this.orderTimeStr = orderTimeStr;
        this.peopleCount = peopleCount;
        this.orderDesc = orderDesc;
        this.payType = payType;
        this.payTypeStr = payTypeStr;
        this.orderStatus = orderStatus;
        this.orderStatusStr = orderStatusStr;
        this.productID = productID;
        this.memberID = memberID;
        this.product = product;
        this.traveller = traveller;
        this.member = member;
    }

    public List<Traveller> getTraveller() {
        return traveller;
    }

    public void setTraveller(List<Traveller> traveller) {
        this.traveller = traveller;
    }

    public String getOrderTimeStr() {
        if (orderTime != null){
            orderTimeStr = DateUtils.DateToString(orderTime);
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付方式(0 支付宝 1 微信 2其它)
        if (payType == 0){
            payTypeStr = "支付宝";
        }else if (payType == 1){
            payTypeStr = "微信";
        }else if (payType == 2){
            payTypeStr = "其它";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if (orderStatus == 0){
            orderStatusStr = "未支付";
        }
        if (orderStatus == 1){
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", productID=" + productID +
                ", memberID=" + memberID +
                ", product=" + product +
                ", traveller=" + traveller +
                ", member=" + member +
                '}';
    }
}
