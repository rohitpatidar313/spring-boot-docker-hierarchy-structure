package com.company.structure.services;

import com.company.structure.dao.TreeHierarchyRepository;
import com.company.structure.dao.TreeRepository;
import com.company.structure.domain.TreeHierarchy;
import com.company.structure.dto.ResponseStructure;
import com.company.structure.dto.TreeHierarchyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {
    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private TreeHierarchyRepository treeHierarchyRepository;

    public ResponseStructure getAllDescendantNodes(Integer id){
        ResponseStructure respStruct = new ResponseStructure();
        respStruct.setNode(id);
        List<TreeHierarchyDto> list = treeRepository.getAllDescendantNodes(id);
        respStruct.setDescendantNodes(list);
        return respStruct;
    }

    public void updateParent(Integer id, Integer pid){
        treeHierarchyRepository.deleteByDescendant(id);
        List<TreeHierarchy> list = treeHierarchyRepository.findAllByDescendant(pid);
        for(TreeHierarchy th : list){
            treeHierarchyRepository.save(new TreeHierarchy(th.getAncestor(),id,th.getDepth()+1));
        }
    }
}
