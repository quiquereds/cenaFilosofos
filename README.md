<h1 align="center">
  <br>
  <img src="https://github.com/quiquereds/cenaFilosofos/assets/70863031/f6c24b18-e7c7-492d-968b-40e643e9eb8f" alt="La Cena de los Filosofos">
  <br>
  La Cena de los Filósofos
  <br>
</h1>

<h4 align="center">Solución al problema propuesto por Edsger Dijkstra en 1965</h4>
<h4 align="center">Tema: Programación Concurrente | Exlusión Mutua </h4>

---
| ⚠️ | Este repositorio representa un trabajo de licenciatura para la materia de Programación Concurrente y se ha cargado a GitHub con fines educativos y de respaldo del programa, no se incluirá mantenimiento o soporte del mismo. |
| :--------: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |

## Descripción

Este problema es un ejercicio clásico dentro de la informática, el problema fue 
creado por Edsger Dijkstra en el año 1965 con la intención de reflejar el problema 
sobre la sincronización de los procesos en los sistemas operativos. 

El concepto fue 
basado en pensadores chinos, que comían utilizando dos palillos. 
Como descripción del ejercicio, tenemos cinco filósofos que están situados 
alrededor de una mesa y pasan el tiempo comiendo asi como pensando. Para cada 
filosofo, se tiene un platillo de fideos y un palillo situado a la izquierda de cada plato.

El objetivo es que los filósofos coman, pero para ello, requieren la utilización de dos 
palillos, por lo que cada filosofo puede tomar los que estén a su izquierda y derecha. 
Si el filosofo toma un tenedor y otro está ocupado, tendrá que esperar hasta que se 
desocupe para comer.

<div align="center">
  <img width=500 height=500 src="https://github.com/quiquereds/cenaFilosofos/assets/70863031/4c6f1712-889a-48ba-a991-17424245b53a"></img>
</div>

En caso de que los filósofos, tomen el palillo al mismo tiempo, causaría un 
interbloqueo, ya que ningún filosofo podrá comer, por lo que morirán de inanición 
por estar esperando de manera infinita. 

Por lo que el objetivo a desarrollar es que se tiene que crear un algoritmo que evite 
que los filósofos mueran de inanición. Para ello se pueden optar por múltiples 
soluciones:

- **Turno cíclico:** El algoritmo inicia por un filósofo que quiera comer, pasa su turno al de la derecha
y así sucesivamente, por lo que cada filósofo comería en su turno correspondiente. Pero si el número de
filósofos es alto, uno de ellos morirá antes de su turno.
- **Varios turnos:** Se pueden definir varios turnos, cada filósofo de igual manera come en su turno y cada
cierto tiempo se cambian las fichas.
- **Colas de palillos:** Se crea una lista de espera, y al filósofo que quiera comer, se agrega a la cola,
si el palillo está libre, este puede tomarlo para posteriormente comer y dejar libres los palillos una vez
termine de comer.
- **Resolución de conflictos en colas de tenedores:** Cada que un filósofo tome un palillo, deberá esperar
un tiempo aleatorio para obtener el segundo, si en ese lapso no lo consigue, deberá soltar el que tiene y
entrar a la cola nuevamente.
- **El portero del comedor:** Los filósofos deberán abandonar la mesa cuando ya no tengan hambre y cuando
quieran comer pueden volver(sentándose en la misma silla). El mecanismo de este método es controlar el
número de filósofos en la mesa, definiendo su número a n-1, ya que si hay n-1 filósofos tiene que haber
por lo menos uno que pueda comer con sus dos palillos.


## Implementación 

En este caso, se decidió implementar la solución por colas de palillos, donde el filósofo entra a una 
cola de espera cuando quiera comer, si el palillo izquierdo y derecho está disponible, este los tomará,
caso contrario, esperará hasta que uno se libere para empezar a comer.

### Indicadores gráficos

Además de que en el UI de la aplicación se muestra el log de eventos, para facilitar la compresión del
algoritmo se implementaron dos indicadores gráficos y uno a través de texto.

