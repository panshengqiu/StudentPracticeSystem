package cn.edu.bjut.hrregister.mapper;

import cn.edu.bjut.entity.hr.HumanResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HrRegisterMapper {
    public int register(int id, String username, String password);

    public String firmIsRegister(String name, String creditCode);

    public String isFirmApproval(String name, String creditCode);

    public int selectEnterpriseId(String name, String creditCode);

    public HumanResource selectHrUsername(String username);
}