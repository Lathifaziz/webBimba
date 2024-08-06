function toglePasswordVisibility() {
    let password = document.getElementById("pwd1");
    let requirePassword = document.getElementById("pwd")
    let checkPassword = document.getElementById("check1");
    
    if (checkPassword.checked) {
        password.type = "text";
        requirePassword.type = "text"
     } else {
        password.type = "password";
     }

}