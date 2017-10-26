package com.fanchen.pojo;

/**
 * Created by Administrator on 2017/10/24.
 */
public class RankingType {
    private int type;
    private int method;
    private int sort;

    public void setType(int type) {
        this.type = type;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getMethod() {

        return method;
    }

    public int getSort() {
        return sort;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RankingType{" +
                "type=" + type +
                ", method=" + method +
                ", sort=" + sort +
                '}';
    }
}
