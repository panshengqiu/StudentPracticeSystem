package cn.edu.bjut.enterpriseregister.mapper;

import cn.edu.bjut.entity.enterprise.Enterprise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnterpriseRegisterMapper {
    @Insert("insert into enterprise(name, address, credit_code, description) values (#{name},#{address},#{creditCode},#{description})")
    public int insert(Enterprise enterprise);
}
