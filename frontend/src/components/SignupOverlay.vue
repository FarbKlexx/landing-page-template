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

const rules = {
  required: (v: string) => !!v || "Dieses Feld ist erforderlich.",
  email: (v: string) =>
    !v || /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(v) || "Bitte eine gültige E-Mail-Adresse eingeben.",
  postalCode: (v: string) =>
    !v || /^[0-9]{4,5}$/.test(v) || "Bitte eine gültige Postleitzahl eingeben.",
  phone: (v: string) =>
    !v || /^[0-9+\-\s()]{6,20}$/.test(v) || "Bitte eine gültige Telefonnummer eingeben.",
  maxLength: (max: number) => (v: string) =>
    !v || v.length <= max || `Maximal ${max} Zeichen erlaubt.`,
};

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

      <v-container fluid>
        <h2>Anmeldung</h2>
      </v-container>
      <v-form @submit.prevent="handleSubmit" class="signup-form">

        <v-text-field
          v-model="user.name"
          label="Name"
          variant="outlined"
          :rules="[rules.required, rules.maxLength(50)]"
          required
        />

        <v-text-field
          v-model="user.email"
          label="E-Mail"
          type="email"
          variant="outlined"
          :rules="[rules.required, rules.email]"
          required
        />

        <v-text-field
          v-model="user.phone"
          label="Telefon"
          variant="outlined"
          :rules="[rules.phone]"
        />

        <v-text-field
          v-model="user.street"
          label="Straße"
          variant="outlined"
          :rules="[rules.maxLength(100)]"
        />

        <v-text-field
          v-model="user.houseNumber"
          label="Hausnummer"
          variant="outlined"
          :rules="[rules.maxLength(10)]"
        />

        <v-text-field
          v-model="user.postalCode"
          label="Postleitzahl"
          variant="outlined"
          :rules="[rules.postalCode]"
        />

        <v-textarea
          v-model="user.message"
          label="Nachricht"
          auto-grow
          rows="3"
          variant="outlined"
          :rules="[rules.maxLength(500)]"
        />

        <v-btn
          type="submit"
          :loading="isSubmitting"
          color="primary"
          block
          class="mt-2"
        >
          Anmelden
        </v-btn>

        <v-alert
          v-if="success"
          type="success"
          variant="tonal"
          class="mt-2"
        >
          Danke für deine Anmeldung!
        </v-alert>
        <v-alert
          v-if="error"
          type="error"
          variant="tonal"
          class="mt-2"
        >
          {{ error }}
        </v-alert>
      </v-form>
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
}
</style>
