package cn.itcast.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ContextConfiguration(locations={"classpath:spring/applicationContext-redis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class testRedis {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *
     * @Title: testSetString
     * @Description: 添加/更新
     * @return void
     * @throws
     */
    @Test
    public void testSetString(){
        redisTemplate.boundValueOps("name").set("传智播客");
        redisTemplate.boundValueOps("age").set(19);
        redisTemplate.boundValueOps("addr").set("北京西二旗");

    }

    /**
     *
     * @Title: testGetString
     * @Description: 查询
     * @return void
     * @throws
     */
    @Test
    public void testGetString(){
        System.out.println(redisTemplate.boundValueOps("name").get());
        System.out.println(redisTemplate.boundValueOps("age").get());
        System.out.println(redisTemplate.boundValueOps("addr").get());
    }

    @Test
    public void testSetValue() {
        redisTemplate.boundHashOps("user").put("username","小明");
        redisTemplate.boundHashOps("user").put("school","清华大学");
        redisTemplate.boundHashOps("user").put("gf", "marry");

    }

    @Test
    public void testGetValue() {
        System.out.println(redisTemplate.boundHashOps("user").get("username"));
        System.out.println(redisTemplate.boundHashOps("user").get("school"));
        System.out.println(redisTemplate.boundHashOps("user").get("gf"));
    }
    @Test
    public void testGetKeys(){
       /* Set keys = redisTemplate.boundHashOps("user").keys();
        for (Object key : keys) {
            System.out.println(key);
        }*/
        Set keys = redisTemplate.boundHashOps("user").keys();
        for (Object key : keys) {
            System.out.println(key);
        }
        List values = redisTemplate.boundHashOps("user").values();
        for (Object value : values) {
            System.out.println(value);
        }
    }
    @Test
    public void testGetMap(){
        Map<String, String> entries = redisTemplate.boundHashOps("user").entries();
        Set<Map.Entry<String, String>> entrySet = entries.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

    }
    @Test
    public void testDeleteKeys(){
        redisTemplate.delete("name"); // 删除一个
        List<String> keys = new ArrayList<>();
        keys.add("addr");
        keys.add("age");
        keys.add("user");
        redisTemplate.delete(keys); // 删除多个
    }

    @Test
    public void testSetValue1() {
        redisTemplate.boundListOps("namelist").rightPush("刘备");
        redisTemplate.boundListOps("namelist").rightPush("关羽");
        redisTemplate.boundListOps("namelist").rightPush("张飞");
    }
    @Test
    public void testGetValue1(){
        List list = redisTemplate.boundListOps("namelist").range(0, 10);
        System.out.println(list);
    }
    @Test
    public void testSearchByIndex(){
        String s = (String) redisTemplate.boundListOps("namelist").index(1);
        System.out.println(s);
       
    }
}
