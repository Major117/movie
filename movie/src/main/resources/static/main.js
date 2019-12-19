var liste = [];
var about;
var id;
var finalUrlId = "";

//-----------------------------------------------------------------------------------------------------------------

/**
 * appelle le endpoint avec la liste de film et prend en charge la function chargerMovieList() et displayList()
 */
    $.ajax({
        url: "http://localhost:8080/movie/all"
    }).then(function (data) {
        liste = data;

        chargerMovieList();
        displayList();
    });


    /**
     * appelle le endpoint avec un String et prend en charge la function writeAbout()
     */
  $.ajax({
      url: "http://localhost:8080/movie/about"
  }).then(function (text) {
      about = text;

      writeAbout();
  });

 
/**
 * enregiste l'id écris par l'utilisateur une fois qu'il taper sur la touche "Enter" et charge la function displayMovieById()
 */
 $('#insert-id').keyup('input', function (e) {
    
  if (e.keyCode === 13) {
    id = $("#insert-id").val();
    finalUrlId = "http://localhost:8080/movie/id?id=" + id;

    displayMovieById();
  };
});



  /**
   * créer un Objet film et le renvoie.
   */
  $('#submit').click(function (event) {
  
    let url = "http://localhost:8080/movie/add?title="+
        $('#add-title').val()+"&director="+
        $('#add-director').val()+"&years="+
        $('#add-years').val();
      
   $.post(url);
               
  });


//-------------------------------------------------------------------------------------------------------------------------------------


/**
 * affiche les titres des films dans un button.
 */
function chargerMovieList() {
  liste.forEach(function (movie) {
    let myDropListItem = document.createElement("button");
    myDropListItem.className = "dropdown-item";
    myDropListItem.type = "button"; 
    myDropListItem.textContent = movie.title;
    
    myDropListItem.addEventListener('click' ,function (event) {
      chargerMovie(movie);
    });
    
    document.getElementById("menu-movie").appendChild(myDropListItem);
  });
}


/**
 * affiche un film dans un tableau 
 * @param {*} movie 
 */
function chargerMovie(movie) {
  
  let cardsTitle = document.createElement('h5');
    cardsTitle.className = "card-title";
    cardsTitle.innerText = movie.title +  " | " + movie.director + " | " + movie.years;

    document.getElementById("titre").appendChild(cardsTitle);
  }



/**
 * affiche la description de mon projet dans un paragraphe 
 */
  function writeAbout() {
    
    let paragraph = document.createElement("p");
    paragraph.className = "lead";
    paragraph.textContent = about;
    document.getElementById("aboutDiv").appendChild(paragraph);
    
  }
  

/**  appelle le endpoint recherche par l'id.  et
 * affiche dans un tableaux la liste des films avec ses caractéristiques, trouvé grâce a l'id et renvoie une erreur si l'id n'existe pas.
 */
function displayMovieById(){

  $.ajax({
    url: finalUrlId
  
  }).then(function (data) {

    var trRow = document.createElement("tr");
    
    var idById = document.createElement("th");
    idById.scope = "row";
    idById.textContent = data.id ;
    trRow.appendChild(idById); 
    
    var tilteById = document.createElement("td");
    tilteById.textContent = data.title;
    trRow.appendChild(tilteById);
    
    var directorById = document.createElement("td");
    directorById.textContent = data.director;
    trRow.appendChild(directorById);
    
    var yearsById = document.createElement("td");
    yearsById.textContent = data.years;
    trRow.appendChild(yearsById);

    document.getElementById("bodyById").appendChild(trRow); 
    
  }).fail(error404);
}


  /**
   * affiche toutes la liste des films avec ses caractéristique dans un tableau.
   */
  function displayList() {
    liste.forEach(function (movie) {

    var trRowList = document.createElement("tr");
        
        var allId = document.createElement("th");
        allId.scope = "row";
        allId.textContent = movie.id ;
        trRowList.appendChild(allId); 
        
        var allTitle = document.createElement("td");
        allTitle.textContent = movie.title;
        trRowList.appendChild(allTitle);
        
        var dallDirector = document.createElement("td");
        dallDirector.textContent = movie.director;
        trRowList.appendChild(dallDirector);
        
        var allYears = document.createElement("td");
        allYears.textContent = movie.years;
        trRowList.appendChild(allYears);
  
        document.getElementById("bodyByMovie").appendChild(trRowList);
      });
  }

 /**
  * renvoie une page html quand une erreur et interceptée.
  */ 
function error404 () {
  document.location.href = "error404.html";
}


