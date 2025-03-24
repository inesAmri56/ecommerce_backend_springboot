package com.example.e_commerce.dtos.response;

import com.example.e_commerce.dtos.requests.CategoryRequest;
import com.example.e_commerce.models.Category;
import com.example.e_commerce.models.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private Long id;
    private String description;
    private String name;
    private List<SubCategoryResponse> subCategories;
    public static CategoryResponse fromEntity(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        //Copie des propriétés de l'entité Category vers CategoryResponse
         BeanUtils.copyProperties(category,categoryResponse);
        //Vérification de l'existence des sous-catégories (SubCategories)
        if(category.getSubcategories()!=null){
            //Conversion des sous-catégories
            categoryResponse.setSubCategories(category.getSubcategories().
                    stream().map(SubCategoryResponse::fromEntity).collect(Collectors.toList()));
        }
        return categoryResponse;
    }
    //sans laison
//    public static CategoryResponse fromEntity(Category category){
//        CategoryResponse categoryResponse = new CategoryResponse();
//        BeanUtils.copyProperties(category,categoryResponse);
//        return categoryResponse;
//    }
    public static Category toEntity(CategoryRequest request){
        Category category = new Category();
        BeanUtils.copyProperties(request,category);
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
