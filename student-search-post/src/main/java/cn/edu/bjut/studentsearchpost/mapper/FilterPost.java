package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostAndEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FilterPost {
    //只有地域条件
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name \n" +
            "FROM post p \n" +
            "JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id \n" +
            "WHERE p.work_city = #{work_city}\n" +
            "AND p.small_post_id= (\n" +
            "    SELECT id \n" +
            "    FROM post_small_type \n" +
            "    WHERE name = #{smallType}\n" +
            ");")
    List<PostAndEnterprise> getPostByFilter(String work_city,String smallType);

    //只有月份条件
    @Select("SELECT p.*,e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.month=#{month} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType});")
    List<PostAndEnterprise> getPostByFilterMonth(String month,String smallType);

    //只有薪资条件
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.pay>#{salary} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType});")
    List<PostAndEnterprise> getPostByFilterSalary(String salary,String smallType);

    //只有岗位类别不筛选
    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType});")
    List<PostAndEnterprise> getPostInfo(String smallType);

    //地域+月份信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.month=#{month};")
    List<PostAndEnterprise> getPostByFilterRegionMonth(String smallType,String work_city,String month);

    //地域+薪资信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.pay>#{salary};")
    List<PostAndEnterprise> getPostByFilterRegionSalary(String smallType,String work_city,String salary);

    //月份+薪资信息
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.month = #{month} AND p.pay>#{salary};")
    List<PostAndEnterprise> getPostByFilterMonthSalary(String smallType,String month,String salary);

    //全筛选
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.month = #{month} AND p.pay>#{salary};")
    List<PostAndEnterprise> getPostByFilterAll(String smallType,String work_city,String month,String salary);

    //-------------------------------------------------最新时间-----------------------------------------------------------------
    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.work_city=#{work_city} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType}) ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByRegionTime(String work_city,String smallType);

    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.month=#{month} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType}) ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterMonthTime(String month,String smallType);

    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE p.pay>#{salary} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType}) ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterSalaryTime(String salary,String smallType);

    @Select("SELECT p.*,e.logo_url, e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.month=#{month} ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterRegionMonthTime(String smallType,String work_city,String month);

    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.pay>#{salary} ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterRegionSalaryTime(String smallType,String work_city,String salary);

    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.month = #{month} AND p.pay>#{salary} ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterMonthSalaryTime(String smallType,String month,String salary);

    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.month = #{month} AND p.pay>#{salary} ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostByFilterAllTime(String smallType,String work_city,String month,String salary);

    @Select("SELECT p.*, e.logo_url,e.name as enterprise_name FROM post p JOIN enterprise e JOIN practice.human_resource hr ON p.hr_id = hr.id AND hr.firm_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})ORDER BY p.delivery_deadline;")
    List<PostAndEnterprise> getPostInfoTime(String smallType);
}
