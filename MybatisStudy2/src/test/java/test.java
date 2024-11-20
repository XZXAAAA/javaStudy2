import Entites.user;
import EntitiesInterfaces.userMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class test {
    @Test
    public void testVoid(){
        InputStream inputStream = test.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory myFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession mySession = myFactory.openSession(true);
        userMapper mapper = mySession.getMapper(userMapper.class);
        List<user> list =mapper.showAllUsers();
        list.forEach(System.out::println);
    }
}
