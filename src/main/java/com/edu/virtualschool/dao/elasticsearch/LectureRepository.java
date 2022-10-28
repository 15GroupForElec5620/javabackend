package com.edu.virtualschool.dao.elasticsearch;

import com.edu.virtualschool.entity.Lecture;
import com.edu.virtualschool.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/27 - 10 - 27 -21:35
 */
@Repository
public interface LectureRepository extends ElasticsearchRepository<Lecture, Integer> {
    List<Lecture> findByTitle(String title);
}
