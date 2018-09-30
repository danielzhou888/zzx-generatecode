package com.zzx.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 说明：order
 * 创建人：zhouzhixiang
 * 创建时间：2018-09-10
 */
@TableName("sc_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    /**
     * Order ID 主键, 自增
     */
    @TableId(value="orderid", type= IdType.AUTO)
    private Integer orderid;

    /**
     * 订单编号
     */
    private String orderno;
    /**
     * 追溯码
     */
    private String traceno;
    /**
     * 客户ID
     */
    private Integer userid;
    /**
     * 商店ID
     */
    private Integer shopid;
    /**
     * 发货方式
     */
    private String deliveryways;
    /**
     * 订单状态数值   0-未付款,1-已付款,2-已发货,3-已签收,4-退货申请,5-退货中,6-已退货,7-取消交易
     */
    private Integer orderstatusno;
    /**
     * 追溯二维码
     */
    private String qrcode;
    /**
     * 订单状态   0-未付款,1-已付款,2-已发货,3-已签收,4-退货申请,5-退货中,6-已退货,7-取消交易,8-商家备货中
     */
    private String orderstatus;
    /**
     * 商品数量
     */
    private Integer count;
    /**
     * 
     */
    private Double origintotalprice;
    /**
     * 折扣后总价
     */
    private Double discountprice;
    /**
     * 订单金额（实际付款金额）
     */
    private Double orderTotalPrice;
    /**
     * 运费金额
     */
    private Double logisticsFee;
    /**
     * 是否开箱验货   0-否，1-是
     */
    private Integer isUnpackingInspection;
    /**
     * 是否开具发票  0-否，1-是
     */
    private Integer isCheck;
    /**
     * 发票编号
     */
    private Integer checkid;
    /**
     * 收货地址ID
     */
    private Integer addressid;
    /**
     * 订单物流编号
     */
    private String orderLogisticsNo;
    /**
     * 订单支付单号
     */
    private String outTradeNo;
    /**
     * 订单支付渠道
     */
    private String payChannel;
    /**
     * 下单时间
     */
    private Date ordertime;
    /**
     * 付款时间
     */
    private Date paytime;
    /**
     * 发货时间
     */
    private Date deliverytime;
    /**
     * 客户备注
     */
    private String remark;
    /**
     * 
     */
    private Integer state;
    /**
     * 
     */
    private String creatername;
    /**
     * 
     */
    private Date createtime;
    /**
     * 
     */
    private String updatername;
    /**
     * 
     */
    private Date updatetime;

    // TODO 生成get/set方法和toString方法
    public void setOrderid(Integer orderid){ this.orderid = orderid; }

    public Integer getOrderid() { return orderid; }

    public void setOrderno (String orderno){ this.orderno = orderno; }

    public String getOrderno() { return orderno; }
    public void setTraceno (String traceno){ this.traceno = traceno; }

    public String getTraceno() { return traceno; }
    public void setUserid (Integer userid){ this.userid = userid; }

    public Integer getUserid() { return userid; }
    public void setShopid (Integer shopid){ this.shopid = shopid; }

    public Integer getShopid() { return shopid; }
    public void setDeliveryways (String deliveryways){ this.deliveryways = deliveryways; }

    public String getDeliveryways() { return deliveryways; }
    public void setOrderstatusno (Integer orderstatusno){ this.orderstatusno = orderstatusno; }

    public Integer getOrderstatusno() { return orderstatusno; }
    public void setQrcode (String qrcode){ this.qrcode = qrcode; }

    public String getQrcode() { return qrcode; }
    public void setOrderstatus (String orderstatus){ this.orderstatus = orderstatus; }

    public String getOrderstatus() { return orderstatus; }
    public void setCount (Integer count){ this.count = count; }

    public Integer getCount() { return count; }
    public void setOrigintotalprice (Double origintotalprice){ this.origintotalprice = origintotalprice; }

    public Double getOrigintotalprice() { return origintotalprice; }
    public void setDiscountprice (Double discountprice){ this.discountprice = discountprice; }

    public Double getDiscountprice() { return discountprice; }
    public void setOrderTotalPrice (Double orderTotalPrice){ this.orderTotalPrice = orderTotalPrice; }

    public Double getOrderTotalPrice() { return orderTotalPrice; }
    public void setLogisticsFee (Double logisticsFee){ this.logisticsFee = logisticsFee; }

    public Double getLogisticsFee() { return logisticsFee; }
    public void setIsUnpackingInspection (Integer isUnpackingInspection){ this.isUnpackingInspection = isUnpackingInspection; }

    public Integer getIsUnpackingInspection() { return isUnpackingInspection; }
    public void setIsCheck (Integer isCheck){ this.isCheck = isCheck; }

    public Integer getIsCheck() { return isCheck; }
    public void setCheckid (Integer checkid){ this.checkid = checkid; }

    public Integer getCheckid() { return checkid; }
    public void setAddressid (Integer addressid){ this.addressid = addressid; }

    public Integer getAddressid() { return addressid; }
    public void setOrderLogisticsNo (String orderLogisticsNo){ this.orderLogisticsNo = orderLogisticsNo; }

    public String getOrderLogisticsNo() { return orderLogisticsNo; }
    public void setOutTradeNo (String outTradeNo){ this.outTradeNo = outTradeNo; }

    public String getOutTradeNo() { return outTradeNo; }
    public void setPayChannel (String payChannel){ this.payChannel = payChannel; }

    public String getPayChannel() { return payChannel; }
    public void setOrdertime (Date ordertime){ this.ordertime = ordertime; }

    public Date getOrdertime() { return ordertime; }
    public void setPaytime (Date paytime){ this.paytime = paytime; }

    public Date getPaytime() { return paytime; }
    public void setDeliverytime (Date deliverytime){ this.deliverytime = deliverytime; }

    public Date getDeliverytime() { return deliverytime; }
    public void setRemark (String remark){ this.remark = remark; }

    public String getRemark() { return remark; }
    public void setState (Integer state){ this.state = state; }

    public Integer getState() { return state; }
    public void setCreatername (String creatername){ this.creatername = creatername; }

    public String getCreatername() { return creatername; }
    public void setCreatetime (Date createtime){ this.createtime = createtime; }

    public Date getCreatetime() { return createtime; }
    public void setUpdatername (String updatername){ this.updatername = updatername; }

    public String getUpdatername() { return updatername; }
    public void setUpdatetime (Date updatetime){ this.updatetime = updatetime; }

    public Date getUpdatetime() { return updatetime; }

    @Override
    public Serializable pkVal() {
        return this.orderid;
    }

}
