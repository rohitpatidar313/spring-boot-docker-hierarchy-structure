package com.company.structure.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tree")
public class Tree implements Serializable {
    @Id
    @Column(name = "node")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer node;
    @Column(name = "node_name")
    private String nodeName;

    @OneToMany(targetEntity =  TreeHierarchy.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "th_fk",referencedColumnName = "node")
    List<TreeHierarchy> treeHierarchies;

    public List<TreeHierarchy> getTreeHierarchies() {
        return treeHierarchies;
    }

    public void setTreeHierarchies(List<TreeHierarchy> treeHierarchies) {
        this.treeHierarchies = treeHierarchies;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
