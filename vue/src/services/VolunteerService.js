import axios from "axios";

const http = axios.create({
  baseURL: "http://localhost:8080"
});


export default {

    volunteerSubmission(user) {
      return http.post('/volunteer', user)
    },

  
  }