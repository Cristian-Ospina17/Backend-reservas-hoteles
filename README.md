# Backend-reservas-hoteles
## ⚙️ Tecnologías utilizadas

* Java
* Spring Boot
* Maven
* Git & GitHub

---

## 🚀 Cómo ejecutar el proyecto

1. Clonar el repositorio:

bash
git clone https://github.com/Cristian-Ospina17/Backend-reservas-hoteles.git


2. Abrir en IntelliJ IDEA

3. Ejecutar la clase:


HotelBackendApplication.java


---
## 🌿 Flujo de trabajo en Git

Cada integrante debe:

1. Crear su propia rama:

bash
git checkout -b feature/nombre-integrante


2. Realizar cambios en el proyecto

3. Hacer commit:

bash
git add .
git commit -m "feat: aporte de [nombre]"


4. Subir su rama:

bash
git push origin feature/nombre-integrante


5. Crear Pull Request hacia main

---

## 👨‍💻 Integrantes y aportes

Cada integrante debe agregar su información aquí 👇

* ✏️ Nombre: ________

  * Rama: ________
  * Aporte: ________

---

## 📌 Reglas del equipo

✔ Todos deben hacer mínimo *1 commit*
✔ Usar nombres de ramas profesionales (feature/...)
✔ No trabajar directamente sobre main
✔ Todo cambio debe pasar por Pull Request

---

## 📊 Estructura del proyecto


src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
 ├── config/
 ├── factory/


---

## 🎯 Objetivo académico

Aplicar conceptos de:

* Arquitectura de software
* Patrones de diseño
* Control de versiones con Git
* Trabajo colaborativo

# StayEase - Sistema de Reservas de Hoteles

## Descripción

StayEase es un frontend de reservas de hoteles creado con HTML, CSS y JavaScript moderno. Ofrece búsqueda de hoteles, visualización de detalles, gestión de reservas y autenticación de usuarios.

## Características principales

- Listado de hoteles y hoteles destacados
- Buscador por nombre, ciudad o categoría
- Detalle de hotel con selección de fechas, cálculo de noches y total
- Pago simulado con selección de método
- Registro e inicio de sesión de usuarios
- Visualización y cancelación de reservas
- Panel de administración para crear y editar hoteles, y gestionar habitaciones
- Notificaciones y validación de formularios

## Estructura del proyecto

- index.html: Página principal del frontend
- detalle.html: Página de detalle de hotel y reserva
- login.html: Página de inicio de sesión
- registro.html: Página de registro de usuarios
- admin.html: Panel administrativo para usuarios con role admin
- style.css: Estilos globales
- detalle.css: Estilos específicos de la página de detalle
- app.js: Lógica principal de la página de inicio
- detalle.js: Lógica de la página de detalle de hotel
- auth.js: Gestión del flujo de autenticación y sesión en el frontend
- api.js: Consumo de endpoints del backend
- AuthService.js: Servicio de autenticación local
- utils.js: Utilidades de notificaciones, validación y formato
