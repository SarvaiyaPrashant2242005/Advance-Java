<%@ page import="java.time.LocalDate" %>

<form method="get">
    <input type="date" name="dob" />
    <input type="submit" value="Submit" />
</form>

<%
String year = request.getParameter("dob");

int age = 0; // Default age

if (year != null && !year.isEmpty()) {
    try {
        int extractedYear = Integer.parseInt(year.substring(0, 4));
        int currentYear = LocalDate.now().getYear();
        age = currentYear - extractedYear;
    } catch (NumberFormatException e) {
        out.println("<h2>Error: Invalid date format</h2>");
    }
}
%>

<h2>Age: <%= age %></h2>
