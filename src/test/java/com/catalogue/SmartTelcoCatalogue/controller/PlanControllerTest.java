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

import com.catalogue.SmartTelcoCatalogue.model.Plans;
import com.catalogue.SmartTelcoCatalogue.service.PlanService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PlanControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private PlanController planController;

	@MockBean
	private PlanService planService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(planController).build();
	}

	private Plans testPlan1 = new Plans("200-1004", "499 prepaid plan", "prepaid plan", "499 prepaid plan", 499, 499,
			"Voice", "Prepaid", "", "Delhi", new Date(), new Date(), "admin", " ");
	private Plans testPlan2 = new Plans("200-1003", "399 prepaid plan", "prepaid plan", "399 prepaid plan", 399, 399,
			"Voice", "Prepaid", "", "Karnataka", new Date(), new Date(), "admin", " ");
	private String expected = "{productId:\"200-1004\",productName:\"499 prepaid plan\",shortDesc:\"prepaid plan\",longDesc:\"499 prepaid plan\"}";

	Optional<Plans> testPlans = Optional.of(testPlan1);
	List<Plans> listPlans1 = Arrays.asList(testPlan2, testPlan1);
	List<Plans> listPlansByRegion = Arrays.asList(testPlan1);

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyGetPlanByID() throws Exception {

		Mockito.when(planService.getPlan("200-1004")).thenReturn(testPlans);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/smartTelco/plans/200-1004")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyGetAllPlans() throws Exception {
		Mockito.when(planService.getAllPlans()).thenReturn(listPlans1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/smartTelco/plans")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(jsonPath("$", hasSize(2))).andDo(print());

	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyGetPlanByRegion() throws Exception {

		Mockito.when(planService.eligiblePlanByRegion("Delhi")).thenReturn(listPlansByRegion);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/smartTelco/eligiblePlanByRegion/Delhi")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyGetPlanByCategory() throws Exception {

		Mockito.when(planService.eligiblePlanByCategory("Voice")).thenReturn(listPlansByRegion);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/smartTelco/eligiblePlanByCategory/Voice")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyGetPlanBySubCategory() throws Exception {

		Mockito.when(planService.eligiblePlanBySubCategory("Prepaid")).thenReturn(listPlansByRegion);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/smartTelco/eligiblePlanBySubCategory/Prepaid")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyDelete() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/smartTelco/deletePlan/200-1004")
				.contentType(MediaType.APPLICATION_JSON).content(expected).accept(MediaType.APPLICATION_JSON))
				.andDo(print());
	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyCreate() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/smartTelco/createPlan")
				.contentType(MediaType.APPLICATION_JSON).content(expected).accept(MediaType.APPLICATION_JSON))
				.andDo(print());
	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void verifyUpdate() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.put("/smartTelco/updatePlan")
				.contentType(MediaType.APPLICATION_JSON).content(expected).accept(MediaType.APPLICATION_JSON))
				.andDo(print());
	}

}
