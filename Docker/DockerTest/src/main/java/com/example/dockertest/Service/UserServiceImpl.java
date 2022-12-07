package com.example.dockertest.Service;

import com.example.dockertest.Dao.UserDao;
import com.example.dockertest.Domain.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final String REDIS_KEY ="user:";
    @Resource
    RedisTemplate redisTemplate;
    @Resource
    UserDao userService;
    @Override
    public User findUser(String id) {
//        先查询 redis 再查询mysql 减轻 mysql压力
        String k1=REDIS_KEY+id.intern();
      User user= (User) redisTemplate.opsForValue().get(k1);
        System.out.println(user);
      if(user!=null){
          System.out.println("redis返回"+user);
          return user;
      }else {
          List<User> users= userService.findUser(id);
          System.out.println("mysql"+users.size());
          if(users.size()>0){
//              mysql有 redis 无
              String k = REDIS_KEY+users.get(0).id;

              redisTemplate.opsForValue().set(k,users.get(0));
              return users.get(0);

          }else {
//              都没有
              return  null;
          }
      }

    }

    @Override
    public boolean addUser(User user) {
        System.out.println(user);
//        首先先添加到mysql中 然后再添加到 redis中
       int res= userService.addUser(user);
       if(res>0){
//          将插入的数据重新取出来
           System.out.println(user.id);
         User users= findUser(user.id);
//           获取id
          String key= users.id;
//          创建redis的key值
          String k = REDIS_KEY+key;
//          创建redis数据备份
           System.out.println(users);
          redisTemplate.opsForValue().set(k,users);
          return true;
       }
       return false;
    }
}
