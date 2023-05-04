# jworkProject
 
***

# Contents <br>
1. [개요](#star-개요)  
2. [팀 소개 및 주요 기능](#star-팀-소개-및-주요-기능)
3. [구현 기능](#star-구현-기능)
    - [휴가신청 홈](#pushpin-휴가신청-홈)
    - [메일 상세,답장](#pushpin-메일-상세_답장)
    - [중요 메일](#pushpin-중요-메일)
    - [다중체크_읽음_안읽음](#pushpin-다중체크_읽음_안읽음)
    - [메일함 생성_수정 및 삭제](#pushpin-메일함-생성_수정-및-삭제)
    - [메일 영구 삭제](#pushpin-메일-영구-삭제)
    - [메일 전송](#pushpin-메일-전송)
    - [수신확인 및 발송취소](#pushpin-수신확인-및-발송취소)
    - [메일 임시저장](#pushpin-메일-임시저장)
    - [실시간알림](#pushpin-실시간알림)
    - [삭제_취소된 이벤트에 대한 알림](#pushpin-삭제_취소된-이벤트에-대한-알림)
    - [결재 관련 알림_알림 삭제](#pushpin-결재-관련-알림_알림-삭제)

4. [Document](#star-document)

***

# :star: 개요
- 프로젝트명 : JWORK Project <br>

- 보고서 : [JWORK_최종보고서.pdf](https://github.com/yullmm0531/jworkProject/files/11084920/JWORK.pdf)<br>

- 기획 의도  <br>
  - 프로그램 설치 없이도 웹으로 이용 가능한 가벼운 그룹웨어의 필요성 <br>
  - 사용하기 어렵지 않은 직관적인 그룹웨어의 필요성 <br>

- 개발 환경 <br><br>
![jwork언어](https://user-images.githubusercontent.com/115603858/228114365-bc741d26-2937-4a26-ad3f-a474b58fab6c.png)<br>

***

# :star: 팀 소개 및 주요 기능
<img width="800" alt="기능" src="https://user-images.githubusercontent.com/115603858/228117398-7b3876ca-fb80-4d27-a7dd-c3539ce2d7d8.png">
<img width="600" alt="기능2" src="https://user-images.githubusercontent.com/115603858/228117415-09f12f11-a8db-4c1a-a609-f8236064d602.png">

***
# :star: 구현 기능
 

### :pushpin: 휴가신청 홈
![1 메일메인](https://user-images.githubusercontent.com/115603858/229416784-2c94a076-631a-4b4f-af33-921ecb078a4e.gif)
- 구현 기능 설명
   - 받은 메일함 조회(안읽은 메일은 굵게 표시)
   - 안읽은 메일함, 보낸 메일함, 임시 보관함, 중요 메일함, 휴지통 조회
<br>

<br>
📍 메일 리스트 조회하는 sql문
<img width="581" alt="메일리스트sql_1" src="https://user-images.githubusercontent.com/115603858/229417061-724bc45b-b1e3-4ddd-a4f5-3bf6d5b45268.png">
<img width="522" alt="메일리스트sql_2" src="https://user-images.githubusercontent.com/115603858/229417073-372ec700-67e9-42a2-8b94-568c74fc4a3a.png">
<br>
<img width="422" alt="메일resultMap" src="https://user-images.githubusercontent.com/115603858/229417256-ebc79f22-e6e0-4185-9bb4-85b7649fd8f9.png">

<br><br>


### :pushpin: 메일 상세_답장
![2 메일상세,답장](https://user-images.githubusercontent.com/115603858/229417461-0c9350b3-5a11-4a2c-a944-9037b5044936.gif)
- 구현 기능 설명
   - 메일 리스트에서 눌러 상세페이지 조회 가능
   - 읽은 메일은 얇게 표시되고 아이콘 변경
   - 메일 상세페이지에서 답장을 눌러 발신자에게 바로 메일 작성 가능
<br><br>


### :pushpin: 중요 메일
![3  중요메일](https://user-images.githubusercontent.com/115603858/229418068-65e182d9-d9c0-4008-9b9a-cad9792349fc.gif)
- 구현 기능 설명
   - ajax 를 사용하여 메일 리스트에서 바로 중요메일 체크 및 해제 기능 구현
   - 중요메일 리스트에서 확인 가능
<br><br>


### :pushpin: 다중체크_읽음_안읽음
![4 다중체크읽음_안읽음](https://user-images.githubusercontent.com/115603858/229418365-5939b724-6da4-4e59-b665-03b5bb90d111.gif)
- 구현 기능 설명
   - 메일 목록에서 다중 체크하여 ajax로 읽음/안읽음 처리 기능 구현
   - 읽은 메일들만 선택하는 경우에는 읽음 버튼이 안읽음 버튼으로 바뀌고 안읽음 기능 구현
<br><br>


### :pushpin: 메일함 생성_수정 및 삭제
![5 메일함생성및이동삭제](https://user-images.githubusercontent.com/115603858/229418785-2994059a-cd33-46b4-9112-6418b1107ea9.gif)
- 구현 기능 설명
   - 사용자 메일함 추가 , 수정 기능 구현
   - 메일들을 다중선택하여 사용자 메일함으로 이동 기능 구현
   - 메일함 삭제시 해당 메일함의 메일들은 휴지통으로 이동
<br><br>


### :pushpin: 메일 영구 삭제
![6 메일영구삭제](https://user-images.githubusercontent.com/115603858/229418968-d8eedd0b-6fb2-484c-80eb-50f8872b5fc3.gif)
- 구현 기능 설명
   - 휴지통에서 메일 영구 삭제 기능 구현
<br><br>


### :pushpin: 메일 전송
![7 메일전송](https://user-images.githubusercontent.com/115603858/229419186-26f464dd-9979-4744-9f2d-ebcf35d8b9f3.gif)
- 구현 기능 설명
   - 메일 전송하기
   - 사번을 입력하여 확인 후 display(없으면 없는 사원 알람)
   - 주소록에서 선택하여 수신자 추가 가능
   - 파일첨부 최대 다섯개 제한
   - 메일 제목 없을 시 확인 후 전송
<br><br>


### :pushpin: 수신확인 및 발송취소
![8 개별수신확인,발송취소](https://user-images.githubusercontent.com/115603858/229419367-1b28bbb6-daab-4a50-a90a-192fa830abb8.gif)
- 구현 기능 설명
   - 보낸 메일함에서 개별 수신 확인 가능
   - 읽지 않은 메일의 경우 발송취소 가능
   - 발송취소된 메일은 수신자가 확인 불가능
<br><br>


### :pushpin: 메일 임시저장
![9 임시저장](https://user-images.githubusercontent.com/115603858/229419604-72471b2c-a79b-49d1-986e-da7f67814f78.gif)
- 구현 기능 설명
   - 메일 작성하기 페이지에서 임시저장 가능
   - 임시저장함에서 클릭 시 저장한 정보들 조회 가능
   - 다시 임시 저장 가능, 전송 가능
<br><br>


### :pushpin: 실시간알림
![10 실시간알림](https://user-images.githubusercontent.com/115603858/229419859-38dd077f-4891-4078-b563-f0759ae8254c.gif)
- 구현 기능 설명
   - 메일 전송 시 수신자에게 실시간 알람 전송
   - 읽은 알람은 흰색, 안읽은 알람은 노란색으로 표시
<br>

📍 메일 전송시 알림 보내는 구문
<img width="692" alt="image" src="https://user-images.githubusercontent.com/115603858/229423399-9664aae0-10bc-4e80-a826-8e56e326c49c.png">
<br>

📍 실시간 알림 전송하는 템플릿
<img width="897" alt="image" src="https://user-images.githubusercontent.com/115603858/229423025-e792a620-1be4-44ba-b129-14410848ff59.png">

<br><br>


### :pushpin: 삭제_취소된 이벤트에 대한 알림
![11 삭제한메일알람](https://user-images.githubusercontent.com/115603858/229419960-d5d38136-cf65-4222-8f9d-30afa8f9d255.gif)
- 구현 기능 설명
   - 삭제하거나 발송취소된 메일에 대한 알람의 경우 메세지 안내 후 메인으로 이동
   - 상신취소한 결재건에 대한 알람도 동일
<br><br>


### :pushpin: 결재 관련 알림_알림 삭제
![12 결재관련알람,알람삭제](https://user-images.githubusercontent.com/115603858/229420126-785619ab-9b8e-4350-bcf9-4065df037665.gif)
- 구현 기능 설명
   - 결재 기안시 다음 결재자에게 알람 전송
   - 최종 승인 시 기안자에게 전송
   - 상신취소된 결재의 경우 메세지 안내 후 메인으로 이동
   - 알람 전체 삭제 기능
<br>

📍 결재관련 알림 전송
<img width="630" alt="image" src="https://user-images.githubusercontent.com/115603858/229422230-75fa2739-8094-4bc2-a9f8-c48facb44807.png">
<br>

📍 상신취소된 결재 알림창에서 클릭 시
<img width="736" alt="image" src="https://user-images.githubusercontent.com/115603858/229421694-6ce236d6-91d5-4d6b-a08b-ce890ca18b27.png">

<br><br>



***
# :star: Document

## 개발 일정 <br>
![jwork개발일정](https://user-images.githubusercontent.com/115603858/228113850-4237a227-2227-4047-893d-00d9c2d383ca.png)

<br>

## 유스케이스 <br>
<img width="450" alt="사용자-공통" src="https://user-images.githubusercontent.com/115603858/228113354-c6f0fd08-0e98-41ce-9467-9a950cf03187.png"><img width="450" alt="사용자-인사팀" src="https://user-images.githubusercontent.com/115603858/228113563-62401b47-d769-46eb-b8ae-67720d592f70.png"><img width="450" alt="사용자-개발팀" src="https://user-images.githubusercontent.com/115603858/228113613-a6c86c97-f5eb-43ab-8a19-faa241527f62.png"><img width="450" alt="사용자-총무팀" src="https://user-images.githubusercontent.com/115603858/228113596-554ac0f0-b838-4573-aa40-13cf35722dba.png">


<br>

## DB 설계 <br>
![J-WORK_FINAL](https://user-images.githubusercontent.com/115603858/228119872-42deef14-7c7c-4917-8c45-efff47875d16.png)

<br>

