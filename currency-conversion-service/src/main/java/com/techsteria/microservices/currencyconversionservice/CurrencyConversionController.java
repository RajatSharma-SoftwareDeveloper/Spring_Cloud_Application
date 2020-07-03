package com.techsteria.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techsteria.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	
	@Autowired
	private CurrentExchangeServiceProxy feignProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyConverter(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity)
	{
		Map<String ,String> uriVariable = new HashMap<String,String>();
		uriVariable.put("from",from);
		uriVariable.put("to", to);
		
		
		
		ResponseEntity<CurrencyConversionBean> responseBody = new RestTemplate().getForEntity("http://localhost:8000/currency-service/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariable);
		
		CurrencyConversionBean body = responseBody.getBody();
		
		System.out.println("body==" +body);
		
		System.out.println("quantity=" +quantity);
		
		return new CurrencyConversionBean(body.getId(), from, to, quantity, body.getConversionMultiple(), body.getPort(),quantity.multiply(body.getConversionMultiple()));
		
	}
	
	@RequestMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyConverterFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity)
	{
		CurrencyConversionBean body = feignProxy.retireiveExchangeValue(from, to);
		return new CurrencyConversionBean(body.getId(), from, to, quantity, body.getConversionMultiple(), body.getPort(),quantity.multiply(body.getConversionMultiple()));
		
	}
	
	
}
