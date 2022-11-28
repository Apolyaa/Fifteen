window.onload = function() {
    let time = document.getElementById("time");
    let clicks = document.getElementById("clicks");

    time.innerText = localStorage.getItem('time');
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

    // 1. Создаём новый XMLHttpRequest-объект
    let xhr = new XMLHttpRequest();

    xhr.open('POST', './saveGameData');
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

    xhr.onload = reqListener;

    let json = JSON.stringify({
        date: new Date(),
        userName: 'userName',
        time: localStorage.getItem('time'),
        clicks: localStorage.getItem('clicks'),
    });

    xhr.send(json);

    return false;
}