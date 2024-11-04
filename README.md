# Proyecto de Spring Boot para Consumir una Api Soap
Este es un proyecto para el curso de Java con Spring Boot y consumo de API SOAP

## Requisitos
- Java 17+
- Maven 3.6+
- Spring Boot 3.3.5
- Spring framework 6.0.x

## Pasos después de clonar el repositorio
1. **Clonar el repositorio:**
    - git clone [url-del-repositorio]
2. **Navegar al directorio del proyecto:**
    - cd [nombre-del-proyecto]
3. **Generar el código a partir del WSDL y compilar el proyecto:**
	- ./mvnw compile
4. **Agregar target/generated-sources/wsimport al Java Build Path:**
    - **Para Eclipse:**
        - Haz clic derecho sobre el proyecto y selecciona Properties. 
        - Ve a Java Build Path > Source. 
        - Haz clic en Add Folder… y selecciona target/generated-sources/wsimport. 
        - Aplica los cambios y cierra la ventana.
    - **Para IntelliJ IDEA:**
        - Ve a File > Project Structure.
        - Selecciona Modules, luego el módulo de tu proyecto.
        - En Sources, haz clic en Add Content Root y selecciona target/generated-sources/wsimport.
        - Marca la carpeta como Generated Sources Root (puede que sea detectado automáticamente).
        - Aplica los cambios.