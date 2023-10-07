<%@page import="java.time.Instant"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register your account</title>
    <link rel="stylesheet" href="material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/register.css" >
    <style>
        .form-submit {
        margin-bottom: 10px;
    }
        .loginhere {
        margin-top: 5px; 
    }
    
    .row {
      display: flex;
      justify-content: space-between;
    }
  
    .col-md-6 {
      flex: 1;
      margin-right: 5px;
    }
    </style>
</head>

<body style="background-image: url(img/Fpt02.jpg);">
    <div class="main">

        <section class="signup">
            
            <div class="container">
                <div class="signup-content">
                    <form action="RegisterControl" method="POST" id="signup-form" class="signup-form">

                        <h2 class="form-title">Create account</h2>
                        
                        <div class="col-sm-offset-3 col-sm-9">
                            <p class="text-danger" style="font-size: 15px;">
                                ${message}
                            </p>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="username" id="username" placeholder="Your UserName" required pattern="^[a-zA-Z0-9_]{4,20}$" oninvalid="setCustomValidity('Username must contain alphanumeric characters and underscores, and be between 4 and 20 characters long.')" oninput="setCustomValidity('')"/>
                        </div>
                        
                        <div class="form-group">
                            <input type="password" class="form-input" name="password" id="password" placeholder="Password" required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" oninvalid="setCustomValidity('Password must contain at least one digit, one lowercase letter, one uppercase letter, and be at least 8 characters long.')" oninput="setCustomValidity('')"/>
                            <span class="zmdi zmdi-eye field-icon toggle-password"></span>
                            <i class="bi bi-eye-slash" id="togglePassword"></i>
                        </div>
                        
                        <div class="form-group">
                            <input type="password" class="form-input" name="re_password" id="re_password" placeholder="Confirm Your Password" required/>
                        </div>
                        
                        
                        
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6">
                                    <input type="text" class="form-input" name="first_name" id="first_name" placeholder="Your First Name" required>
                                </div>
                                <div class="col-md-6">
                                    <input type="text" class="form-input" name="last_name" id="last_name" placeholder="Your Last Name" required>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="Your E-mail" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"/>
                        </div>
                        
                        <div class="form-group">
                            <input type="text" class="form-input" name="phone" id="phone" placeholder="Your Phone" required pattern="^\d{10}$|^(\d{3})[- ]?\d{3}[- ]?\d{4}$" oninvalid="setCustomValidity('the phone number must be exactly 10 digits for the format 1234567890 or 123-456-7890.')" oninput="setCustomValidity('')">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="address" id="address" placeholder="Your Address" required>
                        </div>
                        <div class="form-group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Sign Up"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        Have already an account ? <a href="Login.jsp" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>
    </div>   
</body>
</html>