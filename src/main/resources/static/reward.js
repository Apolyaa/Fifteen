function msToTime(duration) {
    var seconds = Math.floor((duration / 1000) % 60),
        minutes = Math.floor((duration / (1000 * 60)) % 60),
        hours = Math.floor((duration / (1000 * 60 * 60)) % 24);

    hours = (hours < 10) ? "0" + hours : hours;
    minutes = (minutes < 10) ? "0" + minutes : minutes;
    seconds = (seconds < 10) ? "0" + seconds : seconds;

    return hours + ":" + minutes + ":" + seconds;
}

window.onload = function() {
    let time = document.getElementById("time");
    let clicks = document.getElementById("clicks");

    time.innerText = msToTime(localStorage.getItem('time'));
    clicks.innerText = localStorage.getItem('clicks');

}

function reqListener () {

    if (this.status != 200) {
        alert(`Ошибка ${this.status}: ${this.statusText}`);
    } else {
        window.location.href = "./";
    }
}

function saveData(e) {
    let user = document.getElementById("username").value;


    if (user == '')
        user = 'Unknown';

    // 1. Создаём новый XMLHttpRequest-объект
    let xhr = new XMLHttpRequest();

    xhr.open('POST', './saveGameData');
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

    xhr.onload = reqListener;

    let json = JSON.stringify({
        date: new Date(),
        userName: user,
        time: localStorage.getItem('time'),
        clicks: localStorage.getItem('clicks'),
    });

    xhr.send(json);

    return false;
}