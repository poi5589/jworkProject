<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

<title>Insert title here</title>
<style>
    /* outer영역 */
    .leaveOuter{
        padding:50px;
        margin: auto;
    }
   
    /* content영역 */
    .enrollForm{
        margin-top: 30px;
    }
    .header{
        display: flex;
    }
    input[type=text]{
        height:25px;
        width:100px;
        border: 1px solid rgb(170, 170, 170);
        border-radius: 5px;
        text-align: center;
    }
    #textBox{
        resize: none;
        width:690px;
        height:190px;
        border:1px solid rgb(170, 170, 170);
        border-radius: 5px;
        padding:10px;
    }
    #textBox::placeholder{
    	font-size:13px;
    }
    button[type=reset]{
        border:none;
        height:30px;
        width:50px;
        border-radius: 5px;
        color: rgba(50, 50, 50);
        font-size:13px;
    }
    button[type=submit]{
        border:none;
        width:100px;
        height:30px;
       border-radius: 5px;
        font-size:13px;
    }
    .textWrap{
        width:690px;
        text-align: right;
        margin-bottom: 5px;
        font-size: 13px;
        font-weight: 600;
        color:rgb(50,50,50)
    }
    .textWrap div{
        display: inline-block; 
    }
</style>
</head>
<body>

	<jsp:include page = "../common/menubar.jsp" />
    <div class="leaveOuter">
        <h4><b>휴가 > ${ lc.lcName } 등록</b></h4>
       
        <form action="insert.le" method="" class="enrollForm" name="leEnroll" onsubmit="return confirm('휴가신청을 등록하시겠습니까?');">

            <div class="header">
                <%-- <div style="margin-left: 10px; margin-top:15px; color:rgba(50, 50, 50); font-size: 15px; font-weight: 600;">${ lc.lcName }</div> --%>
                <input type="hidden" name="leaveCategory" value="${ lc.lcNo }" >
            </div>
            
            <br>
            
            <div class="body">
                <div style="display: flex;">
                    <img src="resources/images/ess/pencil.png" alt="" style="width:30px; height:30px">
                    <div style="font-size: 13px; font-weight: 600; color:rgb(50,50,50); margin-top:4px; margin-left: 3px;">&nbsp;휴가일정, 필요정보 입력</div>
                    <div style="background:rgb(234, 234, 234); width:610px; height:1px; margin-top:13px; margin-left: 20px;">&nbsp;</div>
                </div>

                <br>

                <div style="display: flex;">
                    <img src="resources/images/ess/mark.png" alt="" style="width:30px; height:30px">
                    <div style="font-size: 13px; font-weight: 600; color:rgb(50,50,50); margin-top:4px; margin-left: 3px;">
                        &nbsp;신청자&nbsp; <input type="text" name="" value="${ e.empName }"> 
                        &nbsp;소속&nbsp; <input type="text" name="" value="${ e.deptName }">
                        <input type="hidden" name="empNo" value="${ e.empNo }">
                        <input type="hidden" name="deptCode" value="${ e.deptCode }">
                        <input type="hidden" name="teamCode" value="${ e.teamCode }">
                        <input type="hidden" name="jobCode" value="${ e.jobCode }">
                    </div>
                    <div style="background:rgb(234, 234, 234); width:460px; height:1px; margin-top:13px; margin-left: 20px;">&nbsp;</div>
                </div>

                <br>

                <div style="display: flex;">
                    <img src="resources/images/ess/clock.png" alt="" style="width:30px; height:30px">
                    <div style="font-size: 13px; font-weight: 600; color:rgb(50,50,50); margin-top:4px; margin-left: 3px;">
                        시작일&nbsp;&nbsp; <input type="text" name="leaveStart" value="" id="datepicker1"> 
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;종료일&nbsp; <input type="text" id="datepicker2" name="leaveEnd" value=""> 
                    </div>
                    <div style="background:rgb(234, 234, 234); width:441px; height:1px; margin-top:13px; margin-left: 20px;">&nbsp;</div>
                </div>
                <input type="hidden" name="annualCount" value="">

                <br><br>
                
                <div class="textWrap">
                    <div class="textCount">&nbsp;&nbsp;0자</div><div class="textTotal">/200자</div>
                </div>
                
                
	            <textarea name="leaveContent" id="textBox" cols="30" rows="10" maxlength="199" placeholder="휴가신청 내용을 입력해주세요."></textarea>
	            <div style="float: right; margin-top:160px;">
	                <button type="reset" class="btn btn-secondary">취소</button>
	                <button type="submit" class="btn btn-success">휴가등록하기</button>
	            </div>
				
            </div>
            
	    </form>

        <!-- datepicker -->
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
        <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
        <script>	
                    
        $(function(){
            var minDate = new Date(); //오늘
            var maxDate = new Date();  // 오늘
            //var dd = maxDate.getDate()+3; // 오늘 + 3
            //maxDate.setDate(dd);
            //console.log(maxDate);
            //var maxDate = maxDate.toISOString().substring(0,10); // yyyy-mm-dd
            //console.log(maxDate); 
           

            $("#datepicker1").datepicker({
                changeMonth: true, 
                changeYear: true,
                minDate: '0',
                nextText: '다음 달',
                prevText: '이전 달',
                yearRange: 'c-50:c+20',
                showButtonPanel: true, 
                currentText: '오늘 날짜',
                closeText: '닫기',
                dateFormat: "yy-mm-dd",
                showAnim: "slide",
                showMonthAfterYear: true, 
                beforeShowDay: function(date){
                    var day = date.getDay();        
                    return [(day != 0 && day != 6)];
                },
                dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
                monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], 
                daysOfWeekDisabled : [0,6],
                autoclose : true,
                onSelect: function(selected){
                    $("#datepicker2").datepicker("option", "minDate", selected);

                    var selected = new Date(selected);

                    if(${lc.lcNo == 0}){
                        var ss = selected.getDate() + ${a.annualCount - 1};
                    }

                    // 휴가카테고리별 사용일수 등록
                    switch(${lc.lcNo}){
                        case 1 : var ss = selected.getDate() + 2; break;
                        case 2 : var ss = selected.getDate() + 89; break;
                        case 3 : var ss = selected.getDate() + 0; break;
                        case 4 : var ss = selected.getDate() + 2; break;
                        case 5 : var ss = selected.getDate() + 89; break;
                        case 6 : var ss = selected.getDate() + 4; break;
                        case 7 : var ss = selected.getDate() + 119; break;
                        case 8 : var ss = selected.getDate() + 0; break;
                    }
                    
                    maxDate.setDate(ss);
                    //console.log(maxDate);
                    $("#datepicker2").datepicker("option", "maxDate", maxDate);
                    
                }

            });	

           $("#datepicker2").datepicker({
                changeMonth: true, 
                changeYear: true,
                minDate: '0',
                nextText: '다음 달',
                prevText: '이전 달',
                yearRange: 'c-50:c+20',
                showButtonPanel: true, 
                currentText: '오늘 날짜',
                closeText: '닫기',
                dateFormat: "yy-mm-dd",
                showAnim: "slide",
                showMonthAfterYear: true, 
                beforeShowDay: function(date){
                    var day = date.getDay();        
                    return [(day != 0 && day != 6)];
                },
                dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
                monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
            });	

            
            
            
            
            
        });
        
        </script>   

        <!-- 에러 해결 시작 - 홈짱 -->

        <script>

            jQuery.browser = {};
            
            (function () {
            
                jQuery.browser.msie = false;
            
                jQuery.browser.version = 0;
            
                if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
            
                    jQuery.browser.msie = true;
            
                    jQuery.browser.version = RegExp.$1;
            
                }
            
            })();
            
            </script>
            
            <!-- 에러 해결 종료 - 홈짱 -->

        <script>
            $(function(){
                $("#textBox").keyup(function(e){
                    let content = $(this).val();

                    if(content == 0 || content == ""){
                        $(".textCount").text('0자');
                    }else{
                        $('.textCount').text(content.length + '자');
                    }

                    if(content.length > 200){
                        $(this).val($(this).val().substring(0, 200));

                        alert("글자수는 200자까지 입력 가능합니다.");
                    };
                });
            })
        </script>

        <script>
            $(function(){
                const getDateDiff = (d1, d2) => {
                const date1 = new Date(d1);
                const date2 = new Date(d2);
                
                const diffDate = date1.getTime() - date2.getTime();
                
                return Math.abs(diffDate / (1000 * 60 * 60 * 24)); // 밀리세컨 * 초 * 분 * 시 = 일
                }

                getDateDiff("${e}", "2021-10-01");
                // 30
            })
        </script>
        
        


    </div>
</body>
</html>