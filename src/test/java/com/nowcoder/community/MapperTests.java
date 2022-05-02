package com.nowcoder.community;
import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void insertTest() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("111111");
        user.setSalt("aaa");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcode.com/101.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        int row = userMapper.updateStatus(150,1);
        System.out.println(row);

        row = userMapper.updateHeaders(150,"http://www.nowcode.com/102.png");
        System.out.println(row);

        row = userMapper.updatePassword(150,"222222");
        System.out.println(row);
    }

    @Autowired
    DiscussPostMapper discussPostMapper;

    @Test
    public void testDiscussPost() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(111,0,10);
        for (DiscussPost dp:list) {
            System.out.println(dp);
        }

        int row = discussPostMapper.selectPostsRow(111);
        System.out.println(row);
    }

}
