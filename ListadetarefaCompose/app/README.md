Configurando Firebase

https://firebase.google.com/?authuser=1

Passo a Passo
- Ir para o Console (https://console.firebase.google.com/u/1/?pli=1)
- Criar Projeto (Colocar nome ex.: Lista de Tarefa Compose)
- Opcional Desativar Google Analistics

Após o projeto criado configurar o Firebae
- Selecionar o tipo do projecto (Nosso caso é ANDROID)
- Colocar o Android package name (namespace = "com.gdev.listadetarefacompose") 
- Colocar o App nickname (optional) (Lista de Tarefa Compose)
- (Não fizemos) Opcional, se quiser logar com google ou facebook, vc deve add o Debug signing certificate SHA-1 (optional)
- Clicar para registrar o APP

- Fazer o Download do google-services.json file
- Move your downloaded google-services.json file
  into your module (app-level) root directory.


====================================================================
Add Firebase SDK
Follow Instructions for Gradle Kotlin DSL (build.gradle.kts)

Add the plugin as a dependency to your project-level build.gradle.kts file:
´
Root-level (project-level) Gradle file (<project>/build.gradle.kts):
plugins {
// ...

// Add the dependency for the Google services Gradle plugin
id("com.google.gms.google-services") version "4.4.2" apply false

}
Then, in your module (app-level) build.gradle.kts file, add both the google-services plugin and any Firebase SDKs that you want to use in your app:

Module (app-level) Gradle file (<project>/<app-module>/build.gradle.kts):
plugins {
id("com.android.application")

// Add the Google services Gradle plugin
id("com.google.gms.google-services")

...
}

dependencies {
// Import the Firebase BoM
implementation(platform("com.google.firebase:firebase-bom:33.2.0"))


// TODO: Add the dependencies for Firebase products you want to use
// When using the BoM, don't specify versions in Firebase dependencies
// https://firebase.google.com/docs/android/setup#available-libraries
}
By using the Firebase Android BoM, your app will always use compatible Firebase library versions. Learn more
=====================================================================================

Criando um banco de dados no Firebase
- Acesse seu APP: https://console.firebase.google.com/u/1/project/lista-de-tarefa-compose-149ca/firestore
- Clicar em Firestore Database 
- Create Database
- Apos a criação precisa trocar as regras de escrita/leitura do banco
- Acessar a regras (Rules)
- E permitir a escrita/leitura do banco sem estar autenticado (true)
```
rules_version = '2';

service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if true;
    }
  }
}
```
- E publicar regras


Adicionando Depencencia da CloudFirestore
Add dependencia a nivel de APP
 - implementation("com.google.firebase:firebase-firestore-ktx")