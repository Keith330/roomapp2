/**
 * Created by Fenway Group on 12/19/2017.
 */
var day_value;
var time_value;
var room_value;

function DisplayTimes() {
    elmnt.style.color = clr;
}
function toggleTable() {

    if (document.getElementById("loginTable").style.display == "table") {
        document.getElementById("loginTable").style.display = "none";

    } else {
        document.getElementById("loginTable").style.display = "table";

    }
}
// function slideTable() {
//     $("#loginTable").fadeToggle("slow");
// }

// $(document).ready(function () {
//     $(".Date").click(function () {
//         $("#LoginTable").slideToggle("slow");
//     });
// });
$(document).ready(function(){
    $("#enter_Button").click(function(){
        $("#display").fadeIn("slow");
        document.getElementById("display").innerHTML = displayValue();
    });
});

$(document).ready(function(){
    $("#dayTable").click(function(){
        $("#newTable").fadeToggle("slow");
    });
});

function displayValue() {
    day_value = $('#days').val();
    time_value = $('#times').val();
    room_value = $('#rooms').val();
    if (day_value == null || time_value == null || room_value == null) {
        alert("You must pick a day, time, and room");
        return "Please try again"
    }
    else {
        return "You have selected " + day_value + " from " + time_value + " in room " + room_value;
    }

}


