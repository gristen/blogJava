<?php
session_start();
?>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

    <!-- Custom Styling -->
    <link rel="stylesheet" href="../../assets/css/admin.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <title>My blog</title>
</head>
<body>

<?php include("../../app/include/header-admin.php"); ?>

<div class="container">
    <?php include "../../app/include/sidebar-admin.php"; ?>

        <div class="posts col-9">
            <div class="button row">
                <a href="create.php" class="col-2 btn btn-success">Создать</a>
                <span class="col-1"></span>
                <a href="" class="col-3 btn btn-warning">Редактировать</a>
            </div>
<!--            <div class="row title-table">-->
<!--                <h2>Управление категориями</h2>-->
<!--                <div class="col-1">ID</div>-->
<!--                <div class="col-5">Название</div>-->
<!--                <div class="col-4">Управление</div>-->
<!--            </div>-->

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">name</th>
                    <th scope="col">Редактирование</th>

                </tr>
                </thead>
                <tbody id="table" >


                </tbody>
            </table>

      
        </div>
    </div>
</div>



<script>



$(document).ready(function (){
    Load();
    function Load(){
        $.ajax({
            method: "POST",
            url: "../../app/controllers/topic.php",
            data: {
                action: "loadTop"
            }
        })
            .done(function( msg )
            {
                var html = msg;
                $('#table').html(html);
            });
        setTimeout(Load, 500);

    }


});
function deleteTopics(id,event){

    $.ajax({
        method: "POST",
        url: "../../app/controllers/topic.php",
        data: {
            deleteID:id,
            action: "DeleteTopics"
        }
    })
        .done(function(  )
        {
            // window.location.href = 'index.php';

        });

}






</script>








<!--<script>-->
<!--    $(document).ready(function (){-->
<!--     LoadTop();-->
<!---->
<!--        function LoadTop() {-->
<!--            $.ajax({-->
<!--                method: "POST",-->
<!--                url: "../../app/controllers/topic.php",-->
<!--                data:-->
<!--                    {   test:"test",-->
<!--                        action:loadTopic,-->
<!--                    }-->
<!--            })-->
<!--                .done(function( msg ) {-->
<!--                   console.log(msg);-->
<!--                    // $('#table').html(msg);-->
<!--                });-->
<!--        }-->
<!---->
<!--    });-->
<!--</script>-->


<!-- footer -->

<!-- // footer -->


<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
-->
</body>
</html>
