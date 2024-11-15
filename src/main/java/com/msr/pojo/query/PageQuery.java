package com.msr.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wjing
 * @create 2024-11-14 下午3:03
 * @desc
 * 封装分页查询的条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery {
   private Integer pageNum;
   private Integer pageSize;
}
