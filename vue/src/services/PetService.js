import axios from "axios";

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getPess() {
    return http.get('/');
  },

  getPets(pet) {
    return http.get(`/`, pet)
  },

  getPet(petID) {
    return http.get(`/pets/${petID}`)
  },

  addPet(pet) {
    return http.post('/pets', pet);
  },

  updatePet(pet) {
    return http.put(`/Pets/${pet.id}`, pet);
  },

  deletePet(petID) {
    return http.delete(`/pets/${petID}`);
  },

  addspecies(species) { 
    return http.post('/Species', species);
  },

  deletespecies(speciesID) {
    return http.delete(`/Species/${speciesID}`);
  }

    
  }