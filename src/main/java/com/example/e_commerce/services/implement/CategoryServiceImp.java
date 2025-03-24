package com.example.e_commerce.services.implement;

import com.example.e_commerce.dtos.requests.CategoryRequest;
import com.example.e_commerce.dtos.requests.SubCategoryRequest;
import com.example.e_commerce.dtos.response.CategoryResponse;
import com.example.e_commerce.dtos.response.SubCategoryResponse;
import com.example.e_commerce.dtos.response.UserResponse;
import com.example.e_commerce.models.Category;
import com.example.e_commerce.repositories.CategoryDAO;
import com.example.e_commerce.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {
    public static CategoryDAO categorydao;
    public CategoryServiceImp(CategoryDAO categorydao) {

        this.categorydao=categorydao;
    }
    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category c =CategoryResponse.toEntity(categoryRequest);
        Category savedcategory= categorydao.save(c);
        return CategoryResponse.fromEntity(savedcategory);

    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categorydao.findAll().stream()
                .map(CategoryResponse::fromEntity).collect(Collectors.toList());
    }
    @Override
    public CategoryResponse getCategoryById(Long id) {
        return categorydao.findById(id).map(CategoryResponse::fromEntity)
                .orElseThrow(()->new RuntimeException("category not fount"));
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest categoryRequest, Long id) {
        Category category =categorydao.findById(id).orElseThrow(
                ()->new RuntimeException("category not found with this id:"+id));
        if(category !=null){
            Category cat =CategoryResponse.toEntity(categoryRequest);
            cat.setId(id);
            Category savedCategory=categorydao.save(cat);
            return CategoryResponse.fromEntity(savedCategory);
        }else{
            return  null;
        }
    }

    @Override
    public HashMap<String, String> deleteCategory(Long id) {
        HashMap message = new HashMap<>() ;
        Category category=categorydao.findById(id).orElseThrow(null);
        if(category!=null){
            try{
                categorydao.deleteById(id);
                message.put("Category","Catefgory deleted successfully");
            }catch(Exception e){
                message.put("category",e.getMessage());
            }
        }else {
            message.put("message", "category not found" + id);
        }
        return message;
    }


}
