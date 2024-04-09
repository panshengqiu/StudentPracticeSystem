package cn.edu.bjut.hrpostmanagement.mapper;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostSmallType;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostManagementMapper {
    @MapKey("id")
    public List<Map<Object, Object>> selectPostInfo(HumanResource humanResource);

    public Integer selectSmallPostIdOnName(PostSmallType postSmallType);

    public List<String> selectAllSmallTypeName();

    public Integer insertPost(Post post);
}
