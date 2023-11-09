package com.example.jpa_test.Service;
import com.example.jpa_test.Controller.Input;
import com.example.jpa_test.Model.ProductDetailPropertyDetails;
import com.example.jpa_test.Model.ProductDetails;
import com.example.jpa_test.Model.Products;
import com.example.jpa_test.Repository.ProductDetailPropertyDetailRepository;
import com.example.jpa_test.Repository.ProductDetailRepository;
import com.example.jpa_test.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductService implements IProduct{
    @Autowired
    private ProductDetailPropertyDetailRepository productDetailPropertyDetailRepo;

    @Autowired
    private ProductDetailRepository productDetailRepo;

    @Autowired
    private ProductRepository productRepo;

    @Override
    public ResponseEntity<String> buyProduct(Input input) {
        if(productRepo.existsById(input.getProduct().getProductId())){
            Set<ProductDetailPropertyDetails> productDetailPropertyDetailsList = input.getProduct().getProductDetailPropertyDetailsSet();
            for (ProductDetailPropertyDetails pdpd: productDetailPropertyDetailsList) {
                int prdId = pdpd.getProductdetail().getProductDetailId();
                ProductDetails productDetail = productDetailRepo.findById(prdId).orElse(null);
                if(productDetail != null){
                    if(productDetail.getQuantity()==0){
                        return new ResponseEntity<>("Hết hàng", HttpStatus.BAD_REQUEST);
                    }else {
                        for (ProductDetails prd: productDetailRepo.findAll()) {
                            if(prd.getProductDetailId()==productDetail.getProductDetailId() && prd.getQuantity()<input.getQuantity()){
                                return new ResponseEntity<>("Không đủ số lượng", HttpStatus.BAD_REQUEST);
                            }
                            if(prd.getProductDetailId()==productDetail.getProductDetailId() && prd.getQuantity()>=input.getQuantity()){
                                for (ProductDetails prd1: productDetailRepo.findAll()) {
                                    if(prd.getProductPropertyName().contains(prd1.getProductPropertyName()) && prd1.getParentId()<=prd.getParentId()){
                                        prd1.setQuantity(prd1.getQuantity()-input.getQuantity());
                                        productDetailRepo.save(prd1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else {
            return new ResponseEntity<>("Sản phẩm không tồn tại", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Mua thành công", HttpStatus.OK );
    }

    @Override
    public Boolean reviseQuantity(Products product) {
        int productId = product.getProductId();
        if(productRepo.existsById(productId)){
            Set<ProductDetailPropertyDetails> productDetailPropertyDetailsSet = product.getProductDetailPropertyDetailsSet();
            for (ProductDetailPropertyDetails pdpd : productDetailPropertyDetailsSet ) {
                int prdId = pdpd.getProductdetail().getProductDetailId();
                ProductDetails productDetail = productDetailRepo.findById(prdId).orElse(null);
                if(productDetail != null){
                    int changeQuantity = (int) (pdpd.getProductdetail().getQuantity() - productDetail.getQuantity());
                    productDetail.setQuantity(pdpd.getProductdetail().getQuantity());
                    productDetailRepo.save(productDetail);
                    for (ProductDetails prd : productDetailRepo.findAll()) {
                        if(productDetail.getProductPropertyName().contains(prd.getProductPropertyName()) && prd.getParentId()<productDetail.getParentId()){
                            prd.setQuantity(prd.getQuantity()+changeQuantity);
                            productDetailRepo.save(prd);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public List<ProductDetails> displayProductDetail() {
        List<ProductDetails> resultList = new ArrayList<>();
        for (ProductDetails prd: productDetailRepo.findAll()) {
            boolean isCheck = true;
            for (ProductDetails prdcheck: productDetailRepo.findAll()) {
                if( prdcheck.getProductDetailId() != prd.getProductDetailId() &&
                        prdcheck.getProductPropertyName().contains(prd.getProductPropertyName())){
                    isCheck = false;
                    break;
                }
            }
            if(isCheck){
                resultList.add(prd);
            }
        }
        return resultList;
    }
}
