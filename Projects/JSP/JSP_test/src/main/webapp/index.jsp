<html>
<body>
<form  method="post">
<input type="number" name="txtFirstNum" />
<input type="number" name="txtSecNum" /> </br>
<select name="operation">
    <option value="+">+</option>
    <option value="-">-</option>
    <option value="*">*</option>
    <option value="/">/</option>
    <option value="%">%</option>
</select>

<input type="submit" value="Calculate" name="btnSubmit"/>
</form>
<%
    String btn = request.getParameter("btnSubmit");

    if(btn!=null){
    int num1 = Integer.parseInt(request.getParameter("txtFirstNum").equals("")?"0":request.getParameter("txtFirstNum"));
    int num2 = Integer.parseInt(request.getParameter("txtSecNum").equals("")?"0":request.getParameter("txtSecNum"));
    String operation = request.getParameter("operation");

    switch(operation){
        case "+":
            out.println(num1+num2);
            break;
        case "-":
            out.println(num1-num2);
            break;
        case "*":
            out.println(num1*num2);
            break;
        case "/":
            if(num2==0) out.println("Invalid division");
             else out.println(num1/num2);
            break;
        case "%":
            out.println(num1%num2);
            break;
    }
    }


    %>
</body>
</html>
