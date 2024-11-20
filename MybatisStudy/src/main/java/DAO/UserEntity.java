package DAO;

import Entities.userEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserEntity {
    int updateUser();
    List<userEntity> getUser();
    userEntity getUserByAge(int age);
    userEntity getUserByAge2(String age);
    userEntity getUserByTwoProperties(String name,int id);
    userEntity getUserByMap(Map map);
    void insertUser(int emp_id,String emp_name,double emp_salary,int emp_age);
    userEntity getUserByParam(@Param("id") int userId);
    userEntity getUserUnclear(String name);
    List<userEntity> showTable(String tableName);
    void addUser(userEntity user);

}
