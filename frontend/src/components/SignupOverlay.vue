<script setup lang="ts">
import { ref } from "vue";
import { userService } from "@/api/userService";
import type { User } from "@/types/User";

const emit = defineEmits(["close"]);

const user = ref<User>({
  firstName: "",
  lastName: "",
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
      firstName: "",
      lastName: "",
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
  <div
      class="fixed inset-0 bg-black/50 backdrop-blur-sm flex items-center justify-center z-50"
      @click.self="emit('close')"
  >
    <div
        class="bg-card text-card-foreground w-11/12 max-w-lg p-6 rounded-xl shadow-lg relative"
    >
      <!-- Close -->
      <button
          @click="emit('close')"
          class="absolute top-3 right-3 text-muted-foreground hover:text-foreground"
      >
        ×
      </button>

      <h2 class="text-2xl font-bold mb-6">Anmeldung</h2>

      <form @submit.prevent="handleSubmit" class="space-y-4">

        <!-- Vorname + Nachname -->
        <div class="flex flex-col gap-4 md:flex-row">

          <!-- Vorname -->
          <div class="flex-1">
            <label class="text-sm font-medium block text-left">Vorname *</label>
            <input
                v-model="user.firstName"
                required
                class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2
               text-sm ring-offset-background placeholder:text-muted-foreground
               focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring
               focus-visible:ring-offset-2"
            />
          </div>

          <!-- Nachname -->
          <div class="flex-1">
            <label class="text-sm font-medium block text-left">Nachname *</label>
            <input
                v-model="user.lastName"
                required
                class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2
               text-sm ring-offset-background placeholder:text-muted-foreground
               focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring
               focus-visible:ring-offset-2"
            />
          </div>

        </div>

        <!-- Email -->
        <div>
          <label class="text-sm font-medium block text-left">E-Mail *</label>
          <input
              v-model="user.email"
              type="email"
              required
              class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2
             text-sm ring-offset-background placeholder:text-muted-foreground
             focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring
             focus-visible:ring-offset-2"
          />
        </div>

        <!-- Telefon -->
        <div>
          <label class="text-sm font-medium block text-left">Telefon</label>
          <input
              v-model="user.phone"
              class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2
             text-sm ring-offset-background placeholder:text-muted-foreground
             focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring
             focus-visible:ring-offset-2"
          />
        </div>

        <!-- Straße + Hausnummer + PLZ -->
        <div class="flex flex-col gap-4 md:flex-row">

          <!-- Straße -->
          <div class="flex-1 md:flex-[2]">
            <label class="text-sm font-medium block text-left">Straße</label>
            <input
                v-model="user.street"
                class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2
               text-sm ring-offset-background placeholder:text-muted-foreground
               focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring
               focus-visible:ring-offset-2"
            />
          </div>

          <!-- Hausnummer -->
          <div class="flex-1 md:flex-[1]">
            <label class="text-sm font-medium block text-left">Hausnummer</label>
            <input
                v-model="user.houseNumber"
                class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2
               text-sm ring-offset-background placeholder:text-muted-foreground
               focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring
               focus-visible:ring-offset-2"
            />
          </div>

          <!-- PLZ -->
          <div class="flex-1 md:flex-[1]">
            <label class="text-sm font-medium block text-left">Postleitzahl</label>
            <input
                v-model="user.postalCode"
                class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2
               text-sm ring-offset-background placeholder:text-muted-foreground
               focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring
               focus-visible:ring-offset-2"
            />
          </div>

        </div>

        <!-- Nachricht -->
        <div>
          <label class="text-sm font-medium block text-left">Nachricht</label>
          <textarea
              v-model="user.message"
              rows="3"
              class="flex min-h-[80px] w-full rounded-md border border-input bg-background px-3 py-2
             text-sm ring-offset-background placeholder:text-muted-foreground
             focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring
             focus-visible:ring-offset-2"
          ></textarea>
        </div>

        <!-- Submit -->
        <button
            type="submit"
            :disabled="isSubmitting"
            class="w-full inline-flex items-center justify-center rounded-md text-sm font-medium
           ring-offset-background transition-colors
           bg-primary text-primary-foreground hover:bg-primary/90
           h-10 px-4 py-2 disabled:opacity-50"
        >
          <span v-if="!isSubmitting">Absenden</span>
          <span v-else class="animate-pulse">Wird gesendet…</span>
        </button>

        <!-- Alerts -->
        <p
            v-if="success"
            class="mt-2 bg-green-100 text-green-700 px-3 py-2 rounded-md text-sm"
        >
          Danke für deine Anmeldung!
        </p>

        <p
            v-if="error"
            class="mt-2 bg-red-100 text-red-700 px-3 py-2 rounded-md text-sm"
        >
          {{ error }}
        </p>
      </form>


    </div>
  </div>
</template>



