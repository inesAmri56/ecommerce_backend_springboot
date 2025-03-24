package com.example.e_commerce.dtos.response;

import com.example.e_commerce.dtos.requests.SubCategoryRequest;
import com.example.e_commerce.models.Category;
import com.example.e_commerce.models.SubCategory;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.persistence.Entity;
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
public class SubCategoryResponse {
    private Long id;
    private String description;
    private String name;
    private Category category;
    List<ProductResponse> pproducts;

    public static SubCategoryResponse fromEntity(SubCategory subcategory) {
        SubCategoryResponse subcategoryResonse = new SubCategoryResponse();
        BeanUtils.copyProperties(subcategory, subcategoryResonse);
        if(subcategory.getProducts()!=null) {
            subcategoryResonse.setPproducts(subcategory.getProducts().stream().
                    map(ProductResponse::fromEntity).collect(Collectors.toList()));
        }
            return subcategoryResonse;
    }

    public static SubCategory toEntity(SubCategoryRequest subCategoryRequest){
        SubCategory subCategory = new SubCategory();
        BeanUtils.copyProperties(subCategoryRequest,subCategory);
        return subCategory;
    }
}
