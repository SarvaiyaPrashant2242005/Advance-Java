<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Result Classification</title>
</head>
<body>
    <%
        float m = 100;

        if (m > 75) {
            out.print("Distinction");
        } else if (m >= 60) {
            out.print("First Class");
        } else if (m >= 35) {
            out.print("PASS Class");
        } else {
            out.print("FAIL");
        }
    %>
</body>
</html>
