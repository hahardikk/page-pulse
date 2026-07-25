import axios from "axios";


const API_URL = import.meta.env.VITE_API_URL;

export const auditWebsite = async (url) => {
  const response = await axios.post(API_URL, {
    url,
  });

  return response.data;
};
