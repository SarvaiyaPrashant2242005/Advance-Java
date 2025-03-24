
<form>
<input type="text" name="txtName" placeholder="Enter any Name"/>
<input type="submit" name="btnSubmit" value="Generate"/>
</form>

<%
if(request.getParameter("btnSubmit")!=null){
        String Name = request.getParameter("txtName");
        application.setAttribute("app_name",Name);
        }
     }
 %>