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
      <textarea id="helpline" rows="8" cols="100" form="helplineForm" name="textForm"></textarea>

      <form action="#" th:action="@{/user}" method="post" id="helplineForm">
          <p>
              <input type="submit" class="button" value="Submit"/>
              <input type="reset" value="Reset" class="button">
          </p>
      </form>
      <a href="logout">
        <button class="button">Logout</button>
      </a>
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