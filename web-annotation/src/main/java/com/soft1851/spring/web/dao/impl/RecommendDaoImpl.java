package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.RecommendDao;
import com.soft1851.spring.web.entity.Recommend;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName RecommendDaoImpl
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/27
 **/
@Repository
public class RecommendDaoImpl implements RecommendDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Recommend> selectAll() {
        String sql = "SELECT * From t_recommend";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Recommend.class));
    }

    @Override
    public int insert(Recommend recommend) {
        String sql = "INSERT INTO t_recommend (id,user_name,avatar,city_name,profession_name," +
                "content_count,popularity_count,fans_count) VALUES (?,?,?,?,?,?,?,?)";
        Object[] params = {recommend.getId(),recommend.getUserName(),recommend.getAvatar(),
                recommend.getCityName(),recommend.getProfessionName(),
                recommend.getContentCount(),recommend.getPopularityCount(),recommend.getFansCount()};
        return jdbcTemplate.update(sql,params);
    }

    @Override
    public int[] batchInsert(List<Recommend> recommends) {
        final List<Recommend> recommendList = recommends;
        String sql = "INSERT INTO t_recommend (id,user_name,avatar,city_name,profession_name," +
                "content_count,popularity_count,fans_count) VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Recommend recommend = recommendList.get(i);
                preparedStatement.setString(1,recommend.getId());
                preparedStatement.setString(2,recommend.getUserName());
                preparedStatement.setString(3,recommend.getAvatar());
                preparedStatement.setString(4,recommend.getCityName());
                preparedStatement.setString(5,recommend.getProfessionName());
                preparedStatement.setInt(6,recommend.getContentCount());
                preparedStatement.setInt(7,recommend.getPopularityCount());
                preparedStatement.setInt(8,recommend.getFansCount());
            }

            @Override
            public int getBatchSize() {
                return recommendList.size();
            }
        });
    }
}
