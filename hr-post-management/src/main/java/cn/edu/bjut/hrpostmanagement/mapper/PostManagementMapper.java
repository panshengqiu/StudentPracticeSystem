package cn.edu.bjut.hrpostmanagement.mapper;

import cn.edu.bjut.entity.hr.HumanResource;
import cn.edu.bjut.entity.post.Post;
import cn.edu.bjut.entity.post.PostSmallType;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface PostManagementMapper {
    @MapKey("id")
    public List<Map<Object, Object>> selectPostsInfo(HumanResource humanResource);

    public List<Map<Object, Object>> selectFirmPosts(HumanResource humanResource);

    public Integer selectSmallPostIdOnName(PostSmallType postSmallType);

    public Set<String> selectAllSmallTypeName();
    Set<String> selectPostsWorkCities();

    public Integer insertPost(Post post);

//    @MapKey("id")
    public  List<Map<Object,Object>> selectPostsInfoConditionally(Post post);
    public Integer updatePostInfo(Post post);

    public List<Map<Object, Object>> selectPostInfoOnId(Post post);
}
