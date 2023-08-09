import axios from "axios";

export default {

    volunteer(user) {
      return axios.post('/volunteersignup', user)
    },

  
  }