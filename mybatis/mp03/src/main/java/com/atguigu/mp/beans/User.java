package com.atguigu.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;

/**
 * @author Gakki
 * @date 2018/12/28 - 18:05
 */
@Data
public class User {
    private Integer id;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String name;

    @TableLogic
    private Integer logicFlag;

}
