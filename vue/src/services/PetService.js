import axios from "axios";

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getPets() {
    return http.get('/');
  },

  getPetsBySpecies(species) {
    return http.get(`/`, species)
  },

  getPet(petID) {
    return http.get(`/pets/${petID}`)
  },

  addPet(pet) {
    return http.post('/', pet);
  },

  updatePet(updatedpet) {
    return axios.put('/',updatedpet);
  },

  deletePet(petID) {
    return http.delete('/', petID);
  },

  addspecies(species) { 
    return http.post('/Species', species);
  },

  deletespecies(petID) {
    return http.delete('/',petID);
  }

    
  }