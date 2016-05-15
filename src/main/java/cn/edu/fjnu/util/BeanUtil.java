package cn.edu.fjnu.util;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.edu.fjnu.entity.PageResult;

public class BeanUtil {	 
    public static <T> PageResult<T> toPagedResult(List<T> datas) {
        PageResult<T> result = new PageResult<T>();
        if (datas instanceof Page) {
            Page page = (Page) datas;
            result.setPageNo(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
        }
        else {
            result.setPageNo(1);
            result.setPageSize(datas.size());
            result.setDataList(datas);
            result.setTotal(datas.size());
        }
 
        return result;
    }
    
    
    //验证pageNo和pageSize
    public static void pageParam(Integer pageNo,Integer pageSize){
    	pageNo=pageNo==null?1:pageNo;
    	pageSize=pageSize==null?10:pageSize;
    	PageHelper.startPage(pageNo,pageSize);//告知拦截器，页面传递的分页参数是这两个
    }
 
}
