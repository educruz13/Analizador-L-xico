# Analizador-L-xico
# Manual de Uso del Analizador Léxico

## Introducción
El Analizador Léxico es una herramienta que permite analizar el código fuente de un archivo CPP y dividirlo en tokens, identificando palabras clave, identificadores, números, cadenas, caracteres y otros elementos del lenguaje de programación.

## Requisitos
- Asegúrate de tener NetBeans instalado en tu sistema.

## Pasos para Usar el Analizador Léxico en NetBeans

1. **Descarga y Abre el Proyecto:**

   - Descarga el proyecto del Analizador Léxico desde la ubicación donde esté disponible (por ejemplo, GitHub).
   - Abre NetBeans y selecciona "File" (Archivo) > "Open Project" (Abrir Proyecto).
   - Selecciona el directorio donde descargaste el proyecto y ábrelo.

2. **Configuración de la Ruta del Archivo CPP:**

   - Abre el archivo "AnalizadorLexico.java" ubicado en la carpeta del proyecto.
   - Busca la línea que permite configurar la ruta del archivo CPP a analizar:

     ```java
     String nombreArchivo = "C:\\Users\\Daniel\\Desktop\\Analizador Lexico\\src\\analizador\\lexico\\prueba.cpp";
     ```

   - Modifica esta línea para que incluya la ruta completa del archivo CPP que deseas analizar:

     ```java
     String nombreArchivo = "C:\\ruta\\tu_archivo.cpp";
     ```

3. **Ejecución del Programa:**

   - Guarda los cambios realizados en "AnalizadorLexico.java".
   - Ejecuta el programa desde NetBeans. Para hacerlo, ve al menú "Run" (Ejecutar) y selecciona "Run File" (Ejecutar Archivo).

4. **Análisis del Archivo:**

   - El programa procesará el archivo CPP y realizará el análisis léxico para identificar los tokens. Esto puede tomar un momento, dependiendo del tamaño del archivo.

5. **Resultados del Análisis:**

   - Después de completar el análisis léxico, el programa mostrará los resultados en la ventana de salida de NetBeans. Verás una lista de tokens identificados junto con su tipo y lexema. Los tipos de tokens incluyen palabras reservadas, identificadores, números, cadenas, caracteres, comentarios, operadores y otros.

6. **Navegación y Exportación:**

   - Puedes navegar a través de los tokens identificados y analizar la salida en detalle. También tienes la opción de exportar los resultados a un archivo si deseas conservar un registro del análisis léxico.

## Elementos Utilizados en el Código

El código del Analizador Léxico utiliza los siguientes elementos:

- **Expresiones Regulares:** Se utilizan expresiones regulares para identificar patrones en el código fuente y clasificarlos en diferentes tipos de tokens.

- **Enumeraciones:** El código define una enumeración llamada `TipoToken` para representar los diferentes tipos de tokens.

- **Clases:** Se definen dos clases en el código:
   - `TipoToken`: Representa los tipos de tokens.
   - `Token`: Representa un token con un tipo y un lexema.

- **Lectura de Archivos:** Se utiliza la lectura de archivos para abrir y analizar el contenido del archivo CPP a procesar.

## Consejos Adicionales

- Asegúrate de configurar la ruta del archivo correctamente en "AnalizadorLexico.java" para obtener resultados precisos.
- La aplicación solo realiza análisis léxico y no ejecuta el código.
- Utiliza esta herramienta como una ayuda para entender la estructura de un programa.

¡Eso es todo! Ahora puedes utilizar el Analizador Léxico en NetBeans para analizar archivos de código fuente CPP y comprender su estructura de tokens.

