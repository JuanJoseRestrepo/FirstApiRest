class profesorView{

    //Vista de un objeto
    //Acciones de un objeto

    constructor(profesor){
        this.profesor = profesor;
    }

    render = () =>{
      let component = document.createElement('div'); //<di> </div>
      let nombre = document.createElement('p');//<p></p>
      let facultad = document.createElement('small'); //<small></small>
      
      nombre.innerHTML = this.profesor.nombre; //<p> Andres Andrade</p> Va dentro de la etiqueta
      facultad.innerHTML = this.profesor.facultad;//<small>Ingenieria</small>

      component.appendChild(nombre);
      component.appendChild(facultad);
      return component;
    }

}