<html xmlns="http://www.w3.org/1999/html">
<head>
    <link rel="stylesheet" href="/resource/css/login.css" type="text/css"/>
    <link rel="stylesheet" href="/resource/css/reset.css" type="text/css"/>
    <script type="text/javascript" src="/resource/jquery/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/resource/jquery/jquery.cookie.js"></script>
    <title>登录</title>
</head>
<body>
<div class="login-bg">
    <div class="login-title">welcome</div>
    <div class="login-form">
        <form class="form" action="/login/login.do" method="post">
            <div id="check-message" ></div>
            <input type="text" id="email" name="email" placeholder="Username">
            <input type="password" id="pswd" name="pswd" placeholder="Password">
            <label><input id="remember-me" type="checkbox" name="rememberMe"/>记住我</label>
            <button type="button" id="login-button">Login</button>
            <button type="button" id="register-button">Register</button>
        </form>
    </div>
</div>
<script>
    $(document).ready(function(){
        /*从cookie中读取表单*/
        var rememberMe = $.cookie("rememberMe");
        if(null!=rememberMe&&'undefined'!=rememberMe&&rememberMe){
            $("#remember-me").attr("checked","true");
            var username = $.cookie("username");
            $("#email").val(username);
            var password = $.cookie("password");
            $("#pswd").val(password);
        }
        /*记住用户名密码*/
        $("#remember-me").click(function(){
            var rememberMe = $(this).is(":checked");
            if(rememberMe){
                $.cookie("rememberMe",true);
                $.cookie("username",$("#email").val());
                $.cookie("password",$("#pswd").val());
            }else{
                $.removeCookie("rememberMe");
                $.removeCookie("username");
                $.removeCookie("password");
            }
        });
        /*校验用户名*/
        $("#email").bind("blur",function(){
            var username = $(this).val();
            if(null==username||'undefined'==username||''==username){
                $("#check-message").text("").css("display","none");
                return;
            }
            $.ajax({
                url:"/login/checkUsername.do",
                type:"post",
                dataType:"json",
                data:{email:username},
                success:function(data){
                    if(!data["success"]){
                        $("#check-message").text(data["message"]).css("display","block");
                    }else{
                        $("#check-message").text("").css("display","none");
                    }
                },
                error:function(data){
                    var exception = JSON.stringify(data);
                    alert(exception);
                }

            })
        });
        /*登录*/
        $("#login-button").click(function(){
            var username = $("#email").val();
            var password = $("#pswd").val();
            var rememberMe = $("#remember-me").is(":checked");
            $.ajax({
                url:"/login/login.do",
                type:"post",
                dataType:"json",
                data:{email:username,pswd:password,rememberMe:rememberMe},
                success:function(data){
                    if(!data["success"]){
                        $("#check-message").text(data["message"]).css("display","block");
                    }else{
                        $("#check-message").text("").css("display","none");
                        location.href="/";
                    }
                },
                error:function(data){
                    var exception = JSON.stringify(data);
                    alert(exception);
                }

            })
        });
    });
</script>
</body>
</html>
