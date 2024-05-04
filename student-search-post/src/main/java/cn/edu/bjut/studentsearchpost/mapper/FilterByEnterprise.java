package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.PostAndEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface FilterByEnterprise {
    //只有地域条件
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name \n" +
            "FROM post p \n" +
            "JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id \n" +
            "WHERE p.work_city = #{work_city} AND e.name=#{enterpriseName};" )

    List<PostAndEnterprise> getPostByFilter(String work_city, String enterpriseName);

    //只有月份条件
    @Select("SELECT p.*,e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.month=#{month} AND e.name=#{enterpriseName};")
    List<PostAndEnterprise> getPostByFilterMonth(String month,String enterpriseName);

    //只有薪资条件
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.pay>#{salary} AND e.name=#{enterpriseName};")
    List<PostAndEnterprise> getPostByFilterSalary(String salary,String enterpriseName);


    //地域+月份信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE e.name=#{enterpriseName} AND p.work_city = #{work_city} AND p.month=#{month};")
    List<PostAndEnterprise> getPostByFilterRegionMonth(String enterpriseName,String work_city,String month);

    //地域+薪资信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE e.name=#{enterpriseName} AND p.work_city = #{work_city} AND p.pay>#{salary};")
    List<PostAndEnterprise> getPostByFilterRegionSalary(String enterpriseName,String work_city,String salary);

    //月份+薪资信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE e.name=#{enterpriseName} AND p.month = #{month} AND p.pay>#{salary};")
    List<PostAndEnterprise> getPostByFilterMonthSalary(String enterpriseName,String month,String salary);

    //只有公司名称
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE e.name=#{enterpriseName};")
    List<PostAndEnterprise> getPostOnlyEnterprise(String enterpriseName);

    //全筛选
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE e.name=#{enterpriseName} AND p.work_city = #{work_city} AND p.month = #{month} AND p.pay>#{salary};")
    List<PostAndEnterprise> getPostByFilterAll(String enterpriseName,String work_city,String month,String salary);
}
