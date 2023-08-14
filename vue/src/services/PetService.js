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