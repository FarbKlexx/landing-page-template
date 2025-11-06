<script setup lang="ts">
import { ref } from "vue";
import { userService } from "@/api/userService";
import type { User } from "@/types/User";

const user = ref<User>({
  name: "",
  email: "",
  phone: "",
  street: "",
  houseNumber: "",
  postalCode: "",
  message: "",
});

const isSubmitting = ref(false);
const success = ref(false);
const error = ref("");

async function handleSubmit() {
  try {
    isSubmitting.value = true;
    success.value = false;
    error.value = "";

    await userService.signup(user.value);

    success.value = true;

    user.value = {
      name: "",
      email: "",
      phone: "",
      street: "",
      houseNumber: "",
      postalCode: "",
      message: "",
    };
  } catch (err: any) {
    error.value = err.message || "Fehler beim Absenden.";
  } finally {
    isSubmitting.value = false;
  }
}
</script>

<template>
  <form @submit.prevent="handleSubmit" class="signup-form">
    <input v-model="user.name" placeholder="Name" required />
    <input v-model="user.email" placeholder="E-Mail" required type="email" />
    <input v-model="user.phone" placeholder="Telefon" />

    <input v-model="user.street" placeholder="Straße" />
    <input v-model="user.houseNumber" placeholder="Hausnummer" />
    <input v-model="user.postalCode" placeholder="Postleitzahl" />

    <textarea v-model="user.message" placeholder="Nachricht"></textarea>

    <button type="submit" :disabled="isSubmitting">Anmelden</button>

    <p v-if="success" style="color:green">Danke für deine Anmeldung!</p>
    <p v-if="error" style="color:red">{{ error }}</p>
  </form>
</template>

<style scoped>
.signup-form {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
  max-width: 400px;
}
</style>
