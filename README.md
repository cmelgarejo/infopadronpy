# infopadronpy

Este es un proyecto con la intención de encapsular los servicios web de todos los partidos políticos con el afán de tener acceso a nuestra información.

En Paraguay, se dá el caso en el que nos afilian/inscriben sin consentimiento a los partidos políticos, y para acceder a -nuestra- información debemos acudir en persona o por línea telefónica al TSJE (http://tsje.gov.py) lo cual es poco práctico; esta "multiafiliación" expone a las personas a una multa excesiva (200 jornales minimos) e inclusive cárcel. Es bien sabido que hasta figuran votos de personas ya fallecidas o infantes, qué impiden hacernos votar en distintas internas partidarias y exponernos a juicio? La poca jurisdicción del TSJE nos obliga a estar informados y tomar en nuestras manos la acción de verificar que no estén jugando con nuestra opinión.

Pueden ayudar a juntar más servicios de padrones, que sepan sean públicos, hasta ahora tengo dos ejemplos de solicitud de webservices públicos:

###ANR

URL: http://www.feednoticias.com/app/padrones/anr.php

POST /app/padrones/anr.php HTTP/1.1
Content-Length: 14
Content-Type: application/x-www-form-urlencoded
Host: www.feednoticias.com
Connection: Keep-Alive
User-Agent: Apache-HttpClient/UNAVAILABLE (java 1.4)

cedula=9999999

HTTP/1.1 200 OK
Date: Thu, 23 Jul 2015 14:51:27 GMT
Server: Apache
X-Powered-By: PHP/5.3.29
Vary: Accept-Encoding,User-Agent
Connection: close
Transfer-Encoding: chunked
Content-Type: text/xml;charset=UTF-8
```xml
<resultados>
  <resultado>
    <ci>
      9.999.999
    </ci>
    <apellido>
      Melgarejo Bresanovich
    </apellido>
    <nombre>
      Christian
    </nombre>
    <dpto>
      Central
    </dpto>
    <districto>
      Limpio
    </districto>
    <zona>
      Limpio
    </zona>
    <seccional>
      Limpio  2
    </seccional>
    <local>
      Colegio San Jose
    </local>
    <mesa>
      108
    </mesa>
    <orden>108
    </orden>
  </resultado>
</resultados>
```

###PLRA

URL: http://190.128.194.162/ws/rcp/consulta.php?cc=9999999&op=1

GET /ws/rcp/consulta.php?cc=9999999&op=1 HTTP/1.1
Host: 190.128.194.162
Connection: Keep-Alive
User-Agent: Apache-HttpClient/UNAVAILABLE (java 1.4)

HTTP/1.1 200 OK
Date: Thu, 23 Jul 2015 14:49:35 GMT
Server: Apache/2.2.24 (PowerStack)
Content-Length: 145
Connection: close
Content-Type: text/html; charset=UTF-8
```json
["9999999","CHRISTIAN","MELGAREJO","SAN LORENZO N\u00c2\u00ba5                      ","COL.NAC.CONCEPCION L.DE CHAVEZ","9","999"]
```

Información, sugerencias, código, servidores son todos bienvenidos :)
