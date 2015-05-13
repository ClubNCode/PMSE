<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="JSTreeGraph.css" rel="stylesheet" type="text/css" />
    <script src="JSTreeGraph.min.js" type="text/javascript"></script>

    <style type="text/css">
        
	    
	    .Container
	    {
            position:absolute;
            top:220px;
            left:50px;
	    }
    </style>
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>
    
    <%String query= (String)session.getAttribute("query");
    System.out.println(query);
    %>
    
   
    <div><select id="dlLayout" onchange="ChangeLayout()"><option value="Horizontal">Horizontal</option>
        <option value="Vertical">Vertical</option></select> </div>
    
    <div class="Container" id="dvTreeContainer"></div>


    <script type="text/javascript">
    <!--
        // Root node
       
        var rootNode = { Content: <%=query%>, Nodes:[] };
 var myMap = {  
          
        1: 'My value1',  
          
        2: 'My value2',  
          
        3: 'My value3',  
          
        4: 'My value4'  
          
   }; 
        // First Level
        rootNode.Nodes[0] = { Content: "Hotel Locator" };
        rootNode.Nodes[1] = { Content: "Reservation" };
        rootNode.Nodes[2] = { Content: "Facilities" };
        rootNode.Nodes[3] = { Content: "Restaurant" };
       
         
        // Second Level
          rootNode.Nodes[0].Nodes = [{ Content : "Map" }  ];
          rootNode.Nodes[1].Nodes = [{ Content : "Room Rate" } , { Content: "Online Reservation" } ];
          rootNode.Nodes[2].Nodes = [{ Content : "Meeting Room" } , { Content: "Meeting Facilities" } ];
         

        // Third Level
        rootNode.Nodes[1].Nodes[0].Nodes = [{ Content: "Spacial Discount Rate" } ];
       
        // Draw the tree for the first time
        RefreshTree();

        function RefreshTree() {
            DrawTree({ Container: document.getElementById("dvTreeContainer"),
                        RootNode: rootNode,
                        Layout: document.getElementById("dlLayout").value,
                        OnNodeClick: NodeClick,
                        OnNodeDoubleClick: NodeDoubleClick });
        }

        function NodeClick() {
            if (this.Node.Content == "rastaurant") {
                alert(this.Node.Content);
            }
            if (event && event.shiftKey) {
                // Add new Child if Expanded
                if (!this.Node.Collapsed) {
                    if (!this.Node.Nodes) this.Node.Nodes = new Array();
                    var newNodeIndex = this.Node.Nodes.length;
                    this.Node.Nodes[newNodeIndex] = new Object();
                    this.Node.Nodes[newNodeIndex].Content = this.Node.Content + "." + (newNodeIndex + 1);
                    RefreshTree();
                }
            };
        }

        function NodeDoubleClick() {
            if (this.Node.Nodes && this.Node.Nodes.length > 0) { // If has children
                this.Node.Collapsed = !this.Node.Collapsed;
                RefreshTree();
            }
        }

        function ChangeLayout() {
            RefreshTree();
        }

     -->
    </script>

</body>
</html>
