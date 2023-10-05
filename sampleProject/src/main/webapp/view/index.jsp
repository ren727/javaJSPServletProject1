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
<title>Post Your Animals</title>
<style>
body{
    background:radial-gradient(#efeda0, #c585e2);
    background-size:4px 4px;
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
</style>
<link rel='stylesheet' href='css/style.css'>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<h2>List of Pets that Need Families and Friends</h2>
	<div>
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Detail</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
			for (User u : (List<User>) request.getAttribute("bookList")) {
			%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><a href="/sampleProject/ShowBookDetail?id=<%=u.getId()%>">Detail</a></td>
				<td><a href="/sampleProject/view/edit.jsp?id=<%=u.getId()%>">Edit</a></td>
				<td><a href="/sampleProject/DeleteBook?id=<%=u.getId()%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<br>
	</div>
	<h1 class="content">Post Your Own Pets Needing Homes</h1>
	<h2>List of Animals</h2>
	
	<p class="content">List Your Own Animal Needing a New Home</p>
	<!-- Add a container for the form -->
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <form action="/sampleProject/CreateBook" method='POST'>
        <div class="form-group">
          <label for="type">Type</label>
          <input type='text' name='type' id="type" class="form-control" placeholder='Please Enter Type of Animal'>
        </div>
        <div class="form-group">
          <label for="size">Size</label>
          <input type='text' name='size' id="size" class="form-control" placeholder='Please Enter the Size'>
        </div>
        <div class="form-group">
          <label for="breed">Breed</label>
          <input type='text' name='breed' id="breed" class="form-control" placeholder='Please Enter the Breed'>
        </div>
        <div class="form-group">
          <label for="name">Name</label>
          <input type='text' name='name' id="name" class="form-control" placeholder='Please Enter the Name'>
        </div>
        <div class="form-group">
          <label for="memo">Memo</label>
          <textarea type="text" name='memo' id="memo" class="form-control" cols="35" rows="2" placeholder='Please enter the memo'></textarea>
        </div>
        <input class='btn btn-primary' type='submit' value='Post Your Pet'>
      </form>
    </div>
  </div>
</div>
	
	<a href="index.html" class="button go-back-button">Go back</a>
</body>
</html>
