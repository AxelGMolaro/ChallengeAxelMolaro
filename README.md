# Challenge

El proyecto actualmente consta de 3 componentes.

## Header
Contiene el logo.

## Formulario de votación

- Tiene 3 inputs.
- Usa reactive forms.
- El autocompletable pone el codigo del país. (Es mejorable)
- Si envio un voto con un mail que ya voto ese mismo no figura en la votacion.

## Table de top 10 paises mas votados

Un listado con los 10 paises mas votados.

## Como inicializar el proyecto

- Instalar Java 21
- Tener una version reciente de Node.js
- Instalar Angular 21
- En el proyecto Agular ejecutar
  ``` sh
   npm run install
   npm run start
  ```
- Con IJ abrir el proyecto java y correr el proyecto desde la clase CountryvoteApplication.java.



# Deudas técnicas

Por un tema de tiempos el proyecto cuenta con varias deudas técnicas.

- Tiene una arquitectura sencilla
- Tiene un manejo de estilos sin tanta estructura
- La parte visual puede estar mucho mas detallada y se pueden crear muchos mas componentes, pero por un tema de tiempos se desidió usar 4.
- El proyecto funciona a nivel local.
- El autocompletable se puede robustecer más y puede quedar mas UX , porque hoy pone el codigo del pais.
- Se puede implementar una alerta cuando se pone un mail que ya votó.