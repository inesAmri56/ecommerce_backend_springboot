package com.example.e_commerce.controllers;

import com.example.e_commerce.dtos.requests.CategoryRequest;
import com.example.e_commerce.dtos.response.CategoryResponse;
import com.example.e_commerce.services.CategoryService;
import com.example.e_commerce.services.implement.CategoryServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiCategory")
public class CategoryController {
        // Injection de dépendance
        private static CategoryService categoryService;
        public CategoryController(CategoryService categoryService) {
            this.categoryService = categoryService;
        }
        @PostMapping("/createCategory")
        public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest) {
            return categoryService.createCategory(categoryRequest);
        }
        @GetMapping("/getCategories")
         public List<CategoryResponse> getAllCategories(){
            return categoryService.getAllCategories();
        }
        @GetMapping ("/getCategory/{id}")
    public CategoryResponse getCategory(@PathVariable Long id){
            return categoryService.getCategoryById(id);
        }
        @PutMapping("/updateCategory/{id}")
        public  CategoryResponse updateCateGory(@RequestBody CategoryRequest categoryRequest, @PathVariable  Long id){
            return categoryService.updateCategory(categoryRequest,id);

            }
    @DeleteMapping ("/deleteCategory/{id}")
    public HashMap<String, String> deleteCategory(@PathVariable Long id ){
        return categoryService.deleteCategory(id);  }

}
