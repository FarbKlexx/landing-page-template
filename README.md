# coupling Landing Page Template

#### Repository klonen
```bash
git clone https://github.com/FarbKlexx/landing-page-template.git
```

## Installation & Setup (Vue/Vuetify Frontend)

Das Frontend basiert auf **Vue 3**, **Vuetify 3** und **Vite**.  
Alle benötigten Abhängigkeiten werden automatisch anhand der [`package.json`](./package.json) installiert.

### Voraussetzungen
- **[Node.js 18+](https://nodejs.org/en/download)**

---

### Projekt starten

#### 1. In den Frontend-Ordner wechseln
```bash
cd frontend
```

#### 2. Alle npm-Dependencies installieren
```bash
npm install
```

#### 3. Entwicklungsserver starten
```bash
npm run dev
```

<details>
  <summary>Dependencies</summary>

Vollständige und aktuelle Liste findest du jederzeit in der Datei [`package.json`](./package.json).

#### Haupt-Frameworks
| Paket | Version | Zweck |
|--------|----------|-------|
| [Vue](https://vuejs.org/) | ^3.5.22 | Frontend-Framework |
| [Vuetify](https://vuetifyjs.com/) | ^3.10.9 | UI-Komponenten (Material Design) |
| [Axios](https://axios-http.com/) | ^1.13.2 | HTTP-Requests / API-Kommunikation |

#### Build- & Entwicklungs-Tools
| Paket | Version | Zweck |
|--------|----------|-------|
| [Vite](https://vitejs.dev/) | ^7.1.12 | Entwicklungsserver & Bundler |
| [vite-plugin-vuetify](https://github.com/vuetifyjs/vuetify-loader) | ^2.1.2 | Vuetify-Integration für Vite |
| [vite-plugin-vue-devtools](https://github.com/vuejs/devtools-next) | ^8.0.3 | Vue-Devtools für lokale Entwicklung |
| [@vitejs/plugin-vue](https://github.com/vitejs/vite/tree/main/packages/plugin-vue) | ^6.0.1 | Vue-Integration in Vite |
| [Sass](https://sass-lang.com/) | ^1.93.3 | CSS-Präprozessor |
| [npm-run-all2](https://github.com/raineorshine/npm-run-all2) | ^8.0.4 | Paralleles/serielles Ausführen mehrerer npm-Skripte |
| [jiti](https://github.com/unjs/jiti) | ^2.6.1 | Runtime-JS/TS-Loader |
| [TypeScript](https://www.typescriptlang.org/) | ^5.9.3 | Statisches Typ-System für JavaScript |
| [vue-tsc](https://github.com/vuejs/language-tools) | ^3.1.3 | Type-Checking & IntelliSense für Vue-Dateien |

#### Typdefinitionen & Konfiguration
| Paket | Version | Zweck |
|--------|----------|-------|
| [@tsconfig/node22](https://github.com/tsconfig/bases) | ^22.0.2 | TypeScript-Baseline-Konfiguration für Node 22 |
| [@types/node](https://github.com/DefinitelyTyped/DefinitelyTyped) | ^22.19.0 | TypeScript-Typen für Node.js |
| [@vue/tsconfig](https://github.com/vuejs/tsconfig) | ^0.8.1 | Empfohlene TS-Einstellungen für Vue-Projekte |

#### Linting & Code-Style
| Paket | Version | Zweck |
|--------|----------|-------|
| [ESLint](https://eslint.org/) | ^9.39.0 | Statische Codeanalyse |
| [eslint-plugin-vue](https://eslint.vuejs.org/) | ^10.5.1 | ESLint-Regeln für Vue-Komponenten |
| [@vue/eslint-config-typescript](https://github.com/vuejs/eslint-config-typescript) | ^14.6.0 | ESLint-Preset für TypeScript + Vue |
| [@vue/eslint-config-prettier](https://github.com/vuejs/eslint-config-prettier) | ^10.2.0 | Integration von Prettier in ESLint |
| [Prettier](https://prettier.io/) | ^3.6.2 | Code-Formatierung |

</details>

## Installation & Setup (Maven/Spring Boot Backend)

Dieses Projekt verwendet **Maven** als Build- und Dependency-Management-Tool.  
Alle benötigten Abhängigkeiten werden automatisch anhand der [`pom.xml`](./pom.xml) installiert.

### Voraussetzungen
- **[Java 21+](https://www.oracle.com/de/java/technologies/downloads/)**
- **[Maven 3.9+](https://maven.apache.org/install.html)**
- Internetzugang (für den ersten Download der Dependencies)

---

### Projekt bauen & starten

#### 1. In den Backend-Ordner wechseln
```bash
cd backend
```

#### 2. Alle Dependencies aus der pom.xml herunterladen und Projekt bauen
```bash
mvn clean install
```

#### 3. Anwendung starten
```bash
mvn spring-boot:run
```

#### 4. H2 Entwicklungs-Datenbank aufrufen
http://localhost:8080/h2-console/login.do

#### 5. SwaggerUI API Dokumentation aufrufen
http://localhost:8080/swagger-ui/index.html

<details>
  <summary>Dependencies</summary>

Vollständige und aktuelle Liste findest du jederzeit in der Datei: [`pom.xml`](./pom.xml)

## Backend-Abhängigkeiten (Spring Boot)

### Spring Boot Starter
| Dependency | Version | Zweck |
|-------------|----------|-------|
| **spring-boot-starter-web** | 3.5.7 (via Parent) | Web-Framework (REST Controller, JSON Handling, eingebetteter Tomcat) |
| **spring-boot-starter-data-jpa** | 3.5.7 | Datenbank-Zugriff über JPA / Hibernate |
| **spring-boot-starter-mail** | 3.5.7 | Versand von E-Mails (SMTP-Integration) |
| **spring-boot-starter-test** | 3.5.7 | JUnit 5 + Spring Test-Utilities |

### Datenbank & Persistenz
| Dependency | Version | Zweck |
|-------------|----------|-------|
| **H2 Database** (`com.h2database:h2`) | Laufzeit | In-Memory-Datenbank für Entwicklung & Tests |
| **Lombok** (`org.projectlombok:lombok`) | optional | Automatische Generierung von Getter/Setter, Builder usw. |

### API-Dokumentation
| Dependency | Version | Zweck |
|-------------|----------|-------|
| **springdoc-openapi-starter-webmvc-ui** | 2.6.0 | Integrierte Swagger-UI und OpenAPI 3 Doku unter `/swagger-ui.html` |

### Build-Plugins
| Plugin | Zweck |
|---------|--------|
| **maven-compiler-plugin** | Baut Java-Klassen mit Annotation-Processing für Lombok |
| **spring-boot-maven-plugin** | Erstellt ausführbares Jar und Startklasse (`mvn spring-boot:run`) |

### Projekt-Eigenschaften
| Property | Wert |
|-----------|-------|

| **Java-Version** | 21 |
| **Spring Boot Parent** | `org.springframework.boot:spring-boot-starter-parent:3.5.7` |

</details>
