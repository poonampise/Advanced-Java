<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <%@ include file="cache_control.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>login page</title>

</head>
<style>
<body>


 form {   
        border: 3px solid #f1f1f1;   
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px;   
        background-color: lightblue;  
    }   
</style>   
</head>    
<body>    


    <center> <h1> Contact Login Form </h1> </center>   
      <form action="<%= request.getContextPath() %>/login123" method="post">
        <div class="container">   
            <label>Username : </label>   
            <input type="text" placeholder="Enter Username" name="username" required>  
            <label>Password : </label>   
            <input type="password" placeholder="Enter Password" name="password" required>  
           
           <input type="submit" value="login" />
           
           
            <input type="checkbox" checked="checked"> Remember me   
              
            <h3>New User<a href="register.jsp"> Register here........ </a> </h3>  
        </div>   
    </form>    
    
</body>
</html>