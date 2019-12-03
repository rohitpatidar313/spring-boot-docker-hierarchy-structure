package com.company.structure.services;

import com.company.structure.dao.TreeHierarchyRepository;
import com.company.structure.dao.TreeRepository;
import com.company.structure.dto.ResponseStructure;
import com.company.structure.dto.TreeHierarchyDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TreeServiceTest {

    @InjectMocks
    private TreeService treeService;

    @Mock
    private TreeRepository treeRepository;

    @Mock
    private TreeHierarchyRepository treeHierarchyRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllDescendantNodes(){
        List<TreeHierarchyDto> list = new ArrayList<>();
        TreeHierarchyDto dto = new TreeHierarchyDto(10,"node1",0);
        TreeHierarchyDto dto1 = new TreeHierarchyDto(11,"node11",1);
        list.add(dto);
        list.add(dto1);
        when(treeRepository.getAllDescendantNodes(10)).thenReturn(list);
        assertEquals(treeService.getAllDescendantNodes(10).getNode(),Integer.valueOf(10));
    }

    @Test
    public void testGetAllDescendantNodesInvalid(){
        List<TreeHierarchyDto> list = new ArrayList<>();
        TreeHierarchyDto dto = new TreeHierarchyDto(10,"node1",0);
        TreeHierarchyDto dto1 = new TreeHierarchyDto(11,"node11",1);
        list.add(dto);
        list.add(dto1);
        when(treeRepository.getAllDescendantNodes(10)).thenReturn(list);
        assertNotEquals(treeService.getAllDescendantNodes(12).getNode(),Integer.valueOf(10));
    }
}
