package com.student.action;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import com.icesoft.faces.component.tree.IceUserObject;
import com.student.Dao.DataDao;



public class TreeBean {
  int totalcount=0;
    // tree default model, used as a value for the tree component
    private DefaultTreeModel model;
    private HttpServletRequest request;
    
    // root node label, used to insure that it can't be deleted.
    private static final String ROOT_NODE_TEXT = "Hotel";

    // label count increases one for each new node
    private int labelCount = 1;
    private static final String ChildNode=null;

    // object reference used to delete and copy the node
    private DynamicNodeUserObject selectedNodeObject = null;

    public TreeBean() {
    	DefaultMutableTreeNode defaultMutableTreeNode=new DefaultMutableTreeNode();
    	IceUserObject iceUserObject=new IceUserObject(defaultMutableTreeNode);
    	iceUserObject.setText("Root Node");

        // create root node with its children expanded
        DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode();
        DynamicNodeUserObject rootObject = new DynamicNodeUserObject(rootTreeNode, this);
        rootObject.setText(ROOT_NODE_TEXT);
        rootTreeNode.setUserObject(rootObject);

        // model is accessed by by the ice:tree component
        model = new DefaultTreeModel(rootTreeNode);

        // add some child notes
        boolean d=new DataDao().DeleteCalculation();
        List<String> list=new DataDao().collectData();
        System.out.println(list.get(0));
        for (int i = 0; i < list.size(); i++) {
            DefaultMutableTreeNode branchNode = new DefaultMutableTreeNode();
            DynamicNodeUserObject branchObject = new DynamicNodeUserObject(branchNode, this);
            branchObject.setText(list.get(i));
            branchNode.setUserObject(branchObject);
            rootTreeNode.add(branchNode);
            // add some more sub children
            System.out.println(list.get(i));
            Set<String> list1=new DataDao().collectData1(list.get(i));
            Iterator itr = list1.iterator();

            while (itr.hasNext()) {
                    String str = (String) itr.next();

                    System.out.println("Name :" + str);
                DefaultMutableTreeNode subBranchNode = new DefaultMutableTreeNode();
                DynamicNodeUserObject subBranchObject = new DynamicNodeUserObject(subBranchNode, this);
                System.out.println(str);
                int count =new DataDao().collectData2(str);
                int count1 =new DataDao().collectData5(str,list.get(i));
                totalcount=totalcount+count;
                System.out.println(count);
                if(str!=null)
                {
                subBranchObject.setText( str + "("+count+")");
                }
                subBranchObject.setLeaf(true);
                subBranchNode.setUserObject(subBranchObject);
                branchNode.add(subBranchNode);
            }
        }
        System.out.println("totalcount"+totalcount);
    }
    
   

   
   
    public DefaultTreeModel getModel() {
        return model;
    }

   
    public DynamicNodeUserObject getSelectedNodeObject() {
        return selectedNodeObject;
    }

   
    public void setSelectedNodeObject(DynamicNodeUserObject selectedNodeObject) {
        this.selectedNodeObject = selectedNodeObject;
    }

   
    public void deleteSelectedNode(ActionEvent event){
     
        if (selectedNodeObject != null &&
                !selectedNodeObject.getText().equals(ROOT_NODE_TEXT)){
            selectedNodeObject.deleteNode(event);
            selectedNodeObject = null;
        }
    }

    
    public void copySelectedNode(ActionEvent event){
        if (selectedNodeObject != null)
            selectedNodeObject.copyNode(event);
        System.out.println("copy method");
    }

    
    public boolean isDeleteDisabled (){
        //can't delete the root node
        return selectedNodeObject == null ||
                selectedNodeObject.getText().equals(ROOT_NODE_TEXT);
    }

   
    public boolean isCopyDisabled (){
        return selectedNodeObject == null;
    }


    
    public int getIncreasedLabelCount() {
        return ++labelCount;
    }

	
	
}
