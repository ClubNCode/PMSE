package com.student.action;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;

public class TreeAction extends HttpServlet {

	
	private static final long serialVersionUID = -2941564269120432640L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	   JFrame frame = new JFrame("TreeGraph");
		Container c = frame.getContentPane();
		c.setLayout( new BorderLayout() );

		
		HttpSession httpSession=request.getSession();
		
		String sname=(String)httpSession.getAttribute("query");
		System.out.println(sname);
		 Vector<String> sdata=new DataDao().getValueData();
		 Vector<DataFormBean> subdata=new DataDao().getValueData1();
		
		
		//Create top node of a tree
		

		final DefaultMutableTreeNode top = new DefaultMutableTreeNode(sname);
		
		 		

		
		Iterator iterator = sdata.iterator();  
		   
		while (iterator.hasNext()) {  
		   String key1 = iterator.next().toString(); 
		   System.out.println(key1);
		
		 //Create a subtree for query
			
		    final DefaultMutableTreeNode key11 = new DefaultMutableTreeNode(key1);
			top.add(key11);
		
			Iterator it = subdata.listIterator();

			while (it.hasNext()) 
			{

				DataFormBean wb = (DataFormBean) it.next();					
                String superdata=wb.getSuperdata();
                System.out.println(superdata);
                String sub=wb.getSubdata();
                System.out.println(sub);
			    
			   
			  if(superdata.equalsIgnoreCase(key1)){
				  			  
				  final DefaultMutableTreeNode b1 = new DefaultMutableTreeNode(sub);
					key11.add(b1);
				  
			  }
	       }
		
		}
       		//Creating tree
		final JTree tree = new JTree(top);

		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		final JScrollPane jsp = new JScrollPane(tree,v,h);
		c.add(jsp,BorderLayout.CENTER );

		final JTextField text = new JTextField("",20);
		c.add(text,BorderLayout.SOUTH);

		tree.addMouseListener( new MouseAdapter()
		{
		public void mouseClicked( MouseEvent me)
		{
		TreePath tp = tree.getPathForLocation(me.getX(),me.getY() );
		if( tp != null )
		text.setText(tp.toString() );
		else
		text.setText("");
		}
		}
		);

		frame.setSize(300,200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
		
		}
		
}
