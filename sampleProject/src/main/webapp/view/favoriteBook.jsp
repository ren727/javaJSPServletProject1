<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pack.User"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Details</title>
    <style>
        body {
            background: radial-gradient(#efeda0, #c585e2);
            background-size: 4px 4px;
            perspective: 400px;
            width: 100%;
            height: 600px;
        }

        .go-back-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3eb3f2;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            margin-top: 20px;
        }

        .go-back-button:hover {
            background-color: #1f1bfc;
        }


        .dogPage1 {
            font-size: 24px;
            color: #4dc2f8;
            text-align: center;
            margin-top: 20px;
        }

        .banner-container {
            align-items: center;
            margin: auto;
            width: 800px;
            height: 300px;
            background-color: #e2aaaa;
        }

        .banner-image {
            width: 70%;
            height: 70%;
            max-height: 80vh;
            align-items: center;
            margin-left: 110;
        }
    </style>
</head>

<body>
    <h2 class="dogPage1">Details</h2>
    <div class="banner-container">
        <!-- Banner Image -->
        <img src="detailBanner.png" alt="Banner Image" class="banner-image">
    </div>
    <table border="1" class="table table-striped table-hover">
        <tr>
            <th width="10">No.</th>
            <th width="20">Type.</th>
            <th width="20">Size</th>
            <th width="50">Breed</th>
            <th width="30">Name</th>
            <th width="200">Memo</th>
        </tr>

        <%
        for (User u : (List<User>) request.getAttribute("bookList")) {
        %>
        <tr>
            <td align="center"><%= u.getId() %></td>
            <td align="center"><%= u.getType() %></td>
            <td align="center"><%= u.getSize() %></td>
            <td align="center"><%= u.getBreed() %></td>
            <td align="center"><%= u.getName() %></td>
            <td align="center"><%= u.getMemo() %></td>
        </tr>
        <% } %>
    </table>

    <a href="index.html" class="button go-back-button">Go back</a>
</body>
</html>
