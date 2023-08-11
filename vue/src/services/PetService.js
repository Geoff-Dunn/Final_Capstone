import axios from "axios";

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

    getpets(pet) {
      return http.get('/', pet)
    },
    updatepet(pet) {
        return http.put('/', pet)
    },
    newpet(pet) {
      return http.post('/',pet)
    }
    
  }