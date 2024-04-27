package com.bumsoap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Repository;

import com.bumsoap.model.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Integer> {

  @Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
  @PostFilter("!filterObject.noticeSummary.contains('Downtime')")
  List<Notice> findAllActiveNotices();

}
