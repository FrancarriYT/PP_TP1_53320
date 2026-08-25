# PP_TP1_53320 — Trabajo Práctico N°1 (Paradigmas de Programación)

Autor: Francisco Carrizo  
Legajo: 53320  
Universidad Tecnológica Nacional — Facultad Regional Mendoza (UTN FRM)  
Carrera: Ingeniería en Sistemas de Información  

Fecha de última actualización: 2026-08-25

---

## Descripción general
Este repositorio contiene la resolución del Trabajo Práctico N° 1 de la cátedra Paradigmas de Programación, desarrollado en Java con Maven (No sabía bien si había que usar Maven o su versión de constructor de proyectos de IntelliJ, Disculpas por eso!) , utilizando IntelliJ IDEA. El proyecto está completo hasta el ejercicio 4, tal como lo solicitan las consignas.

Como desafío personal, además de las versiones "App" solicitadas en el enunciado, implementé variantes "AppConScanner" para practicar entrada por consola. También incorporé algunas pruebas (Testing), ya que programo en Java hace más de 5 años y busco sostener buenas prácticas.

---

## Consignas

   URL para clonar vía HTTPS (consignar en la entrega):
   - https://github.com/FrancarriYT/PP_TP1_53320.git  
   

2. Contenido del repositorio:
   - 2.1. Proyecto de código desarrollado hasta el ejercicio 4, generado con IntelliJ IDEA, listo para clonar y probar. 
   - 2.2. Este archivo README con documentación del proyecto implementado.
   - 2.3. Capturas de la salida por consola de ejecuciones del/los programa/s.


---

## Estructura del proyecto
Proyecto Maven estándar con paquetes por ejercicio:

- `src/main/java/dev/francarri/ej1`  
  • App.java (versión principal)  
  • AppConScanner.java (entrada por consola — desafío personal)  
  • Clases de dominio relacionadas (EventoUniversitario, Sala, etc.)

- `src/main/java/dev/francarri/ej2`  
  • App.java / AppConScanner.java  
  • Clases: Actividad, Estudiante, EventoUniversitario, Inscripcion, Sala, etc.

- `src/main/java/dev/francarri/ej3`  
  • App.java / AppConScanner.java  
  • Clases: Actividad, Charla, Taller, Estudiante, EventoUniversitario, Inscripcion, Sala, etc.

- `src/main/java/dev/francarri/ej4`  
  • App.java / AppConScanner.java  
  • Clases del ejercicio 4

- `src/test/java/dev/francarri/ej2`  
  • Pruebas unitarias de ejemplo para ejercitar Testing.

---

## Requisitos
- Java 17 o superior 
- Maven
- IntelliJ IDEA (Community o Ultimate)

---

## Cómo clonar e importar en IntelliJ IDEA
1. Clonar el repositorio:
   - HTTPS: `git clone https://github.com/FrancarriYT/PP_TP1_53320.git`
2. Abrir IntelliJ IDEA
3. Esperar a que IntelliJ importe el proyecto Maven y descargue las dependencias.

---

## Cómo compilar y ejecutar

- Ejecutar desde IntelliJ:
  - Abrir la clase `App.java` del ejercicio que corresponda (por ejemplo, `dev.francarri.ej1.App`) y presionar "Run".  
  - Alternativamente, ejecutar las variantes `AppConScanner.java` para interactuar por consola.

- Capturas de salida:
  - Generar y guardar las capturas de los ejercicios 1, 2 y 3 en `docs/capturas/` con los nombres sugeridos.

---

## Pruebas (Testing)
- Algunas pruebas de ejemplo se encuentran en `src/test/java/dev/francarri/ej2`.
- Ejecutar pruebas:
  - Desde IntelliJ: panel "Maven" → `test`

---

