package org.entity;

import java.util.Date;

public class StudentDO {
    private int id;
    private String xingming;
    private String bianhao;
    private Date shengri;
    private String jiaxiang;
    private Double yuwen_defeng;
    private Double yingyu_defeng;
    private Double shuxue_defeng;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public Date getShengri() {
        return shengri;
    }

    public void setShengri(Date shengri) {
        this.shengri = shengri;
    }

    public String getJiaxiang() {
        return jiaxiang;
    }

    public void setJiaxiang(String jiaxiang) {
        this.jiaxiang = jiaxiang;
    }

    public Double getYuwen_defeng() {
        return yuwen_defeng;
    }

    public void setYuwen_defeng(Double yuwen_defeng) {
        this.yuwen_defeng = yuwen_defeng;
    }

    public Double getYingyu_defeng() {
        return yingyu_defeng;
    }

    public void setYingyu_defeng(Double yingyu_defeng) {
        this.yingyu_defeng = yingyu_defeng;
    }

    public Double getShuxue_defeng() {
        return shuxue_defeng;
    }

    public void setShuxue_defeng(Double shuxue_defeng) {
        this.shuxue_defeng = shuxue_defeng;
    }
}
