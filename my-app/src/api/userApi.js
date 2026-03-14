import axiosClient from "./axiosClient";

export const getUsers = () => {
  return axiosClient.get("/login", data);
};

export const createUser = (data) => {
  return axiosClient.post("/users", data);
};