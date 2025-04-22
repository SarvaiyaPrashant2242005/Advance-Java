<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>

    <!-- Google Fonts: Poppins -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
        }

        body {

            background: linear-gradient(to right, #6dd5fa, #2980b9);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: #ffffff;
            padding: 40px 30px;
            width: 100%;
            max-width: 450px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #2c3e50;
            font-weight: 600;
        }

        .form-group {
            margin-bottom: 18px;
        }

        .form-group input,
        .form-group select {
            width: 100%;
            padding: 12px 14px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 14px;
            background-color: #f9f9f9;
            transition: border 0.3s ease, box-shadow 0.3s ease;
        }

        .form-group input:focus,
        .form-group select:focus {
            border-color: #3498db;
            box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
            outline: none;
            background-color: #fff;
        }

        button {
            width: 100%;
            padding: 14px;
            background-color: #3498db;
            border: none;
            color: #fff;
            font-size: 15px;
            border-radius: 8px;
            font-weight: 500;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        button:hover {
            background-color: #2980b9;
        }

        @media (max-width: 500px) {
            .form-container {
                padding: 25px 20px;
            }
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>User Registration</h2>
    <form action="Registration" method="post">
        <div class="form-group">
            <input type="text" name="fullName" placeholder="Full Name" required />
        </div>
        <div class="form-group">
            <input type="email" name="email" placeholder="Email Address" required />
        </div>
        <div class="form-group">
            <input type="text" name="username" placeholder="Username" required />
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Password" required />
        </div>
        <div class="form-group">
            <input type="text" name="phone" placeholder="Phone Number" required />
        </div>
        <div class="form-group">
            <select name="gender" required>
                <option value="">Select Gender</option>
                <option>Male</option>
                <option>Female</option>
                <option>Other</option>
            </select>
        </div>
        <div class="form-group">
            <input type="date" name="dob" required />
        </div>
        <button type="submit">Register</button>
    </form>
</div>

</body>
</html>