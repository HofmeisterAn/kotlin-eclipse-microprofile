import axios from 'axios';

export const HttpCommon = axios.create({
  baseURL: process.env.VUE_APP_API + '/app/rest/api/',
  headers: {
    Authorization: 'Bearer {token}'
  }
});
