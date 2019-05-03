$(document).ready(function(){

    var span = true;

    var myVar = setInterval(myTimer, 4000);

    function myTimer() {
        document.getElementById("snap").src = "../img/thanos_idle.png"
    }

    $("#snap").click(function(){
        var arr = [1 ,3 , 23 ,5, 9 ,19 ,4 ,18 ,15 ,10];
        var i = 0;
        if (span) {
            document.getElementById("snap").src = "../img/thanos_snap.gif";
            while (i < arr.length) {
                let m = arr[i] + "-movie";
                console.log(m);
                let parent = document.getElementById(m).parentElement;
                $(parent).fadeTo(7000, 0.01);
                i++;
            }
            span = false;
        } else  {
            document.getElementById("snap").src = "../img/thanos_time.gif";
            while (i < arr.length) {
                let m = arr[i] + "-movie";
                console.log(m);
                let parent = document.getElementById(m).parentElement;
                console.log(parent);
                $(parent).fadeTo(7000, 1);
                i++;
            }
            span = true;
        }
    });
});