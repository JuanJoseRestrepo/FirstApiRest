//Declaraciones (Referencias)
const nombre = document.getElementById('nombre');
const facultad = document.getElementById('facultad');
const regis = document.getElementById('regis');
const profesoresContainer = document.getElementById('profesoresContainer');

const registrar = () =>{
    let profeObj = {
        id:0,
        nombre: nombre.value,
        facultad: facultad.value
    };
    console.log(JSON.stringify(profeObj));

    //POST
    let xhr = new XMLHttpRequest();
    //Response
    xhr.addEventListener('readystatechange', () =>{ 
        if(xhr.readyState === 4){
            console.log(xhr.responseText);
        }
       
    });

    xhr.open('POST','http://localhost:8080/FirstApiRest/api/profesores/create');
    xhr.setRequestHeader('Content-Type','application/json');
    xhr.send(JSON.stringify(profeObj));
};

regis.addEventListener('click',registrar);

const getAllProfesores = () =>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', () =>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);

            for(let i = 0; i < response.length ;i++){
                let profesorDTO = response[i];
                let view = new profesorView(profesorDTO);
                profesoresContainer.appendChild(view.render() ); 
            }

        }
    });

    xhr.open('GET','http://localhost:8080/FirstApiRest/api/profesores/all');
    xhr.send();
};

getAllProfesores();