#### Indicador de estado del filósofo

Se muestran GIFs correspondientes al estado de cada filósofo:

| Estado             | Descripción                                                                |
| ----------------- | ------------------------------------------------------------------ |
| ![image](https://github.com/quiquereds/cenaFilosofos/assets/70863031/807faecc-dd4c-456b-b6ef-2485641cb0b0) | **Pensando:** Estado inicial del filósofo |
| ![image](https://github.com/quiquereds/cenaFilosofos/assets/70863031/fe3ae0c9-b58f-483d-83e0-a3aee57bb619) | **Esperando:** El filósofo quiere comer y espera que existan palillos disponibles |
| ![image](https://github.com/quiquereds/cenaFilosofos/assets/70863031/f33e22c3-44fe-47db-95c5-0ecd17d869ca) | **Comiendo:** El filósofo empieza a comer (los filósofos vecinos no podrán comer) |
| ![image](https://github.com/quiquereds/cenaFilosofos/assets/70863031/a09d984e-a12f-44d3-b5b0-82756b0b10a0) | **Durmiendo:** El filósofo deja los palillos (el hilo entra en suspensión) para volver al estado inicial |

#### Semáforo del palillo

Los palillos que se muestran en la mesa también cuentan con estados para que el programa muestre su estado:

| Estado             | Descripción                                                                |
| ----------------- | ------------------------------------------------------------------ |
| 🔴 | **Ocupado:** El palillo se encuentra ocupado por otro filósofo, por lo que ningún filósofo a su lado debe usarlo |
| 🟢 | **Libre:** Es el estado inicial, el palillo se encuentra libre para usarse |

#### Cuadro de cantidad de comidas por filósofo

En el recuadro azul de la izquierda, se refleja un contador que mostrará la cantidad de veces que ha comido
un filósofo de la mesa, por defecto, la aplicación está configurada para que cada filósofo coma 3 veces.

---

## <img align="left" alt="Rocket" width="35px" style="padding-right:10px;" src="https://user-images.githubusercontent.com/70863031/233245995-4b1c384b-ce46-49a4-b40a-4c74754ea23b.gif"/> ¿Cómo clonar el repositorio?

Para clonar este repositorio y lograr compilar este proyecto de forma local en tu computadora necesitas lo siguiente:

### 📋 Requisitos
* Tener instalado el Kit de Desarrollo de Java (JDK) versión `>= 11.0`
* Tener instalado algún IDE que permita trabajar con proyectos de Java
> Se recomienda usar NetBeans, ya que es el IDE que se utilizó para el desarrollo y pruebas del programa

### 👨‍💻 Preparación del entorno

#### Preparación del servicio web
Primero, clona este repositorio y accede al directorio del proyecto:
```bash
git https://github.com/quiquereds/cenaFilosofos.git
cd cenaFilosofos
```
Una vez que estés dentro del directorio del proyecto, ábrelo usando tu IDE favorito. En el caso de haber elegido NetBeans, puedes abrir el IDE y acceder al proyecto abriendo el directorio como proyecto directamente en la interfaz

### 🚀 Ejecución local

1. Despliega los paquetes fuente (Source Packages)
2. Accede al paquete de cena
3. Abre el proyecto `interfaz.java`
4. Ejecuta el archivo

## Tech Stack

<div align="center">
  <h3>Proyecto creado con Java y NetBeans</h3>
  <p align="center">
    <a href="https://skillicons.dev">
      <img src="https://skillicons.dev/icons?i=java,webpack" />
    </a>
  </p>
</div>


## Licencia

<p xmlns:cc="http://creativecommons.org/ns#" >This work is licensed under <a href="https://creativecommons.org/licenses/by/4.0/?ref=chooser-v1" target="_blank" rel="license noopener noreferrer" style="display:inline-block;">Creative Commons Attribution 4.0 International<img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/cc.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/by.svg?ref=chooser-v1" alt=""></a></p>

