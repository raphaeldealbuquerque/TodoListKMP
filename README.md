# Estudos Kotlin Multiplatform

Este projeto é destinado ao desenvolvimento de **estudos, experimentos e artigos** relacionados a **Kotlin Multiplatform (KMP)**, com foco em compartilhar conhecimento e explorar práticas de desenvolvimento para Android, iOS e outros targets suportados pelo KMP.

Ele contém exemplos de código compartilhado entre plataformas, integração com Compose Multiplatform e pontos específicos de cada plataforma para aprendizado prático.

## Estrutura do Projeto

* **[/composeApp](./composeApp/src)** – Código compartilhado entre aplicações Compose Multiplatform.
  - **[commonMain](./composeApp/src/commonMain/kotlin)** – Código comum a todos os targets.
  - **[iosMain](./composeApp/src/iosMain/kotlin)** – Código específico para iOS
  - **[androidMain](./composeApp/src/androidMain/kotlin)** – Código específico para Android.
  - Outras pastas seguem o mesmo padrão, para isolar código específico de cada plataforma.

* **[/iosApp](./iosApp/iosApp)** – Aplicação iOS. Mesmo que a interface seja compartilhada via Compose Multiplatform, é necessário este ponto de entrada para execução no Xcode. Também é o local para código SwiftUI específico.

## Como Executar

### Android

Para rodar a versão de desenvolvimento do app Android:
- **macOS/Linux**
```bash
./gradlew :composeApp:assembleDebug
```

- **Windows**
```bash
./gradlew.bat :composeApp:assembleDebug
```

### iOS
Para rodar a versão de desenvolvimento do app iOS:
- Abra o projeto `iosApp/iosApp.xcodeproj` no Xcode e execute a aplicação.
- Também é possível usar a configuração de execução pelo IDE, caso o suporte a Kotlin/Native esteja configurado.

## Objetivo do Projeto
- Servir como laboratório de estudos sobre Kotlin Multiplatform.
- Compartilhar exemplos práticos e boas práticas de desenvolvimento multiplataforma.
- Documentar aprendizados e desafios encontrados durante o desenvolvimento com KMP.
- Explorar integrações com bibliotecas populares e frameworks, como Compose Multiplatform.
- Fornecer uma base para artigos e tutoriais sobre desenvolvimento multiplataforma com Kotlin.
- Explorar a interoperabilidade entre plataformas usando Compose Multiplatform, SwiftUI e APIs nativas.

### Links úteis 
- [Documentação Oficial do Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Kotlin/Native](https://kotlinlang.org/docs/native-overview.html)
- [Kotlin Multiplatform Mobile (KMM)](https://kotlinlang.org/docs/mobile/home.html))
