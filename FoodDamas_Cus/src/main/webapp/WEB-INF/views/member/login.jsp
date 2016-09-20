<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">

    <head>
    <base href="../resources/">

		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
		<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	
        <meta charset="utf-8">
        <title>Fullscreen Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>Login</h1>
            <form action="" method="post">
                <input type="text" name="username" class="username" placeholder="Username">
                <input type="password" name="password" class="password" placeholder="Password">
                <button type="submit">Sign me in</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
            <a style="display:inline; text-decoration:none" href="/member/register"><p class="register">register Member</p></a>
            
			<a id="custom-login-btn" style="display:inline; text-decoration:none" href="javascript:loginWithKakao()"> 
				<p class="register" style="font-size: 19px;margin-top: 10px">register KaKao</p>
			</a>
	
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/login.js"></script>
	
		<script type='text/javascript'>
		 var obj="";
	Kakao.init('b05205951a5d98b44df1432dc785354e');
    function loginWithKakao() {
        // 로그인 창을 띄웁니다.
        Kakao.Auth.login({
            success: function(authObj) {
                // 로그인 성공시, API를 호출합니다.
                Kakao.API.request({
                  url: '/v1/user/me',
                  success: function(res) {
                	  obj={
                			  k_id: res.id,
                			  k_nick:res.properties.nickname,
                			  profile_img:res.properties.profile_image,
                			  thumb_img:res.properties.thumbnail_image
                	  }
                		console.log(obj);
               		$.ajax({
            			url: 'http://localhost/member/registerKakao',
            			//contentType : "application/json;charset=UTF-8",
            			type:"post",
            			data:obj,
            			success:function(checkKakao){
							if(checkKakao==""){
								reigsterKakao(obj);
							}else{
								alert("이미 가입한 회원입니다.");

							}
            			}
       /*      			,
            			success:function(checkKaKao){
            				if(checkKaKao==""){
								location.href="http://localhost/member/registerKaKao";

            				}else{
								alert("이미 가입하였습니다.");
								location.href="http://localhost/member/login";

            				}
            			} */
         
            		}); 
                    
                  },
                  fail: function(error) {
                    alert(JSON.stringify(error));
                  }
                });
              },
              fail: function(err) {
                alert(JSON.stringify(err));
              }
        });
        
        function reigsterKakao(params) {
        	   // method = method || "post";
        	    var form = document.createElement("form");
        	    form.setAttribute("method", "post");
        	    form.setAttribute("action", "/member/registerKakao1");
        	    for(var key in params) {
        	        var hiddenField = document.createElement("input");
        	        hiddenField.setAttribute("type", "hidden");
        	        hiddenField.setAttribute("name", key);
        	        hiddenField.setAttribute("value", params[key]);
        	        form.appendChild(hiddenField);
        	    }
        	    document.body.appendChild(form);
        	    form.submit();			
		}
    };
	</script>
    </body>

</html>

