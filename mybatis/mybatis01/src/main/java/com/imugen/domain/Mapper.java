package com.imugen.domain;

/**
 * @author Daniel Liu 2020/2/12 7:31
 */
public class Mapper {
   private String QueryString;
   private String ResultType;

    public String getQueryString() {
        return QueryString;
    }

    public void setQueryString(String queryString) {
        QueryString = queryString;
    }

    public String getResultType() {
        return ResultType;
    }

    public void setResultType(String resultType) {
        ResultType = resultType;
    }
}