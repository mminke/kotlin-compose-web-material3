# Material 3 Web Components implementation for Kotlin Compose Web

State: WIP / ALPHA!!!!!

## Introduction

This project aims to implement the __Material3 Web Components__ for __Kotlin Compose Web__.

The Material3 Web Components are currently being developed and are still in alpha stage. Therefor this project is nowhere near stable as this project depends on the development of those web components.

Also, this project is in itself currently under development to get things working properly.

Links:

Material Design v3: https://m3.material.io/ 

Material3 Web Components: https://github.com/material-components/material-web

## Structure

There are two parts, the library which contains the components which can be used in your own projects and an example directory which is created to have a project showcasing the components from the library.

The examples project also is a good starting point to see how the components can be used.

The follow github page shows the current state of the components: https://mminke.github.io/kotlin-compose-web-material3/

## Alternative

If you are looking for a much more mature library for material design (as far as I can see material design 2), please have a look at:

https://github.com/mpetuska/kmdc

## Running locally

To run the example project locally start it using:

```bash
$ ./gradlew jsBrowserDevelopmentRun
```

## Usage

Currently, there is no general available artifact yet. Therefor the best way to start experimenting with this library is to:

1. Checkout the code (use git clone)
2. Build the library and publish the artifact to your local Maven repository:

    ```bash
    $ ./gradlew publishToMavenLocal
    ```

3. Add the dependency to the library in your own project:

   ```kotlin
   dependencies {
      implementation("web.compose.material3:web-material3-js:1.0-SNAPSHOT")
   }
    ```

4. To use the correct material design 3 styles and fonts use the MaterialTheme composable as a top level wrapper.

   For example

    ```kotlin
    MaterialTheme(defaultColorScheme, defaultFontScheme) {
        Row {
            NavigationBar {}
            Column { 
                FilledButton( { label = "Click me!" })
            }
        }
    }   
    ```
This uses the default color and font schemes.