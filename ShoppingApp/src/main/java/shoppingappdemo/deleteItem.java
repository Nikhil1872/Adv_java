package shoppingappdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;


@WebServlet("/deleteItem")
public class deleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public deleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//PrintWriter out = response.getWriter();
			//	Object  id = request.getAttribute("pid");
		//		System.out.println("From deleteitem: "+id);
				
			
            //	HttpSession session = request.getSession();
            //	List<Integer> products =(List<Integer>) session.getAttribute("cart");
        		
            // 	ArrayList<Integer> c = (ArrayList<Integer>) session.getAttribute("cart");
				//List<Integer> products =(List<Integer>) session.getAttribute("cart");
				
				//products u = (products)session.getAttribute("products"); 
		//	
			//	products.remove(id);
				
				
	
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
