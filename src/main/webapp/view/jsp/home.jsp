<!DOCTYPE html>
<html>
   <head>
      <meta charset = "ISO-8859-1">
      <title>Home Page</title>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <link rel="stylesheet" href="/css/main.css">
   </head>
   <body>
      <h1 div class="hello-title">Hello ${userDetails.name}! Bring your concerns over here</h1>

      <label for="helpline">Type anything regarding school bullying/sexual harassment/office/family related stress etc.:</label>
      <br>
      <!--<textarea id="helpline" rows="8" cols="100">
      </textarea>-->

      <form action="#" th:action="@{/user}" th:object="${user}" method="post">
          <p>
              Name: <textarea id="helpline" rows="8" cols="100" th:field="*{message}"> </textarea>
          </p>
          <p>
              <input type="submit" value="Submit"/> <input type="reset" value="Reset">
          </p>
      </form>

      <script type="text/javascript">


            //window.onload = function(){
            //    var t = document.getElementsByTagName("textarea");
            //    for(var i=0, len=t.length; i<len; i++){
            //        t[i].select();
            //    }
            //}

            </script>
   </body>
</html>