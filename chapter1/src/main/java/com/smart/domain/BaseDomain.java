package com.smart.domain;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author: wuchao
 * @date： 2017/2/20
 */
public class BaseDomain implements Serializable {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
