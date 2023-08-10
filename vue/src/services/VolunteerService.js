import axios from "axios";

export default {

    volunteerSubmission(user) {
      return axios.post('/volunteer', user)
    },

  
  }