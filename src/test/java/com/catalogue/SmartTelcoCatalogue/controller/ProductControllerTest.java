package com.catalogue.SmartTelcoCatalogue.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.catalogue.SmartTelcoCatalogue.model.Products;
import com.catalogue.SmartTelcoCatalogue.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductControllerTest {

	
	private MockMvc mockMvc;
	
	@InjectMocks
    private ProductController productController;

	@MockBean
	private ProductService productService;
	
	@Before
    public void setup() 
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(productController).build();
    }
	
	private Products testProduct= new Products("100-1001","iPhone","i-phone","apple i-phone",125,100,"mobile","smartphone","",new Date(),new Date(),"","");
	private Products testProduct2 =  new Products("100-1002","iPod","i-pod","apple i-pod",125,100,"mobile","accessories","",new Date(),new Date(),"","");
	Optional<Products> testProducts = Optional.of(testProduct);
	List<Products> testList = Arrays.asList(testProduct2,testProduct);
	List<Products> testList1 = Arrays.asList(testProduct);
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyGetProductByID() throws Exception {
		Mockito.when( productService.getProduct("100-1001")).thenReturn(testProducts);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/smartTelco/products/100-1001").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected="{productId: \"100-1001\",productName: \"iPhone\",shortDesc: \"i-phone\"}";
		
		System.out.println(result.getResponse());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyGetAllProducts() throws Exception{
		Mockito.when(productService.getAllProducts()).thenReturn(testList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/smartTelco/products")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(jsonPath("$", hasSize(2))).andDo(print());
		
		
	}
	
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyGetProductsByCategory() throws Exception {

		Mockito.when(productService.eligibleProductsByCategory("mobile")).thenReturn(testList1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/smartTelco/eligibleProductsByCategory/mobile")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}
	
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyGetProductsBySubCategory() throws Exception {

		Mockito.when(productService.eligibleProductsBySubCategory("smartphone")).thenReturn(testList1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/smartTelco/eligibleProductsBySubCategory/smartphone")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}

}
