package com.fanchen.pojo;

/**
 * Created by Administrator on 2017/10/24.
 */
public class RankingType {
    private int type;
    private int method;
    private int sort;
    private int page;
    private int ranking;

    @Override
    public String toString() {
        return "RankingType{" +
                "type=" + type +
                ", method=" + method +
                ", sort=" + sort +
                ", page=" + page +
                ", ranking=" + ranking +
                '}';
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {

        return ranking;
    }

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
    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {

        return page;
    }

}
