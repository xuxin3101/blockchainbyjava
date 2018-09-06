package net;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import core.Block;
import core.BlockChain;

/**
 * Servlet implementation class Servlet
 */
@WebServlet({ "/Servlet", "/get", "/write" })
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  BlockChain blockChain;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
        blockChain=new BlockChain();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String path=request.getServletPath();
		response.setContentType("text/html");
		out.write("<html>");
		out.write("<head> <title>区块链</title></head><body>");
		
	if(path.equals("/get")) {//查看当前区块
		response.getWriter().write(blockChain.netshow());
		out.write("</body></html>");
	}
	
	if(path.equals("/write")) {//写入新的区块 data=""
	 String data = request.getParameter("data");
	Block block=Block.createnewBlock(blockChain.blocks[blockChain.length-1], data);
	blockChain.appendblock(block);
	response.getWriter().write(blockChain.netshow());
	out.write("</body></html>");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
