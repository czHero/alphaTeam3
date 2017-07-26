$("#login").on('click', function() {
	var username = $("#username").val();
  	var password = $("#password").val();
  	checkUser(username,password);
});

$("#register").on("click",function(){
    window.location.href = "/register/home";
})

$("#register_submit").on('click',function(){
    var username = $("#username_register").val();
    var mobile = $("#phone").val();
    var password = $("#psw").val();
	var password2 = $("#pswa").val();
	var email = $("#email").val();

	if(username == "" || username == null){
        window.wxc.xcConfirm("用户名不能为空!", window.wxc.xcConfirm.typeEnum.warning);
	    return false;
    }

    if(mobile == "" || mobile == null){
        window.wxc.xcConfirm("手机号码不能为空!", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }

    if(email == "" || email == null){
        window.wxc.xcConfirm("邮箱不能为空!", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }

    if(password == "" || password == null){
        window.wxc.xcConfirm("密码不能为空!", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }

	if(password != password2){
        window.wxc.xcConfirm("两次密码输入不一致！请检查!", window.wxc.xcConfirm.typeEnum.warning);
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
});


function checkUser(username,password){
	if(username == null || username == ''){
        window.wxc.xcConfirm("用户名不能为空!", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }

    if(password == null || password  == ''){
        window.wxc.xcConfirm("密码不能为空!", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }

	$.ajax({
		url:"/login/check",
        type:'POST',
		data:{
			"username":username,
			"password":password
		},
        dataType:'json',
        success:function(result){
            console.log(result.flag )
            if(result.flag == "0"){
                window.wxc.xcConfirm("登陆成功,欢迎回来!" + username, window.wxc.xcConfirm.typeEnum.success,{
                    onOk:function () {
                        window.location.href="/home";
                    }
                });
            }else if (result.flag == "1") {
                window.wxc.xcConfirm("登陆成功,欢迎回来!" + username, window.wxc.xcConfirm.typeEnum.success,{
                    onOk:function () {
                        window.location.href="/user/list";
                    }
                });
            }else{
                window.wxc.xcConfirm("用户名或密码错误!请重新输入...", window.wxc.xcConfirm.typeEnum.warning);
            }
        }

    });
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



