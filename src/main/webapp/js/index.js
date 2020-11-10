const downBtn = document.getElementById('downBtn');

const descargar = () =>{
    let url = '';
    let xhr = new XMLHttpRequest();

    xhr.addEventListener('readystatechange', () =>{

        if(xhr.readyState === 4){
            console.log(xhr.responseText);
        }

    });

    xhr.open('GET',url);
    xhr.send();
    
}