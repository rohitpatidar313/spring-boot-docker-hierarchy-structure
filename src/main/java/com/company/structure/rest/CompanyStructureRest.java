package com.company.structure.rest;

import com.company.structure.dto.ResponseStructure;
import com.company.structure.services.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CompanyStructureRest {

    @Autowired
    private TreeService treeService;

    @GetMapping("/nodes/descendant/{id}")
    public ResponseStructure getAllDescendantNodes(@PathVariable Integer id) {
        return treeService.getAllDescendantNodes(id);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "/nodes/{id}/parent/{pid}")
    public void updateParent(@PathVariable Integer id, @PathVariable Integer pid){
            treeService.updateParent(id,pid);
    }
}
