package com.example.e_commerce.services;

import com.example.e_commerce.dtos.requests.SubCategoryRequest;
import com.example.e_commerce.dtos.response.SubCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface SubCategoryService {
    SubCategoryResponse createSubCategory(SubCategoryRequest subCategoryRequest);
    SubCategoryResponse getSubCategory(Long id);
    List<SubCategoryResponse> getAllSubCategories();
    SubCategoryResponse updateSubCategory(SubCategoryRequest subCategoryRequest,Long id);
    HashMap<String,String> deleteSubCategory(Long id);
    SubCategoryResponse createSubCategorywithCtegory(SubCategoryRequest subCategoryRequest,Long id);



}
