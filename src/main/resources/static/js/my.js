$("#login").on('click', function() {
	var username = $("#username").val();
  	var password1 = $("#password").val();
    var password =  hex_md5(password1);


  	var captcha = $("#captcha").val();
  	checkUser(username,password,captcha,0);
});

$("#relogin").on('click', function() {
    clearCookie("name");
    window.location.href = "/index";
});

$("#register").on("click",function(){
    window.location.href = "/register/home";
})

$("#register_submit").on('click',function(){
    if (handleValidation().form()) {
    var username = $("#username_register").val();
    var mobile = $("#phone").val();
    var password11 = $("#psw").val();
	var password22 = $("#pswa").val();
	var email = $("#email").val();
    var password =  hex_md5(password11);
    var password2 =  hex_md5(password22);



	if(password != password2){
        window.wxc.xcConfirm("两次密码输入不一致！请检查!", window.wxc.xcConfirm.typeEnum.warning);
		return false;
	}

    if( !$("#agree").prop('checked')){
        window.wxc.xcConfirm("请阅读并同意用户协议!", window.wxc.xcConfirm.typeEnum.warning);
    		return false;
    }
	$.ajax({
        url:"/user/insert",
        type:'POST',
        data:{
            "username":username,
            "password":password,
			"mobile":mobile,
			"email":email
        },
        dataType:'json',
        success:function(result){
        	if(result.flag == "0"){
                window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.success,{
                    onOk:function () {
                        window.location.href="/index";
                    }
                });
		   }else{
                window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.warning);
		   }
        }
	})
	}
});





function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

//获取cookie
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}


function clearCookie(name) {
    setCookie(name, "", -1);
   // var name= getCookie("name");
    //alert(name);
}

function checkUser(username,password,captcha,iscookie) {
    if (iscookie == 0) {
        if (username == null || username == '') {
            window.wxc.xcConfirm("用户名不能为空!", window.wxc.xcConfirm.typeEnum.warning);
            return false;
        }

        if (password == null || password == '') {
            window.wxc.xcConfirm("密码不能为空!", window.wxc.xcConfirm.typeEnum.warning);
            return false;
        }
        if(captcha == null || captcha  == ''){
                window.wxc.xcConfirm("验证码不能为空!", window.wxc.xcConfirm.typeEnum.warning);
                return false;
            }

        $.ajax({
            url: "/login/check",
            type: 'POST',
            data: {
                "username": username,
                "password": password,
                "captcha":captcha
            },
            dataType: 'json',
            success: function (result) {
                console.log(result.flag)
                if (result.flag == "0") {
                    window.wxc.xcConfirm("登陆成功,欢迎回来!" + username, window.wxc.xcConfirm.typeEnum.success, {
                        onOk: function () {
                            window.location.href = "/home";
                            setCookie("name", username, 1);
                            //var name = getCookie("name");
                            //alert(name);
                        }
                    });
                } else if (result.flag == "1") {
                    window.wxc.xcConfirm("登陆成功,欢迎回来!" + username, window.wxc.xcConfirm.typeEnum.success, {
                        onOk: function () {
                            window.location.href = "/user/list";
                        }
                    });
                }else if (result.flag == "-2") {
                    window.wxc.xcConfirm("验证码错误!请重新输入...", window.wxc.xcConfirm.typeEnum.warning);
                } else {
                    window.wxc.xcConfirm("用户名或密码错误!请重新输入...", window.wxc.xcConfirm.typeEnum.warning);
                }
            }

        });
    }
    if(iscookie == 1)
    {
        window.location.href = "/home";

        }
}





$("#search").on('click',function(){

	var username = $("#search_input").val();

    $.ajax({
        url:"/user/search",
        type:'POST',
        data:{
            "username":username
        },
        dataType:'text',
        success:function(result){
			$("#panel").html(result);
        }
    });
});

$("#modify_submit").on('click',function(){
    var username = $("#username_modify").val();
    var mobile = $("#phone_modify").val();
    var email =  $("#email_modify").val();

    $.ajax({
        url:"/user/modify",
        type:'POST',
        data:{
            "mobile":mobile,
            "email":email,
            "username":username
        },
        dataType:'json',
        success:function(result){
            window.wxc.xcConfirm("用户信息修改成功!", window.wxc.xcConfirm.typeEnum.success,{
                onOk:function(){
                    window.location.href="/user/list";
                }
            });
        }
    });
});

$("#delete").on('click',function(){

    var id = $("#customer.username").val();

    $.ajax({
        url:"/user/delete",
        type:'POST',
        data:{
            "username":username
        },
        dataType:'text',
        success:function(result){
            $("#panel").html(result);
        }
    });
});

function deleteclick(username){

    var id = username;
    $.ajax({
        url:"/user/delete",
        type:'POST',
        data:{
            "username":username
        },
        dataType:'text',
        success:function(result){
          alert(result);
            window.location.href="/user/list";
        }
    });
};

