package com.example.e_commerce.services.implement;

import com.example.e_commerce.dtos.requests.SubCategoryRequest;
import com.example.e_commerce.dtos.response.ProviderResponse;
import com.example.e_commerce.dtos.response.SubCategoryResponse;
import com.example.e_commerce.models.Category;
import com.example.e_commerce.models.Provider;
import com.example.e_commerce.models.SubCategory;
import com.example.e_commerce.repositories.SubCategoryDAO;
import com.example.e_commerce.services.SubCategoryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.e_commerce.services.implement.CategoryServiceImp.categorydao;

@Service
public class SubCategoryServiceImp implements SubCategoryService {
    public static SubCategoryDAO subcategorydao;
    private final SubCategoryDAO subCategoryDAO;

    public SubCategoryServiceImp(SubCategoryDAO subcategorydao, SubCategoryDAO subCategoryDAO) {
        SubCategoryServiceImp.subcategorydao = subcategorydao;
        this.subCategoryDAO = subCategoryDAO;
    }
    @Override
    public SubCategoryResponse createSubCategory(SubCategoryRequest subCategoryRequest) {
        SubCategory subCategory = SubCategoryResponse.toEntity(subCategoryRequest);
        SubCategory savedSubcategory = subcategorydao.save(subCategory);
        return SubCategoryResponse.fromEntity(savedSubcategory);
    }
    @Override
    public SubCategoryResponse createSubCategorywithCtegory(SubCategoryRequest subCategoryRequest, Long id) {
      Category category = categorydao.findById(id).orElseThrow(()->
              new RuntimeException(("category not found")));
      SubCategory subCategory = SubCategoryResponse.toEntity(subCategoryRequest);
      subCategory.setCategory(category);
      SubCategory savedSubCategory = subCategoryDAO.save(subCategory);
      return SubCategoryResponse.fromEntity(savedSubCategory);
    }

    @Override
    public SubCategoryResponse getSubCategory(Long id) {
        return subcategorydao.findById(id).map(SubCategoryResponse::fromEntity).
                orElseThrow(()->new RuntimeException("subCategory not found"));
    }

    @Override
    public List<SubCategoryResponse> getAllSubCategories() {
        return subcategorydao.findAll().stream().
                map(SubCategoryResponse::fromEntity).
                collect(Collectors.toList());
    }

    @Override
    public SubCategoryResponse updateSubCategory(SubCategoryRequest subCategoryRequest, Long id) {
        SubCategory subCategory =subcategorydao.findById(id).orElseThrow(
                ()->new RuntimeException("subcategory not found with this id:"+id));
        if(subCategory !=null){
            SubCategory sb = SubCategoryResponse.toEntity(subCategoryRequest);
            sb.setId(id);
            SubCategory savedProvider=subcategorydao.save(sb);
            return SubCategoryResponse.fromEntity(savedProvider);
        }else{
            return  null;
        }
    }

    @Override
    public HashMap<String, String> deleteSubCategory(Long id) {
        HashMap message = new HashMap<>() ;
        SubCategory subcategory=subcategorydao.findById(id).orElseThrow(null);
        if(subcategory!=null){
            try{
                subcategorydao.deleteById(id);
                message.put("subcategory","subcategory deleted successfully");
            }catch(Exception e){
                message.put("provider",e.getMessage());
            }
        }else {
            message.put("message", "provider not found" + id);
        }
        return message;
    }


}
