package com.msr.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wjing
 * @create 2024-11-14 下午3:09
 * @desc
 * 封装文章分页的查询
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleQuery extends PageQuery{
  private Integer categoryId;
  private String state;
}
