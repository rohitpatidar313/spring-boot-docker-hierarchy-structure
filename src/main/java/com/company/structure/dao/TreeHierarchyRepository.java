package com.company.structure.dao;

import com.company.structure.domain.TreeHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TreeHierarchyRepository extends JpaRepository<TreeHierarchy, Integer> {

    @Transactional
    @Modifying(flushAutomatically = false)
    @Query("update com.company.structure.domain.TreeHierarchy th set th.ancestor=?2 where th.descendant=?1 and th.depth>0")
    int updateParent(@Param("id") Integer id, @Param("pid") Integer pid);

    List<TreeHierarchy> findAllByDescendant(Integer descendant);

    @Transactional
    void deleteByDescendant(Integer descendant);
}
