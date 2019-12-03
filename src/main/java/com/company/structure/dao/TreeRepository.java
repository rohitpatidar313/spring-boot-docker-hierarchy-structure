package com.company.structure.dao;

import com.company.structure.domain.Tree;
import com.company.structure.dto.TreeHierarchyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Integer> {
    @Query("select new com.company.structure.dto.TreeHierarchyDto(t.node,t.nodeName,th.depth)"
            +"FROM Tree t JOIN com.company.structure.domain.TreeHierarchy th on t.node=th.descendant where th.ancestor=?1")
    List<TreeHierarchyDto> getAllDescendantNodes(Integer id);
}
