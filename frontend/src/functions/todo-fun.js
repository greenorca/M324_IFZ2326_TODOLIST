const url = "http://localhost:8080/task";

function postNewTodo(taskdescription){
  fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ taskdescription: taskdescription }) // both 'taskdescription' are identical to Task-Class attribute in Spring
  })
  .then(response => {
    console.log("Receiving answer after sending to Spring-Server: ");
    console.log(response);
    window.location.href = "/";
  })
}

function deleteTodo(id){
  fetch(`${url}/${id}`, { // API endpoint (the complete URL!) to delete an existing taskdescription in the list
    method: "DELETE",
    headers: {
      "Content-Type": "application/json"
    }
  })
  .then(response => {
    console.log("Receiving answer after deleting on Spring-Server: ");
    console.log(response);
    window.location.href = "/";
  })
}

function fetchTodos(){
  return fetch(url)
  .then(response => {
      if (!response.ok) throw Error(response.statusText);
      else return response.json()
    })
      //no catch here!
}

export default function todoFun(){
  return {
    postNewTodo,
    deleteTodo,
    fetchTodos
  }
}