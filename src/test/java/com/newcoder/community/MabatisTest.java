package com.newcoder.community;

import com.newcoder.community.dao.DiscussPostMapper;
import com.newcoder.community.dao.UserMapper;
import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MabatisTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    DiscussPostMapper discussPostMapper;

    @Test
    public void selectByIdTest() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testDiscussPostMapper() {
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(138, 0, 10);
        for(DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
        int nums = discussPostMapper.selectDiscussPostRows(138);
        System.out.println(nums);
    }
}
