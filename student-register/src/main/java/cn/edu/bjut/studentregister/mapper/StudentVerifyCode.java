package cn.edu.bjut.studentregister.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentVerifyCode {
    @Insert("insert into code(phone,code)values(#{phone},#{code})")
    void insertCode(String phone,String code);

    @Select("SELECT code FROM code WHERE phone = #{phone} ORDER BY id DESC LIMIT 1")
    String getMaxCodeByPhone(String phone);

}
