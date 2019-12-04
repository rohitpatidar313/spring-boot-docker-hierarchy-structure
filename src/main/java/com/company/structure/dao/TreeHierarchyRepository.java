package com.company.structure.dao;

import com.company.structure.domain.TreeHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TreeHierarchyRepository extends JpaRepository<TreeHierarchy, Integer> {

    List<TreeHierarchy> findAllByDescendant(Integer descendant);

    @Transactional
    void deleteByDescendant(Integer descendant);
}
