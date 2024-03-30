package cn.edu.bjut.manageridentified.mapper;

import cn.edu.bjut.entity.enterprise.Enterprise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManagerIdentifiedMapper {

//    @Select("select * from enterprise where status = '待审核';")
    public List<Enterprise> selectPendingFirm();

    @MapKey("id")
    List<Map<Object, Object>> selectApprovalFirm();

    public Enterprise selectEnterpriseDetail(Enterprise enterprise);
}
