package com.company.structure.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseStructure {

    private Integer node;
    List<TreeHierarchyDto>  descendantNodes;

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public List<TreeHierarchyDto> getDescendantNodes() {
        return descendantNodes;
    }

    public void setDescendantNodes(List<TreeHierarchyDto> descendantNodes) {
        this.descendantNodes = descendantNodes;
    }
}
