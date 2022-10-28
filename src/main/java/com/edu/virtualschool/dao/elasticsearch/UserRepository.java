package com.edu.virtualschool.dao.elasticsearch;

import com.edu.virtualschool.entity.Lecture;
import com.edu.virtualschool.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/25 - 10 - 25 -16:19
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User, Integer> {
    Set<User> findByUsername(String username);


}
