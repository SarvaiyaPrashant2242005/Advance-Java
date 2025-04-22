<form action="add-blog" method="post">
    <label>Title:</label>
    <input type="text" name="title" required>

    <label>Content:</label>
    <textarea name="content" required></textarea>

    <label>Username:</label>
    <input type="text" name="username" required>

    <button type="submit">Submit</button>
</form>

<% if (request.getAttribute("error") != null) { %>
    <p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>
