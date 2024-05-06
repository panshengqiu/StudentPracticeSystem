package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainFilterPost {
    //只有地域条件时
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.work_city=#{work_city} AND p.name LIKE CONCAT('%', #{name}, '%');")
    List<PostAndEnterprise> getPostByRegion(String work_city, String name);

    //只有月份条件
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.month=#{month} AND p.name LIKE CONCAT('%', #{name}, '%');")
    List<PostAndEnterprise> getPostByFilterMonth(String month,String name);

    //只有薪资条件
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.pay>#{salary} AND p.name LIKE CONCAT('%', #{name}, '%');")
    List<PostAndEnterprise> getPostByFilterSalary(String salary,String name);

    //只有岗位类别不筛选
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%');")
    List<PostAndEnterprise> getPostInfo(String name);

    //地域+月份信息
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE  p.name LIKE CONCAT('%', #{name}, '%')AND p.work_city = #{work_city} AND p.month=#{month};")
    List<PostAndEnterprise> getPostByFilterRegionMonth(String name,String work_city,String month);

    //地域+薪资信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.work_city = #{work_city} AND p.pay>#{salary};")
    List<PostAndEnterprise> getPostByFilterRegionSalary(String name,String work_city,String salary);

    //月份+薪资信息
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.month = #{month} AND p.pay>#{salary};")
    List<PostAndEnterprise> getPostByFilterMonthSalary(String name,String month,String salary);

    //全筛选
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.work_city = #{work_city} AND p.month = #{month} AND p.pay>#{salary};")
    List<PostAndEnterprise> getPostByFilterAll(String name,String work_city,String month,String salary);

    //----------------------------------------最新时间-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //只有地域条件时
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.work_city=#{work_city} AND p.name LIKE CONCAT('%', #{name}, '%')ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByRegionTime(String work_city,String name);

    //只有月份条件
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.month=#{month} AND p.name LIKE CONCAT('%', #{name}, '%')ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterMonthTime(String month,String name);

    //只有薪资条件
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.pay>#{salary} AND p.name LIKE CONCAT('%', #{name}, '%')ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterSalaryTime(String salary,String name);

    //只有岗位类别不筛选
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%')ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostInfoTime(String name);

    //地域+月份信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE  p.name LIKE CONCAT('%', #{name}, '%')AND p.work_city = #{work_city} AND p.month=#{month}ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterRegionMonthTime(String name,String work_city,String month);

    //地域+薪资信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.work_city = #{work_city} AND p.pay>#{salary}ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterRegionSalaryTime(String name,String work_city,String salary);

    //月份+薪资信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.month = #{month} AND p.pay>#{salary}ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterMonthSalaryTime(String name,String month,String salary);

    //全筛选
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.work_city = #{work_city} AND p.month = #{month} AND p.pay>#{salary}ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterAllTime(String name,String work_city,String month,String salary);
}
