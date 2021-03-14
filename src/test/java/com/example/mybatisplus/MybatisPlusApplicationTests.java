package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testInsert(){
        User user = new User();
        user.setName("ted23");
        user.setAge(12);
        user.setEmail("test@139.com");
        userMapper.insert(user);
    }

    @Test
    void testUpdate(){
        User user=userMapper.selectById(1L);
        user.setName("wangliang");
        userMapper.updateById(user);
    }


    @Test
    void testVersion(){
        User user=userMapper.selectById(1L);
        user.setName("wangliang1");

        User user1= userMapper.selectById(1L);
        user1.setName("wangliang2");
        userMapper.updateById(user1);
        userMapper.updateById(user);
    }

    @Test
    void testPage(){
        Page<User> objectPage = new Page<>(1,5);
        IPage<User> userIPage = userMapper.selectPage(objectPage,null);
        userIPage.getRecords().forEach(System.out::println);
    }

    @Test
    void testDelete(){
        userMapper.deleteById(2L);
    }



}
