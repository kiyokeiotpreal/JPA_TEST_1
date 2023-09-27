package com.example.jpa_test.Controller;

import com.example.jpa_test.Model.ProductDetails;
import com.example.jpa_test.Model.Products;
import com.example.jpa_test.Service.ProductService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "BuyProduct", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buy1Product(@RequestBody String input){
        Gson gson = new Gson();
        Input ip = gson.fromJson(input, Input.class);
        return productService.buyProduct(ip);
    }

    @RequestMapping(value = "reviseQuantity", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String reviseQuantity(@RequestBody String product){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Products products = gson.fromJson(product,Products.class);
        boolean isCheck = productService.reviseQuantity(products);
        if(isCheck){
            return "Revise Successfully";
        }
        return "Revise failfully";
    }

    @RequestMapping(value = "displayProductDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDetails> displayProductDetail(){
        return productService.displayProductDetail();
    }
}
