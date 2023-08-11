import axios from "axios";

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

    volunteerSubmission(user) {
      return http.post('/volunteer', user)
    },

    getVolunteers(){
      return http.get(`/volunteer`)
    },

  }