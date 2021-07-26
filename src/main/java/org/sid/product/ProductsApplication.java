package org.sid.product;

import java.util.Random;

import org.sid.product.dao.CategoryRepository;
import org.sid.product.dao.ProductRepository;
import org.sid.product.entity.Category;
import org.sid.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class ProductsApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		categoryRepository.save(new Category(null,"Computers",null,null));
        categoryRepository.save(new Category(null,"Printers",null,null));
        categoryRepository.save(new Category(null,"Smart phones",null,null));
        Random rnd=new Random();
        categoryRepository.findAll().forEach(c->{
            for (int i = 0; i <10 ; i++) {
                Product p=new Product();
                p.setName(RandomString.make(18));
                p.setCurrentPrice(100+rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                p.setPhotoName("unknown.png");
                productRepository.save(p);
            }
        });
    }	
	

}
