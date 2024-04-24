package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainFilterPost {
    //只有地域条件时
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.work_city=#{work_city} AND p.name LIKE CONCAT('%', #{name}, '%');")
    List<Post> getPostByRegion(String work_city,String name);

    //只有月份条件
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.month=#{month} AND p.name LIKE CONCAT('%', #{name}, '%');")
    List<Post> getPostByFilterMonth(String month,String name);

    //只有薪资条件
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.pay>#{salary} AND p.name LIKE CONCAT('%', #{name}, '%');")
    List<Post> getPostByFilterSalary(String salary,String name);

    //只有岗位类别不筛选
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%');")
    List<Post> getPostInfo(String name);

    //地域+月份信息
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE  p.name LIKE CONCAT('%', #{name}, '%')AND p.work_city = #{work_city} AND p.month=#{month};")
    List<Post> getPostByFilterRegionMonth(String name,String work_city,String month);

    //地域+薪资信息
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.work_city = #{work_city} AND p.pay>#{salary};")
    List<Post> getPostByFilterRegionSalary(String name,String work_city,String salary);

    //月份+薪资信息
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.month = #{month} AND p.pay>#{salary};")
    List<Post> getPostByFilterMonthSalary(String name,String month,String salary);

    //全筛选
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.work_city = #{work_city} AND p.month = #{month} AND p.pay>#{salary};")
    List<Post> getPostByFilterAll(String name,String work_city,String month,String salary);

    //----------------------------------------最新时间-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //只有地域条件时
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.work_city=#{work_city} AND p.name LIKE CONCAT('%', #{name}, '%')ORDER BY p.delivery_deadline;")
    List<Post> getPostByRegionTime(String work_city,String name);

    //只有月份条件
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.month=#{month} AND p.name LIKE CONCAT('%', #{name}, '%')ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterMonthTime(String month,String name);

    //只有薪资条件
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.pay>#{salary} AND p.name LIKE CONCAT('%', #{name}, '%')ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterSalaryTime(String salary,String name);

    //只有岗位类别不筛选
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%')ORDER BY p.delivery_deadline;")
    List<Post> getPostInfoTime(String name);

    //地域+月份信息
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE  p.name LIKE CONCAT('%', #{name}, '%')AND p.work_city = #{work_city} AND p.month=#{month}ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterRegionMonthTime(String name,String work_city,String month);

    //地域+薪资信息
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.work_city = #{work_city} AND p.pay>#{salary}ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterRegionSalaryTime(String name,String work_city,String salary);

    //月份+薪资信息
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.month = #{month} AND p.pay>#{salary}ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterMonthSalaryTime(String name,String month,String salary);

    //全筛选
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.name LIKE CONCAT('%', #{name}, '%') AND p.work_city = #{work_city} AND p.month = #{month} AND p.pay>#{salary}ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterAllTime(String name,String work_city,String month,String salary);
}
