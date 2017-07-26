$("#next").on('click', function() {
    var phoneNum = $("#phoneNum").val();
    var captcha = $("#captcha").val();
    if(phoneNum == '' || phoneNum == null){
        window.wxc.xcConfirm("手机号码不能为空!", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }

    if(phoneNum.length != 11){
        window.wxc.xcConfirm("手机号码长度必须为11位!", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }

    if(captcha == '' || captcha == null){
        window.wxc.xcConfirm("验证码不能为空!", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }

    window.location='/pswfinder/setsct';
});

$("#next2").on("click",function(){
    var psw1 = $("#psw1").val();
    var psw2 = $("#psw2").val();
    if(psw1 == '' || psw1 == null){
        window.wxc.xcConfirm("初始密码不能为空!", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }
    if(psw1 != psw2){
        window.wxc.xcConfirm("两次密码输入不一致!请重新输入", window.wxc.xcConfirm.typeEnum.warning);
        return false;
    }
   window.location='/pswfinder/done';
});
