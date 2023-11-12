# M13_PROJECTE1

## Exemple Bàsic REST API. JPA CRUD. Empresa
### Què farem
La nostra aplicació tindrà bàsicament les següents classes:
- ProjecteDamDawApplication.java. Defineix l’aplicació SpringBoot...
- Empresa.java. JPAEntity. L’objecte/entitat que consultem. I que voldrem fer “persistent”.
- EmpresaRepository.java. Extendrà CRUDRepository o JPARepository. Defineix els mètodes d’accés a la base de dades (o a la capa de persistència).
   - els mètodes add, borrar, modifica que vam fer amb l’ArrayList ja estarien implementats a CRUDRepository. Que a més, no els inserta, llegeix o esborra d’una llista, sinó d’una BD. No els haurem de crear. Els podem fer servir directament.
   - JPA és un ORM. Mapeja estructures d’una BD relacional a objectes Java.
   - En aquest cas només farem el llistat de llibres findAll
- EmpresaController.java. Exposa els mètodes que permeten connectar-se a l’aplicació a través de crides http. 

# ATENCIÓ
Aquest és un codi bàsic. No hi ha el més mínim control d'errors ni gestió d'excepcions



Veure Tutorial en pdf: [Mini_Ap_Spring_Boot_REST_API.pdf](Mini_Ap_Spring_Boot_REST_API.pdf)


# Index
- Què farem	
- Introducció REST	
- Generar el projecte Spring Boot	
- Crear la classe Empresa	
- Crear la classe Repository	
- Crear el Controller	
- Provar l’Api	
- Provar l’Api amb POSTMAN	
   - Ampliacions de la pràctica
   - Ús de la classe Optional de Java 8	
   - Control d’excepcions	
- Documentació de la RESTApi amb SWAGGER	
- Maven



# Introducció REST
REST: (Representational State Transfer) és un estil d’arquitectura per dissenyar serveis web: 
- els programes interactuen amb crides HTTP senzilles
- no manté l’estat
- exposa les URI’s en estructura de directoris
- transfereix XML o JSON

Les crides http:
- Per crear un recurs: farem servir un HTTP POST 
- Per consultar un recurs (o una col.lecció): farem servir un HTTP GET 
- Per actualitzar un recurs: farem servir un HTTP PUT
- Per eliminar un recurs: farem servir un HTTP DELETE 

Recordeu  que HTTP també defineix respostes estàndar
- 200 - SUCCESS
- 404 - RESOURCE NOT FOUND
- 400 - BAD REQUEST
- 201 - CREATED
- 401 - UNAUTHORIZED
- 415 - UNSUPPORTED TYPE - Representation not supported for the resource
- 500 - SERVER ERROR

El concepte clau d’un servei REST son els recursos exposats o endpoints. Un llibre, un usuari de facebook, una adreça de googleMaps, una event en un Calendari de Google… 

Aquest recursos son accessibles a través de URIs més o menys ben definides.
```
insert POST  /calendars/calendarId/events Creates an event. 
get GET  /calendars/calendarId/events/eventId Returns an event. 
```


### Perquè JSON
Aquesta és una de les decisions que pren SpringBoot (recordem que és un framework “convention over configuration”). Com que el més habitual és JSON, si no li diem el contrari inclou les dependències necessàries per treballar amb JSON. Si volem treballar amb XML només haurem d’afegir les dependències necessàries.
Qualsevol @RestController d’una aplicació SpringBoot per defecte retorna respostes JSON. (Si la llibreria Jackson2 està al classpath). I en una aplicació SpringBoot Web [spring-boot-starter-web] s’inclou automàticament
