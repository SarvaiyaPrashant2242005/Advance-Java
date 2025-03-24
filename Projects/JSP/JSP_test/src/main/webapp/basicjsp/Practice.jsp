<form>
<input type="number" name="txtNum" placeholder="Enter any number"/>
<input type="submit" name="btnSubmit" value="Generate"/>
</form>
<%
    if(request.getParameter("btnSubmit")!=null){
        int num = Integer.parseInt(request.getParameter("txtNum"));
        for(int i =0;i<num;i++){
        for(int j =0;j<num;j++){
             int randomNumber = (int) (Math.random() * 900000) + 100000;
             String color = "#" + Integer.toString(randomNumber);
              out.print("<div style='display:inline-block;font-size:50;border:2px solid green;height:100px;width:100px;margin:10px;background-color:" + color + ";'>"+(j+1)+"</div>");
        }
        out.print("<br/>");
  }
}
%>