/**$(function(){
    var $phone = $('#phone');
    $phone.focus(function(){
        $('#phonehelp').show();
        $('#phoneerr').hide();
    });

    $phone.blur(function(){
        $('#phonehelp').hide();
        var phonenum = $("#phone").val();
        if (phonenum.length!=11) {
            $('#phoneerr').show();
        }
    });

    var $psw = $('#psw');
    $psw.focus(function(){
        $('#pswhelp').show();
        $('#pswerr').hide();
    });

    $psw.blur(function(){
        $('#pswhelp').hide();
        var password = $("#psw").val();
        if (password.length<6||password.length>16) {
            $('#pswerr').show();
        }
    });

    var $pswa = $('#pswa');
    $pswa.focus(function(){
        $('#pswahelp').show();
    });

    $pswa.blur(function(){
        $('#pswahelp').hide();
    });
})**/

// 更换验证码
                         $('#captchaImage').click(function()
                         {
                             $('#captchaImage').attr("src", "login/captcha?timestamp=" + (new Date()).valueOf());
                         });