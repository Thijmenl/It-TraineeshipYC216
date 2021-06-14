async function fetchFacts() {
    const theDom = document.getElementsByTagName("html");
    console.log(theDom);
    theDom[0].children[1].children[1].style.backgroundColor = "red";
    const catFacts = document.getElementById("cat-data");
  
    const response = await fetch(
        `https://cat-fact.herokuapp.com/facts/random`
     );
      const data = await response.json();
      console.log(data);
      
      const catText = data.text;
      const textElement = document.createElement("h1");
      textElement.innerText = catText;
      catFacts.appendChild(textElement);
  }
  
  const result = fetchFacts();