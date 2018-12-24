import { AxiosInstance, default as Axios } from 'axios';
import Cookies from 'js-cookie';

const BASE_URL: string = process.env.VUE_APP_API + '/app/rest/api/';

export class HttpCommon {
  get axios(): AxiosInstance {
    const accessToken = Cookies.getJSON('access_token');
    if (accessToken) {
      return Axios.create({
        baseURL: BASE_URL,
        headers: {
          Authorization: `Bearer ${accessToken}`
        }
      });
    } else {
      return Axios.create({
        baseURL: BASE_URL
      });
    }
  }
}
