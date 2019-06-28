package com.nykaa.springboot.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nykaa.springboot.model.CartProduct;
import com.nykaa.springboot.model.Ordr;
import com.nykaa.springboot.model.OrdrProduct;
import com.nykaa.springboot.model.Product;
import com.nykaa.springboot.repository.CartProductRepository;
import com.nykaa.springboot.repository.OrdersProductRepository;
import com.nykaa.springboot.repository.OrdrRepository;
import com.nykaa.springboot.repository.ProductRepository;

@CrossOrigin
@Controller
public class WebController {
	@Autowired
   private CartProductRepository cpr;
   @Autowired
   private ProductRepository pr;
   @Autowired
   private OrdersProductRepository opr;
   @Autowired
   private OrdrRepository or;
   
	@GetMapping("/cart/{userName}")
	public String getByCartUN(Model model,@PathVariable("userName") String userName){
		List<CartProduct> al=new ArrayList<>();
		cpr.findByCartUserName(userName).forEach(al::add);
		List<String> list=new ArrayList<>();
		for(int i=0;i<al.size();i++)
			list.add(al.get(i).getPid());
		model.addAttribute("userName",userName);
		
		
		model.addAttribute("products", pr.findAllById(list));
		return "cart";
	}
	

	
	@GetMapping("/pay/{userName}")
	public String proceedPayment(Model model,@PathVariable("userName") String userName) {
		System.out.println(userName);
		model.addAttribute("userName", userName);
		return "details";
	}
	
	@GetMapping("/ty/{userName}")
	public String done(@PathVariable("userName") String userName) {
		List<CartProduct> al=new ArrayList<>();
		cpr.findByCartUserName(userName).forEach(al::add);
		Ordr o = new Ordr();
		o.setUserName(userName);
		or.save(o);
		for(int i=0;i<al.size();i++) {
			OrdrProduct op=new OrdrProduct();
			op.setPid(al.get(i).getPid());
			op.setO(o);
			opr.save(op);
			cpr.delete(al.get(i));
		}
		return "ty";
	}
	
	@GetMapping("/cs/{userName}")
	public @ResponseBody List<Ordr> getAllOrdr(@PathVariable("userName") String userName){
		List<Ordr> al=new ArrayList<>();
		or.findByUserName(userName).forEach(al::add);
		return al;
	}
	@GetMapping("/cs/op/{oid}")
	public @ResponseBody List<OrdrProduct> getAllOrdersProduct(@PathVariable("oid") Long oid){
		List<OrdrProduct> al=new ArrayList<>();
		opr.findByO_Oid(oid).forEach(al::add);
		return al;
	
	}
	@GetMapping("/myorder/{userName}")
	public String getMyOrders(Model model,@PathVariable("userName") String userName){
		List<Ordr> al=new ArrayList<>();
		or.findByUserName(userName).forEach(al::add);
		List<OrdrProduct> opl=new ArrayList<>();
		List<String> list=new ArrayList<>();
		Map<Long,List<Product>> hm=new HashMap<>();
		for(int i=0;i<al.size();i++)
		{
			opr.findByO_Oid(al.get(i).getOid()).forEach(opl::add);
			
			for(int j=0;j<opl.size();j++)
				list.add(opl.get(j).getPid());
			hm.put(al.get(i).getOid(),pr.findAllById(list));
			
		    list.clear();
			opl.clear();
		}
		model.addAttribute("userName",userName);
	    model.addAttribute("hm", hm);
		return "myorder";
	}
   
}
