package tk.mybatis.mapper.mapper;

import java.util.List;
import tk.mybatis.mapper.model.Stu;

public interface StuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stu record);

    Stu selectByPrimaryKey(Integer id);

    List<Stu> selectAll();

    int updateByPrimaryKey(Stu record);
}