import axios from "axios"

const getAPI = axios.create({

    baseURL: 'http://localhost:8080/',
    timeout: 2000,
})

export { getAPI }