<script setup lang="ts">
import { ref } from "vue";
import SignupOverlay from "@/components/SignupOverlay.vue";

const showOverlay = ref(false);
</script>

<template>
  <!-- Hauptbereich: Flexbox für horizontale & vertikale Zentrierung -->
  <div class="landing-root">
    <div class="landing-content">
      <h1 class="text-h3">Willkommen auf unserer Landingpage</h1>
      <p class="text-body-1">Melde dich jetzt an!</p>

      <v-btn
        color="primary"
        size="large"
        @click="showOverlay = true"
        elevation="3"
        class="open-overlay-btn"
      >
        Jetzt anmelden
      </v-btn>

      <SignupOverlay v-if="showOverlay" @close="showOverlay = false" />
    </div>
  </div>
</template>

<style scoped>
/* Der äußere Container zentriert vertikal + horizontal */
.landing-root {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh; /* Vollbildhöhe */
}

/* Der innere Stack ordnet Elemente dynamisch mit Abstand an */
.landing-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;

  /* dynamischer Abstand – wächst leicht mit Viewport */
  row-gap: clamp(0.75rem, 2vw, 2rem);
}

/* Optional: eigener Button-Stil */
.open-overlay-btn {
  background: #3b5cff;
  color: white;
  font-weight: 600;
  border: none;
  padding: 0.75rem 1.25rem;
  border-radius: 8px;
  cursor: pointer;
  transition: background 0.2s;
}
.open-overlay-btn:hover {
  background: #2c46d3;
}
</style>
