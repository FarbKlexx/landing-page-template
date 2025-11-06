import api from "./axios";
import type { User } from "../types/User";

export const userService = {

  async signup(user: User): Promise<User> {
    const response = await api.post<User>("/signup", user);
    return response.data;
  },

  async getAll(): Promise<User[]> {
    const response = await api.get<User[]>("/signup");
    return response.data;
  },
};
