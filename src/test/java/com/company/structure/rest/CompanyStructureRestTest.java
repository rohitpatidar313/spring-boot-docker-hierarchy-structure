package com.company.structure.rest;

import com.company.structure.dto.ResponseStructure;
import com.company.structure.dto.TreeHierarchyDto;
import com.company.structure.services.TreeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers =CompanyStructureRest.class)
public class CompanyStructureRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TreeService treeService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CompanyStructureRest companyStructureRest;

    @Test
    public void getDescendantsURITest() throws Exception{
        mockMvc.perform(get("/api/v1/nodes/descendant/1")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateParentTest() throws Exception{
        mockMvc.perform(put("/api/v1/nodes/1/parent/2")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void getDescendantTest() throws Exception{
        List<TreeHierarchyDto> dNodes = new ArrayList<>();
        TreeHierarchyDto dto = new TreeHierarchyDto(2,"root",0);
        dNodes.add(dto);
        ResponseStructure structure = new ResponseStructure();
        structure.setDescendantNodes(dNodes);
        when(treeService.getAllDescendantNodes(1)).thenReturn(structure);
        mockMvc.perform(get("/api/v1/nodes/descendant/1")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}
