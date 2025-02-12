# Bootcamp PowerUp API - Pragma

Este proyecto es parte de la iniciativa **On-Class**, una plataforma que facilita la organización de bootcamps tecnológicos, permitiendo la comunicación entre tutores y participantes. La API está diseñada para gestionar tecnologías, capacidades y bootcamps, asegurando una estructura sólida para el crecimiento en diversas áreas tecnológicas.

## Planteamiento

**On-Class** busca ofrecer oportunidades de crecimiento en carreras tecnológicas mediante bootcamps sincrónicos. Esta API servirá como backend para la plataforma web, permitiendo:

- La creación y gestión de tecnologías, capacidades y bootcamps.
- La organización de iteraciones de bootcamps con tutores y participantes.
- La administración de entregables para evaluar el progreso de los participantes.

## Tecnologías Utilizadas

- **Lenguaje:** Java
- **Framework:** Spring Boot
- **Documentación API:** OpenAPI
- **Pruebas Unitarias:** JUnit, Mockito
- **Base de Datos:** Cada microservicio persiste en su propia base de datos.

## Arquitectura

El proyecto sigue una **arquitectura hexagonal**, asegurando una separación clara entre la lógica de negocio y los puertos de entrada/salida. Cada microservicio es independiente y está documentado con OpenAPI.

## Historias de Usuario Implementadas

### Semana 1

1. **Registrar Tecnologías**  
   **Rol:** Admin  
   **Descripción:** Permite registrar tecnologías que serán utilizadas en las capacidades.  
   **Objetivo:** Saber a qué tecnologías apunta cada bootcamp.  
   **Criterios de Aceptación:**  
   - Cada tecnología tiene `id`, `nombre` y `descripción`.
   - El nombre de la tecnología no se puede repetir.
   - Todas las tecnologías deben tener una descripción.
   - El nombre tiene un máximo de 50 caracteres.
   - La descripción tiene un máximo de 90 caracteres.

2. **Listar Tecnologías**  
   **Rol:** Admin  
   **Descripción:** Permite listar las tecnologías registradas.  
   **Objetivo:** Visualizar tecnologías creadas.  
   **Criterios de Aceptación:**  
   - Listado ordenado ascendente o descendente por nombre.
   - El servicio debe estar paginado.

### Semana 2

3. **Registrar Capacidades**  
   **Rol:** Admin  
   **Descripción:** Permite registrar capacidades para agrupar tecnologías.  
   **Objetivo:** Organizar tecnologías en capacidades específicas.  
   **Criterios de Aceptación:**  
   - Cada capacidad tiene `id`, `nombre` y `descripción`.
   - Mínimo 3 tecnologías asociadas.
   - No puede haber tecnologías repetidas en una capacidad.
   - Máximo 20 tecnologías por capacidad.

4. **Listar Capacidades**  
   **Rol:** Admin  
   **Descripción:** Permite listar capacidades creadas.  
   **Objetivo:** Visualizar capacidades registradas.  
   **Criterios de Aceptación:**  
   - Listado ordenado por nombre o cantidad de tecnologías.
   - Servicio paginado.
   - Mostrar listado de tecnologías con `nombre` e `id`.

5. **Registrar Bootcamp**  
   **Rol:** Admin  
   **Descripción:** Permite registrar bootcamps para iniciar eventos.  
   **Objetivo:** Iniciar la organización de nuevos bootcamps.  
   **Criterios de Aceptación:**  
   - Cada bootcamp tiene `id`, `nombre`, `descripción` y capacidades asociadas.
   - Mínimo 1 capacidad y máximo 4 por bootcamp.

6. **Listar Bootcamps**  
   **Rol:** Admin  
   **Descripción:** Permite listar bootcamps creados.  
   **Objetivo:** Visualizar bootcamps registrados.  
   **Criterios de Aceptación:**  
   - Listado ordenado por nombre o cantidad de capacidades.
   - Servicio paginado.
   - Mostrar capacidades asociadas (`nombre`, `id`) y tecnologías (`nombre`, `id`).

