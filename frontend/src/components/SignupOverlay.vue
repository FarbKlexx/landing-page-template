<script setup lang="ts">
import { ref } from "vue";
import { userService } from "@/api/userService";
import type { User } from "@/types/User";

const emit = defineEmits(["close"]);

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

    // Formular zurücksetzen
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
  <div class="overlay" @click.self="emit('close')">
    <div class="overlay-content">
      <button class="close-btn" @click="emit('close')">×</button>

      <form @submit.prevent="handleSubmit" class="signup-form">
        <h2>Anmeldung</h2>

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
    </div>
  </div>
</template>

<style scoped>
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.6);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
}

.overlay-content {
  background: white;
  padding: 2rem;
  border-radius: 12px;
  width: 90%;
  max-width: 500px;
  position: relative;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.25);
}

.close-btn {
  position: absolute;
  top: 0.5rem;
  right: 0.75rem;
  font-size: 1.5rem;
  border: none;
  background: none;
  cursor: pointer;
}

.signup-form {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}
</style>
