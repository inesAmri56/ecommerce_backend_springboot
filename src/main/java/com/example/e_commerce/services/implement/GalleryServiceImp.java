package com.example.e_commerce.services.implement;

import com.example.e_commerce.dtos.requests.GalleryRequest;
import com.example.e_commerce.dtos.response.CategoryResponse;
import com.example.e_commerce.dtos.response.GalleryResponse;
import com.example.e_commerce.models.Category;
import com.example.e_commerce.models.Gallery;
import com.example.e_commerce.repositories.GalleryDAO;
import com.example.e_commerce.services.GalleryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class GalleryServiceImp implements GalleryService {
   public static  GalleryDAO gallerydao;
   public GalleryServiceImp(GalleryDAO gallerydao) {
       this.gallerydao = gallerydao;
   }
    @Override
    public GalleryResponse createGallery(GalleryRequest galleryRequest) {
        Gallery gallery= GalleryResponse.toEntity(galleryRequest);
        Gallery saveGallery=gallerydao.save(gallery);
        return  GalleryResponse.fromEntity(saveGallery);

    }

    @Override
    public GalleryResponse getGallery(Long id) {

        return gallerydao.findById(id).map(GalleryResponse::fromEntity).
                orElseThrow(()->new RuntimeException("gallery Not found"));
    }

    @Override
    public List<GalleryResponse> getAllGalleries() {

        return gallerydao.findAll().stream().
                map(GalleryResponse::fromEntity).collect(Collectors.toList());
    }

    @Override
    public GalleryResponse udpdateGallery(GalleryRequest galleryRequest, Long id) {

        Gallery gallery =gallerydao.findById(id).orElseThrow(
                ()->new RuntimeException("gallery not found with this id:"+id));
        if(gallery !=null){
            Gallery cat = GalleryResponse.toEntity(galleryRequest);
            cat.setId(id);
            Gallery savedGallery=gallerydao.save(cat);
            return GalleryResponse.fromEntity(savedGallery);
        }else{
            return  null;
        }
    }

    @Override
    public HashMap<String, String> deleteGallery(Long id) {
        HashMap message = new HashMap<>() ;
        Gallery gallery=gallerydao.findById(id).orElseThrow(null);
        if(gallery!=null){
            try{
                gallerydao.deleteById(id);
                message.put("Gallery","Gallery deleted successfully");
            }catch(Exception e){
                message.put("Gallery",e.getMessage());
            }
        }else {
            message.put("message", "Gallery not found" + id);
        }
        return message;
    }
}
