import axios from 'axios';

const axiosInstance = axios.create({
   //baseURL: 'http://localhost:8081/api'     //dev
   baseURL: '/api'   //prod
});

export default axiosInstance;