package cn.edu.bjut.studentsearchpost.mapper;

import cn.edu.bjut.entity.post.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FilterPost {
    //只有地域条件
    @Select("SELECT p.*, e.name as enterprise_name \n" +
            "FROM post p \n" +
            "JOIN enterprise e on p.hr_id = e.id \n" +
            "WHERE p.work_city = #{work_city}\n" +
            "AND p.small_post_id= (\n" +
            "    SELECT id \n" +
            "    FROM post_small_type \n" +
            "    WHERE name = #{smallType}\n" +
            ");")
    List<Post> getPostByFilter(String work_city, String smallType);

    //只有月份条件
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.month=#{month} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType});")
    List<Post> getPostByFilterMonth(String month, String smallType);

    //只有薪资条件
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.pay>#{salary} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType});")
    List<Post> getPostByFilterSalary(String salary, String smallType);

    //只有岗位类别不筛选
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType});")
    List<Post> getPostInfo(String smallType);

    //地域+月份信息
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.month=#{month};")
    List<Post> getPostByFilterRegionMonth(String smallType, String work_city, String month);

    //地域+薪资信息
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.pay>#{salary};")
    List<Post> getPostByFilterRegionSalary(String smallType, String work_city, String salary);

    //月份+薪资信息
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.month = #{month} AND p.pay>#{salary};")
    List<Post> getPostByFilterMonthSalary(String smallType, String month, String salary);

    //全筛选
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.month = #{month} AND p.pay>#{salary};")
    List<Post> getPostByFilterAll(String smallType, String work_city, String month, String salary);

    //-------------------------------------------------最新时间-----------------------------------------------------------------
    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.work_city=#{work_city} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType}) ORDER BY p.delivery_deadline;")
    List<Post> getPostByRegionTime(String work_city, String smallType);

    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.month=#{month} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType}) ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterMonthTime(String month, String smallType);

    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE p.pay>#{salary} AND p.small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType}) ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterSalaryTime(String salary, String smallType);

    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.month=#{month} ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterRegionMonthTime(String smallType, String work_city, String month);

    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.pay>#{salary} ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterRegionSalaryTime(String smallType, String work_city, String salary);

    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.month = #{month} AND p.pay>#{salary} ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterMonthSalaryTime(String smallType, String month, String salary);

    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})AND p.work_city = #{work_city} AND p.month = #{month} AND p.pay>#{salary} ORDER BY p.delivery_deadline;")
    List<Post> getPostByFilterAllTime(String smallType, String work_city, String month, String salary);

    @Select("SELECT p.*, e.name as enterprise_name FROM post p Join enterprise e on p.hr_id=e.id WHERE small_post_id=(SELECT id FROM post_small_type WHERE name=#{smallType})ORDER BY p.delivery_deadline;")
    List<Post> getPostInfoTime(String smallType);
}
