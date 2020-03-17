package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.dao.PostDao;
import com.soft1851.spring.ioc.entity.Forum;
import com.soft1851.spring.ioc.entity.Post;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import java.beans.Beans;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName PostDaoImpl
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/17
 **/
@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,?,?)";
        Object[] args = {post.getForumId(),post.getTitle(),post.getContent(),post.getThumbnail(),post.getCreateTime()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,postList.get(i).getForumId());
                preparedStatement.setString(2,postList.get(i).getTitle());
                preparedStatement.setString(3,postList.get(i).getContent());
                preparedStatement.setBytes(4,postList.get(i).getThumbnail());
                preparedStatement.setTimestamp(5,postList.get(i).getCreateTime());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    @Override
    public int delete(int postId) {
        String sql = "DELETE FROM t_post WHERE post_id = ?";
        Object[] args = {postId};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int[] batchDelete(List<Integer> postIds) {
        final List<Integer> postIdList = postIds;
        String sql = "DELETE FROM t_post WHERE post_id = ?";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,postIds.get(i));
            }

            @Override
            public int getBatchSize() {
                return postIdList.size();
            }
        });
    }

    @Override
    public Post getById(int postId) {
        String sql = "SELECT * FROM t_post WHERE post_id = ?";
        Object[] args = {postId};
        return jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> getByKeywords(String keywords) {
        String sql = "SELECT * FROM t_post WHERE title LIKE '%"+keywords+"%' OR content LIKE '%"+keywords+"%'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public int countByForumId(int forumId) {
        String sql = "SELECT count(post_id) FROM t_post WHERE forum_id = ?";
        Object[] args = {forumId};
        return jdbcTemplate.queryForObject(sql,args,Integer.class);
    }
}
