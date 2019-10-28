package com.zrcoffee.mapper;

import com.zrcoffee.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户映射器
 *
 * @author Terry
 * @version 2019-10-27
 */
@Mapper
public interface UserMapper {

    /**
     * 根据实体中的属性值进行查询
     *
     * @param entity 用户实体
     * @return 用户列表
     */
    @Select({"<script>",
            "select *",
            "from user",
            "<where>",
            "<if test=\"username!=null and username!=''\"> and username like concat('%', #{username}, '%') </if>",
            "<if test=\"realname!=null and realname!=''\"> and realname like concat('%', #{realname}, '%') </if>",
            "</where>",
            "order by id",
            "</script>"})
    List<User> find(User entity);

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return 用户实体
     */
    @Select("select * from user where id = #{id}")
    User findById(Long id);

    /**
     * 根据用户名称查询
     *
     * @param username 用户名称
     * @return 用户实体
     */
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    /**
     * 新增
     *
     * @param entity 用户实体
     * @return 结果
     */
    @Insert({"insert into user",
            "values (#{id}, #{username}, #{password}, #{realname}, #{sex}, #{email}, #{mobile}, #{phone}, #{avatar}, #{status}, #{remark}, null, null, sysdate(), #{createBy})"})
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", keyColumn = "id", before = true, resultType = Long.class)
    Integer insert(User entity);

    /**
     * 更新
     *
     * @param entity 用户实体
     * @return 结果
     */
    @Update({"<script>",
            "update user",
            "<set>",
            "<if test=\"password!=null and password!=''\"> password = #{password}, </if>",
            "<if test=\"realname!=null and realname!=''\"> realname = #{realname}, </if>",
            "<if test=\"sex!=null and sex!=''\"> sex = #{sex}, </if>",
            "<if test=\"email!=null and email!=''\"> email = #{email}, </if>",
            "<if test=\"mobile!=null and mobile!=''\"> mobile = #{mobile}, </if>",
            "<if test=\"phone!=null and phone!=''\"> phone = #{phone}, </if>",
            "<if test=\"avatar!=null and avatar!=''\"> avatar = #{avatar}, </if>",
            "<if test=\"status!=null and status!=''\"> status = #{status}, </if>",
            "<if test=\"remark!=null and remark!=''\"> remark = #{remark}, </if>",
            "<if test=\"updateDate!=null and updateDate!=''\"> updateDate = #{updateDate}, </if>",
            "<if test=\"updateBy!=null and updateBy!=''\"> updateBy = #{updateBy}, </if>",
            "</set>",
            "where id = #{id}",
            "</script>"})
    Integer update(User entity);

    /**
     * 删除
     * <p>
     * 因为在druid数据源配置中禁用delete语句, 所以使用update进行逻辑删除.
     *
     * @param id 主键
     * @return 结果
     */
    @Delete("delete from user where id = #{id}")
    Integer delete(Long id);

}
