<center>
<h1> GST CALCLULATOR </h1>
<form method="post">
    <input type="radio" name="typeGST" value="gst"/>
    <input type="radio" name="typeGST" valur="revgst"/>
    <label for="txtAmount">Amount : </label>
    <input type="number" name="txtAmount" placeholder="Enter Amount"/>
    </br>
    </br>
    <label for="GSTper">GST Percentage : </label>
    <input type="number" name="GSTper" placeholder="Enter GST percentage"/>
    </br>
    </br>
    <label for="IGST">IGST  : </label>
    <input type="number" name="IGST" placeholder="Enter Amount"/>
    </br>
    </br>
    <label for="SGST">SGST  : </label>
    <input type="number" name="SGST" placeholder="Enter SGST"/>
    </br>
    </br>
     <label for="CGST">CGST  : </label>
    <input type="number" name="CGST" placeholder="Enter CGST"/>
    </br>
    </br>
    <label for="txtTotal">Total  : </label>
    <input type="number" name="txtTotal" placeholder="Enter TOTAL"/>
    </br>
    </br>
    <input type="submit" name="btnCalc" value="calculate"/>
</form>
</center>

<%
    double amnt = 0;
    double gstPer = 0;
    double igst = 0;
    double sgst = 0;
    double cgst = 0;
    double total = 0;

    String btnCalc = request.getParameter("btnCalc");
    if(btnCalc!=null){
        amnt = Double.parseDouble(request.getParameter("txtAmount"));
        gstPer = Double.parseDouble(request.getParameter("GSTper"));
    }
%>