package cn.edu.bjut.studentsearchpost.mapper;

import java.util.List;
import java.util.Map;

public class IntendPostSqlProvider {
    public static String insertIntend(Map<String, Object> params) {
        int stuId = (int) params.get("stuId");
        List<String> bigTypeList = (List<String>) params.get("bigTypeList");

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO intended_post (stu_id, small_post_id) VALUES ");

        for (int i = 0; i < bigTypeList.size(); i++) {
            String bigType = bigTypeList.get(i);
            if (i > 0) {
                sqlBuilder.append(", ");
            }
            sqlBuilder.append("(").append(stuId).append(", ")
                    .append("(SELECT post_small_type.id FROM post_small_type ")
                    .append("JOIN post_big_type ON post_small_type.big_id = post_big_type.id ")
                    .append("WHERE post_big_type.name = '").append(bigType).append("' LIMIT 1))");
        }

        return sqlBuilder.toString();
    }
}
