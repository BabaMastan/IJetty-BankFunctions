<!DOCTYPE html>
<%@page import="beans.CustomerInfo"%>
<html>

<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	
	<title> | Home</title>
	
	<style type="text/css">
	/*
	 CSS-Tricks Example
	 by Chris Coyier
	 http://css-tricks.com
*/

* { margin: 0; padding: 0; }
html { overflow-y: scroll; }
body { font: 12px/1.4 Helvetica, sans-serif; background: #333; color: #333; }
.group:after { visibility: hidden; display: block; font-size: 0; content: " "; clear: both; height: 0; }
.group { display: inline-block; clear: both; }
/* start commented backslash hack \*/ * html .group { height: 1%; } .group { display: block; } /* close commented backslash hack */
article, aside, figure, footer, header, hgroup, menu, nav, section { display: block; }
a:focus { outline: 0; }

#page-wrap { 
    width: 1080px; margin: 60px auto 5px; background: #91c7ff; 
    height: 720px; margin: 60px auto 5px;
    padding: 8px;
    background: -webkit-gradient(linear, left top, left bottom, from(#eee), to(#ccc));
	background: -moz-linear-gradient(top,  #eee,  #ccc);
	-webkit-border-radius: 16px;
	-moz-border-radius: 16px;
}

#main-content { padding: 14px; }

h1 { font: bold 32px Helvetica, Arial, Sans-Serif; letter-spacing: -1px; padding: 14px; color: #333; text-shadow: 1px 1px 1px white; }
p { margin: 0 0 15px 0; }
 
nav ul { 
    list-style: none; background: #154c85; padding: 5px 20px; width: 1000px; position: relative; 
    left: -9px;
}
nav ul li { display: inline; }
nav ul li a {
	display: block;
	float: left;
	border-top: 1px solid #96d1f8;
	background: #3e779d;
	background: -webkit-gradient(linear, left top, left bottom, from(#65a9d7), to(#3e779d));
	background: -moz-linear-gradient(top,  #65a9d7,  #3e779d);
	height: 20px;
	padding: 0 10px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	-webkit-box-shadow: rgba(0,0,0,1) 0 1px 3px;
	-moz-box-shadow: rgba(0,0,0,1) 0 1px 0;
	text-shadow: rgba(0,0,0,.4) 0 1px 0;
	-webkit-text-stroke: 1px transparent;
	font: bold 11px/16px "Lucida Grande", "Verdana", sans-serif;
	color: rgba(255,255,255,.85);
	text-decoration: none; 
	margin: 0 5px 0 0;
}
nav ul li a:hover {
	border-top: 1px solid #4789b4;
	background: #28597a;
	background: -webkit-gradient(linear, left top, left bottom, from(#3d789f), to(#28597a));
	background: -moz-linear-gradient(top,  #3d789f,  #28597a);
	color: rgba(255,255,255,.85); 
}	
nav ul li a:active, nav ul li a.current {
	border-top-color: #245779;
	background: #1b435e;
	position: relative;
	top: 1px; 
}
table, <!--caption,--> tbody, tfoot, thead, tr, th, td {
		margin:0;
		padding:0;
		border:0;
		outline:0;
		font-size:100%;
		vertical-align:center;
		background:transparent;
		color: black;
	}
	
	
	
	/*#content {width:65%; max-width:690px; margin:6% auto 0;}*/
	
	/*
	Pretty Table Styling
	CSS Tricks also has a nice writeup: http://css-tricks.com/feature-table-design/
	*/
	
	table {
		color: black;
		  background: #E8EAEB;
    overflow: hidden;
    padding: 5px 8px;
    width: 1000px;
		overflow:hidden;
		border:1px solid #d3d3d3;
				-moz-border-radius:115px 15px 15px 5px; /* FF1+ */
		-webkit-border-radius:115px 15px 15px 5px; /* Saf3-4 */
		border-radius: 115px 15px 15px 5px;
		-moz-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
		-webkit-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
	}
	
	th, td {padding:18px 28px 18px; text-align:center; }
	
	th {padding-top:22px; text-shadow: 1px 1px 1px #fff; background:#e8eaeb;}
	
	td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0;}
	
	
	
	td.first, th.first {text-align:left}
	
	td.last {border-right:none;}
	
	/*
	Background gradients are completely unnecessary but a neat effect.
	*/
	
	td {
		background: -moz-linear-gradient(100% 25% 90deg, #fefefe, #f9f9f9);
		background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f9f9f9), to(#fefefe));
	}
	
	tr.odd-row td {
		background: #eeeeee; /* Old browsers */
background: -moz-linear-gradient(top,  #eeeeee 0%, #cccccc 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#eeeeee), color-stop(100%,#cccccc)); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  #eeeeee 0%,#cccccc 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  #eeeeee 0%,#cccccc 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  #eeeeee 0%,#cccccc 100%); /* IE10+ */
background: linear-gradient(to bottom,  #eeeeee 0%,#cccccc 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#eeeeee', endColorstr='#cccccc',GradientType=0 ); /* IE6-9 */



	}
	
	th {
		background: -moz-linear-gradient(100% 20% 90deg, #e8eaeb, #ededed);
		background: -webkit-gradient(linear, 0% 0%, 0% 20%, from(#ededed), to(#e8eaeb));
	}
	
	/*
	I know this is annoying, but we need additional styling so webkit will recognize rounded corners on background elements.
	Nice write up of this issue: http://www.onenaught.com/posts/266/css-inner-elements-breaking-border-radius
	
	And, since we've applied the background colors to td/th element because of IE, Gecko browsers also need it.
	*/
	
	tr:first-child th.first {
		text-align: center;
		-moz-border-radius-topleft:5px;
		-webkit-border-top-left-radius:5px; /* Saf3-4 */
	}
	
	tr:first-child th.last {
		-moz-border-radius-topright:5px;
		-webkit-border-top-right-radius:5px; /* Saf3-4 */
	}
	
	tr:last-child td.first {
		-moz-border-radius-bottomleft:5px;
		-webkit-border-bottom-left-radius:5px; /* Saf3-4 */
	}
	
	tr:last-child td.last {
		-moz-border-radius-bottomright:5px;
		-webkit-border-bottom-right-radius:5px; /* Saf3-4 */
	}


footer { color: #999; margin: 0 auto; width: 500px; }
	</style>
	
	<!--[if IE]>
      <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
    <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>
   <script type='text/javascript' src='js/jquery.ba-hashchange.min.js'></script>
    <script type='text/javascript' src='js/dynamicpage.js'></script>
</head>

<body>

    <?php include('../header.php'); ?>

	<div id="page-wrap">

        <header>
		  <h1>Dynamic Page</h1>
		
		  <nav>
		      <ul class="group">
		      	  
		      	  
		          <li><a href="withdraw.html">Withdraw</a></li>
		          <li><a href="deposit.html">Deposit</a></li>
		          <li><a href="transfer.html">Transfer</a></li>
		      </ul>
		  </nav>
		</header>
		
		<section id="main-content">
<div id="guts">
		
		  <h2>Options for Manager</h2>
		<li><a href="addcustomer.html">Add New Customers</a></li>
		 <li><a href="selectall.html">Select all Customers</a></li>
		 <br>
		<center> 
<%@page import="java.util.ArrayList"%>
<%
ArrayList<CustomerInfo> list=(ArrayList<CustomerInfo>)request.getAttribute("xyz");
%>
<table border="2">
<tr>
<td>
Account Number
</td>
<td>
Name
</td>
<td>
Balance
</td>
<td>
Last Visited Date
</td>
</tr>
<% for(int i=0;i<list.size();i++)
{
CustomerInfo temp=list.get(i);
//String cocn="employeeupdate.jsp?id="+temp.id+"&name="+temp.name+ "&salary="+temp.salary+"&managername="+temp.managername;

 %>

<tr>
<td><%=temp.getAccno() %></td>
<td><%=temp.getUsername() %></td>
<td><%=temp.getBalance()%></td>
<td><%=temp.getLastvisiteddate() %></td>
</tr>
<%} %>


</table>
		</div>
		</section>
		
	</div>
	
	<footer>
	  &copy;Mastan Pvt limited
	</footer>

	<?php include('../footer.php'); ?>

</body>

</html>