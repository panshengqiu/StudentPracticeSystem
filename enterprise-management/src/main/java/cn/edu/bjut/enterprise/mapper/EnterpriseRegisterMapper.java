package cn.edu.bjut.enterprise.mapper;

import cn.edu.bjut.entity.enterprise.Enterprise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnterpriseRegisterMapper {
    @Insert("insert into enterprise(name, address, credit_code, description,status,logo_url) " +
            "values (#{name},#{address},#{creditCode},#{description},'待审核',#{logoUrl})")
    public int insert(Enterprise enterprise);
}
