import { AxiosInstance, default as Axios } from 'axios';

const BASE_URL: string = process.env.VUE_APP_API + '/app/rest/api/';

export class HttpCommon {
  get axios(): AxiosInstance {
    const token = localStorage.getItem('user-token');
    if (token) {
      return Axios.create({
        baseURL: BASE_URL,
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
    } else {
      return Axios.create({
        baseURL: BASE_URL
      });
    }
  }
}
