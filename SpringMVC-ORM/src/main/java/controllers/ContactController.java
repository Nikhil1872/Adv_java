package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ContactDao;
import model.Contact;

@Controller
public class ContactController {
	
	@Autowired
	ContactDao cdao;
	
	
	
	
	public ContactDao getCdao() {
		return cdao;
	}

	public void setCdao(ContactDao cdao) {
		this.cdao = cdao;
	}

	@RequestMapping("/all")
	public ModelAndView getAll()
	{
		
		List<Contact> clist = cdao.getAll();
		return new ModelAndView("list","contactlist",clist);
		
	}
	
	

}
