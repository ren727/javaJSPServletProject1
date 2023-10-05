<%@page contentType="text/html;charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id="adto" scope="request" class="bean.animalDto" />
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Include your CSS file -->
    <style>
 table{
  width: 100%;
  border-collapse:separate;
  border-spacing: 0;
}

table th:first-child{
  border-radius: 5px 0 0 0;
}

table th:last-child{
  border-radius: 0 5px 0 0;
  border-right: 1px solid #3c6690;
}

table th{
  text-align: center;
  color:#fffff7;
  background: linear-gradient(#829ebc,#225588);
  border-left: 1px solid #3c6690;
  border-top: 1px solid #3c6690;
  border-bottom: 1px solid #3c6690;
  box-shadow: 0px 1px 1px rgba(255,255,255,0.3) inset;
  
  padding: 10px 0;
}

table td{
  text-align: center;
  border-left: 1px solid #a8b7c5;
  border-bottom: 1px solid #a8b7c5;
  border-top:none;
  box-shadow: 0px -3px 5px 1px #eee inset;
  
  padding: 10px 0;
  background-image:linear-gradient(40deg, #fffff7, #dbf8f9 74%);
}

table td:last-child{
  border-right: 1px solid #a8b7c5;
}

table tr:last-child td:first-child {
  border-radius: 0 0 0 5px;
}

table tr:last-child td:last-child {
  border-radius: 0 0 5px 0;
}

table th,table td{
  text-align: center;
  border: solid 2px #fff;
  color: #829ebc;
  padding: 10px 0;
}
.dogPage1 {
      font-size: 24px; /* Adjust the font size as needed */
      color: #005991 ; /* Text color */
      text-align: center;
      margin-top: 20px;
      font-family: 'Montserrat', sans-serif;
    }

.banner-container {
  align-items: center; /* Center vertically */
  margin: auto;
  width: 800px;
  height: 300px;
  background-color: #3b78ba;
 
}

/* Style for the banner image */
.banner-image {
  width: 70%;
  height: 70%;
  max-height: 80vh; /* Adjust the max height as needed */
  align-items: center; /* Center vertically */
  margin-left: 110;
}

/* Style for the "Go back" button */
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
.popup {
  display: none;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: rgba(0, 0, 0, 0.7);
  color: white;
  padding: 20px;
  border-radius: 5px;
  z-index: 9999;
  animation: fadeOut 2s ease-in-out forwards;
}

@keyframes fadeOut {
  0% {
    opacity: 1;
  }
  100% {
    opacity: 0;
  }
}



    </style>
    
    <script>
        // Function to show the pop-up message
        function showPopupMessage() {
            const popup = document.getElementById('popup-message');
            popup.style.display = 'block';

            popup.style.display = 'block';
            popup.style.backgroundColor = '#5f9eef'; // Set the background color (e.g., red)
            popup.style.color = '#FFFFFF'; // Set the text color (e.g., white)
            popup.style.border = '2px solid #046aef'; // Set the border (e.g., black)

            setTimeout(function () {
                popup.style.display = 'none';
            }, 5000); // Adjust the time (in milliseconds) as needed (2 seconds in this example)
        }

        // Call the showPopupMessage function when the page loads
        window.addEventListener('load', showPopupMessage);
    </script>
</head>
<body>
    <div class="banner-container">
    <!-- Banner Image -->
    <img src="adoptionResult.png" alt="Banner Image" class="banner-image">
     </div>
     
 <div id="popup-message" class="popup">
  サイトに来てくれてありがとう！
</div>
     
 
<h2 class="dogPage1">Available Animals You Selected</h2>
<table border="1">
    <tr>
        <th width="10">No.</th>
        <th width="20">Type.</th>
        <th width="20">Size</th>
        <th width="40">Breed</th>
        <th width="30">Name</th>
        <th width="200">Memo</th>
    </tr>

    <%
    // Arraylistの中身をサイズ分だけ取り出す
    for(int i = 0; i < adto.size(); i++){
        animalBean ab = adto.get(i); // まだ}を閉じない！
    %>

    <tr>
        <td class="icon bird" align="center"><%= ab.getNo() %></td>
        <td align="center"><%= ab.getType() %></td>
        <td align="center"><%= ab.getSize() %></td>
        <td align="center"><%= ab.getBreed() %></td>
        <td align="center"><%= ab.getName() %></td>
        <td align="center"><%= ab.getMemo() %></td>
    </tr>
    <% } %>
</table>

<a href="index.html" class="button go-back-button">Go back</a>

</body>
</html>
