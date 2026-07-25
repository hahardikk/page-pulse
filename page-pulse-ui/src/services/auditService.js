import axios from "axios";

const API_URL = "http://localhost:2030/api/audit/post";

export const auditWebsite = async (url) => {
  const response = await axios.post(API_URL, {
    url,
  });

  return response.data;
};
