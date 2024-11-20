import DAO.UserEntity;
import Entities.userEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testPage {
    public static void main(String[] args) {
        InputStream inputStream = testPage.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory myFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession mySession = myFactory.openSession();
        UserEntity user = mySession.getMapper(UserEntity.class);
        userEntity findPerson = user.getUserByTwoProperties("谢子潇",11);
        System.out.println(findPerson.getEmp_name());
        System.out.println(findPerson.getEmp_age());
        System.out.println(findPerson.getEmp_id());
        System.out.println(findPerson.getSalary());
    }


    @Test public void getUserByMapTest(){
        InputStream inputStream = testPage.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory myFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession mySession = myFactory.openSession();
        UserEntity user = mySession.getMapper(UserEntity.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","andy");
        map.put("id",1);
        userEntity findPerson = user.getUserByMap(map);
        System.out.println(findPerson.getSalary());
    }

    @Test public void insertUserTest(){
        InputStream inputStream = testPage.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory myFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession mySession = myFactory.openSession(true);
        UserEntity User = mySession.getMapper(UserEntity.class);
        userEntity user = new userEntity("测试者2",11,123,553);
        User.insertUser(user.getEmp_id(),user.getEmp_name(),user.getSalary(),user.getEmp_age());
        //如果不设置手动提交事务autoCommit = true，则需要提交事务insertUser才能生效
    }

    @Test public void selectUserTest(){
        InputStream inputStream = testPage.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory myFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession mySession = myFactory.openSession(true);
        UserEntity User = mySession.getMapper(UserEntity.class);
        userEntity user = User.getUserByParam( 553);
        System.out.println(user.getEmp_name());
    }

    @Test public void getUserUnclearTest(){
        InputStream inputStream = testPage.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory myFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession mySession = myFactory.openSession(true);
        UserEntity User = mySession.getMapper(UserEntity.class);
        userEntity user = User.getUserUnclear("风");
        System.out.println(user.getEmp_name());
    }

    @Test public void showTableTest(){
        InputStream inputStream = testPage.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory myFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession mySession = myFactory.openSession(true);
        UserEntity User = mySession.getMapper(UserEntity.class);
        List<userEntity> list = User.showTable("t_emp");
        list.forEach(userEntity -> System.out.println(userEntity));
    }

    @Test public void addUserTest(){
        InputStream inputStream = testPage.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory myFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession mySession = myFactory.openSession(true);
        UserEntity User = mySession.getMapper(UserEntity.class);
        User.addUser(new userEntity(null,11,123,"测试者3"));
        //如果不设置手动提交事务autoCommit = true，则需要提交事务insertUser才能生效
    }
}
