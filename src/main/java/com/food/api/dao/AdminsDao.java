package com.food.api.dao;

import com.food.api.common.BaseDao;
import com.food.api.dto.AdminsDTO;
import com.food.api.dto.DataDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @description: 管理员持久层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
public interface AdminsDao extends BaseDao<AdminsDTO> {

    @Select("\n" +
            "SELECT DATE(create_time) AS name, SUM(CAST(total_price AS DECIMAL(10,2))) AS value\n" +
            "FROM orders\n" +
            "WHERE order_status != -1 and  `order_status` != 7\n" +
            "AND create_time >= NOW() - INTERVAL #{num} DAY\n" +
            "GROUP BY DATE(create_time)\n" +
            "ORDER BY name;\n")
    List<DataDTO> getOrderTotalDay(Integer day);

    @Select("select t.type_name as name ,type_id,count(*) value from dish g left join dish_type t on t.id = g.type_id group by type_id")
    List<DataDTO> typeCount();

    @Select("select t.type_name as name,g.type_id,sum(o.num * o.dish_price) as value from order_detail o left join dish g on g.id =  o.dish_id left join dish_type t on t.id = g.type_id group by g.type_id")
    List<DataDTO> typeMoney();


}
