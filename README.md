## PG-ARGUMENT SEPARATOR

Este programa es un separador de contenido de un fichero estatico. Este fichero [personas_500.txt](./src/net/salesianos/inputs/personas_500.txt) tiene 500 lineas con personas y sus atributos. Dicho atributos solo tienen dos posibles valores, en el caso de Belleza --> Guapo o Feo. El programa lee este fichero entero y lanza al mismo tiempo dos ficheros separando por el atributo que el usuario pida por pantalla.

## USO / EJECUCIÓN

Este programa se ejecuta por consola, en la consola se desplegará un menu tal que así:

                            /**** FILTRO DE PERSONAS ***/
                            Campos disponibles para filtrar:
                            1 - Sexo
                            2 - Altura
                            3 - Belleza
                            4 - Estado
                            5 - Vivo
                            6 - Salud
                            7 - Vista
                            Selecciona el número del campo:

Aqui el usuario introducira un valor del 1 al 7 dependiendo de por que atributo desee filtrar el listado de personas.
La salida de dicho programa se alojará en la cartepa outputs. 
No obstante, una vez el usuario pone por pantalla el valor, el programa da un feedback por consola dando las veces que hubo coincidencia en ambos
campos del atributo. Para una mejor y mas facil comprensión recomiendo ver la [imagen](./docs/CapturaEjecutado.png) de la consola cuando se ejecuta.

## Consideraciones:

El programa es de lo más simple que he podido hacer mediante mis propios medios y aún asi he necesitado apoyarme en otros proyectos para
su desarrollo. Una cosa que es bastante limitante es el hecho de que solo se puede filtrar por un atributo. En el proyecto inicial queria crear
un objeto persona que recibiera los valores de cada persona dentro del .txt e ir filtrando pero por complejidad me vi obligado a simplificarlo
bastante.
